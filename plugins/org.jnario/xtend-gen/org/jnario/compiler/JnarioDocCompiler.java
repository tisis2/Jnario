/**
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jnario.compiler;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import java.io.File;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.mwe.NameBasedFilter;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Pure;
import org.jnario.compiler.AbstractBatchCompiler;
import org.jnario.doc.AbstractDocGenerator;
import org.jnario.doc.DocOutputConfigurationProvider;
import org.jnario.report.Executable2ResultMapping;

@SuppressWarnings("all")
public class JnarioDocCompiler extends AbstractBatchCompiler {
  private Executable2ResultMapping resultMapping;
  
  @Property
  private String _resultFolder;
  
  @Inject
  private AbstractDocGenerator docGenerator;
  
  @Inject
  private IEncodingProvider.Runtime encodingProvider;
  
  private ResourceSet resourceSet;
  
  @Override
  public boolean compile() {
    this.loadResources();
    this.generateDocumentation(this.resultMapping);
    return true;
  }
  
  @Inject
  public Executable2ResultMapping setExecutable2ResultMapping(final Executable2ResultMapping resultMapping) {
    return this.resultMapping = resultMapping;
  }
  
  public ResourceSet loadResources() {
    ResourceSet _xblockexpression = null;
    {
      this.resourceSet = this.resourceSetProvider.get();
      this.encodingProvider.setDefaultEncoding(this.getFileEncoding());
      this.resourceSet.getLoadOptions().put(XtextResource.OPTION_ENCODING, this.getFileEncoding());
      final NameBasedFilter nameBasedFilter = new NameBasedFilter();
      nameBasedFilter.setExtension(this.fileExtensionProvider.getPrimaryFileExtension());
      final PathTraverser pathTraverser = new PathTraverser();
      final Predicate<URI> _function = new Predicate<URI>() {
        @Override
        public boolean apply(final URI input) {
          final boolean matches = nameBasedFilter.matches(input);
          if (matches) {
            JnarioDocCompiler.this.resourceSet.getResource(input, true);
          }
          return matches;
        }
      };
      pathTraverser.resolvePathes(this.getSourcePathDirectories(), _function);
      final File classDirectory = this.createTempDir("classes");
      this.installJvmTypeProvider(this.resourceSet, classDirectory);
      EcoreUtil.resolveAll(this.resourceSet);
      _xblockexpression = this.resourceSet;
    }
    return _xblockexpression;
  }
  
  public void generateDocumentation(final Executable2ResultMapping executable2ResultMapping) {
    final JavaIoFileSystemAccess javaIoFileSystemAccess = this.javaIoFileSystemAccessProvider.get();
    javaIoFileSystemAccess.setOutputPath(DocOutputConfigurationProvider.DOC_OUTPUT, this.outputPath);
    EList<Resource> _resources = this.resourceSet.getResources();
    for (final Resource r : _resources) {
      boolean _isValid = this.fileExtensionProvider.isValid(r.getURI().fileExtension());
      if (_isValid) {
        this.docGenerator.doGenerate(r, javaIoFileSystemAccess, executable2ResultMapping);
      }
    }
  }
  
  @Pure
  public String getResultFolder() {
    return this._resultFolder;
  }
  
  public void setResultFolder(final String resultFolder) {
    this._resultFolder = resultFolder;
  }
}

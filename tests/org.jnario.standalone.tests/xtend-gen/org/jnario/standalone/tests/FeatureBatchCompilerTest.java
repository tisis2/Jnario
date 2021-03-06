/**
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jnario.standalone.tests;

import com.google.inject.Inject;
import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.jnario.feature.compiler.FeatureBatchCompiler;
import org.jnario.jnario.test.util.ExtendedFeatureInjectorProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(ExtendedFeatureInjectorProvider.class)
@SuppressWarnings("all")
public class FeatureBatchCompilerTest {
  @Inject
  private FeatureBatchCompiler batchCompiler;
  
  private static String OUTPUT_DIRECTORY_WITH_SPACES = "./test result";
  
  private static String OUTPUT_DIRECTORY = "./test-result";
  
  private static String XTEND_SRC_DIRECTORY = "./testdata";
  
  private static String TEMP_DIRECTORY = "./test-temp-dir";
  
  @Before
  public void onSetup() {
    try {
      this.batchCompiler.setSourcePath(FeatureBatchCompilerTest.XTEND_SRC_DIRECTORY);
      this.batchCompiler.setOutputPath(FeatureBatchCompilerTest.OUTPUT_DIRECTORY);
      this.batchCompiler.setDeleteTempDirectory(true);
      this.batchCompiler.setUseCurrentClassLoaderAsParent(true);
      this.batchCompiler.setCurrentClassLoader(this.getClass().getClassLoader());
      new File(FeatureBatchCompilerTest.OUTPUT_DIRECTORY).mkdir();
      File _file = new File(FeatureBatchCompilerTest.OUTPUT_DIRECTORY);
      Files.cleanFolder(_file, null, true, false);
      new File(FeatureBatchCompilerTest.OUTPUT_DIRECTORY_WITH_SPACES).mkdir();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void onTearDown() {
    try {
      File _file = new File(FeatureBatchCompilerTest.OUTPUT_DIRECTORY);
      Files.cleanFolder(_file, null, true, true);
      File _file_1 = new File(FeatureBatchCompilerTest.OUTPUT_DIRECTORY_WITH_SPACES);
      Files.cleanFolder(_file_1, null, true, true);
      boolean _exists = new File(FeatureBatchCompilerTest.TEMP_DIRECTORY).exists();
      if (_exists) {
        File _file_2 = new File(FeatureBatchCompilerTest.TEMP_DIRECTORY);
        Files.cleanFolder(_file_2, null, true, true);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCompileTestData() {
    this.batchCompiler.compile();
    final FilenameFilter _function = new FilenameFilter() {
      @Override
      public boolean accept(final File dir, final String name) {
        return name.endsWith(".java");
      }
    };
    Assert.assertEquals(3, ((List<String>)Conversions.doWrapArray(new File((FeatureBatchCompilerTest.OUTPUT_DIRECTORY + "/test")).list(_function))).size());
  }
}

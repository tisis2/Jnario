/**
 * generated by Xtext
 */
package org.jnario.suite.formatting2;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.annotations.formatting2.XbaseWithAnnotationsFormatter;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.jnario.JnarioTypeDeclaration;
import org.jnario.suite.services.SuiteGrammarAccess;
import org.jnario.suite.suite.Reference;
import org.jnario.suite.suite.Suite;
import org.jnario.suite.suite.SuiteFile;

@SuppressWarnings("all")
public class SuiteFormatter extends XbaseWithAnnotationsFormatter {
  @Inject
  @Extension
  private SuiteGrammarAccess _suiteGrammarAccess;
  
  protected void _format(final SuiteFile suitefile, @Extension final IFormattableDocument document) {
    this.format(suitefile.getImportSection(), document);
    EList<JnarioTypeDeclaration> _xtendTypes = suitefile.getXtendTypes();
    for (final JnarioTypeDeclaration xtendTypes : _xtendTypes) {
      this.format(xtendTypes, document);
    }
  }
  
  protected void _format(final Suite suite, @Extension final IFormattableDocument document) {
    EList<XAnnotation> _annotations = suite.getAnnotations();
    for (final XAnnotation annotations : _annotations) {
      this.format(annotations, document);
    }
    EList<Reference> _elements = suite.getElements();
    for (final Reference elements : _elements) {
      this.format(elements, document);
    }
  }
  
  public void format(final Object suite, final IFormattableDocument document) {
    if (suite instanceof Suite) {
      _format((Suite)suite, document);
      return;
    } else if (suite instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)suite, document);
      return;
    } else if (suite instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)suite, document);
      return;
    } else if (suite instanceof XtextResource) {
      _format((XtextResource)suite, document);
      return;
    } else if (suite instanceof XAssignment) {
      _format((XAssignment)suite, document);
      return;
    } else if (suite instanceof XBinaryOperation) {
      _format((XBinaryOperation)suite, document);
      return;
    } else if (suite instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)suite, document);
      return;
    } else if (suite instanceof XFeatureCall) {
      _format((XFeatureCall)suite, document);
      return;
    } else if (suite instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)suite, document);
      return;
    } else if (suite instanceof XPostfixOperation) {
      _format((XPostfixOperation)suite, document);
      return;
    } else if (suite instanceof XWhileExpression) {
      _format((XWhileExpression)suite, document);
      return;
    } else if (suite instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)suite, document);
      return;
    } else if (suite instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)suite, document);
      return;
    } else if (suite instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)suite, document);
      return;
    } else if (suite instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)suite, document);
      return;
    } else if (suite instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)suite, document);
      return;
    } else if (suite instanceof XBlockExpression) {
      _format((XBlockExpression)suite, document);
      return;
    } else if (suite instanceof XCastedExpression) {
      _format((XCastedExpression)suite, document);
      return;
    } else if (suite instanceof XClosure) {
      _format((XClosure)suite, document);
      return;
    } else if (suite instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)suite, document);
      return;
    } else if (suite instanceof XConstructorCall) {
      _format((XConstructorCall)suite, document);
      return;
    } else if (suite instanceof XForLoopExpression) {
      _format((XForLoopExpression)suite, document);
      return;
    } else if (suite instanceof XIfExpression) {
      _format((XIfExpression)suite, document);
      return;
    } else if (suite instanceof XInstanceOfExpression) {
      _format((XInstanceOfExpression)suite, document);
      return;
    } else if (suite instanceof XReturnExpression) {
      _format((XReturnExpression)suite, document);
      return;
    } else if (suite instanceof XSwitchExpression) {
      _format((XSwitchExpression)suite, document);
      return;
    } else if (suite instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)suite, document);
      return;
    } else if (suite instanceof XThrowExpression) {
      _format((XThrowExpression)suite, document);
      return;
    } else if (suite instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)suite, document);
      return;
    } else if (suite instanceof XTypeLiteral) {
      _format((XTypeLiteral)suite, document);
      return;
    } else if (suite instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)suite, document);
      return;
    } else if (suite instanceof XAnnotation) {
      _format((XAnnotation)suite, document);
      return;
    } else if (suite instanceof SuiteFile) {
      _format((SuiteFile)suite, document);
      return;
    } else if (suite instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)suite, document);
      return;
    } else if (suite instanceof XExpression) {
      _format((XExpression)suite, document);
      return;
    } else if (suite instanceof XImportDeclaration) {
      _format((XImportDeclaration)suite, document);
      return;
    } else if (suite instanceof XImportSection) {
      _format((XImportSection)suite, document);
      return;
    } else if (suite instanceof EObject) {
      _format((EObject)suite, document);
      return;
    } else if (suite == null) {
      _format((Void)null, document);
      return;
    } else if (suite != null) {
      _format(suite, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(suite, document).toString());
    }
  }
}

/**
 * generated by Xtext
 */
package org.jnario.xbase.richstring.formatting2;

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
import org.jnario.xbase.richstring.services.XbaseWithRichstringGrammarAccess;
import org.jnario.xbase.richstring.xbasewithrichstring.RichString;

@SuppressWarnings("all")
public class XbaseWithRichstringFormatter extends XbaseWithAnnotationsFormatter {
  @Inject
  @Extension
  private XbaseWithRichstringGrammarAccess _xbaseWithRichstringGrammarAccess;
  
  protected void _format(final RichString richstring, @Extension final IFormattableDocument document) {
    EList<XExpression> _expressions = richstring.getExpressions();
    for (final XExpression expressions : _expressions) {
      this.format(expressions, document);
    }
  }
  
  public void format(final Object richstring, final IFormattableDocument document) {
    if (richstring instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)richstring, document);
      return;
    } else if (richstring instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)richstring, document);
      return;
    } else if (richstring instanceof XtextResource) {
      _format((XtextResource)richstring, document);
      return;
    } else if (richstring instanceof XAssignment) {
      _format((XAssignment)richstring, document);
      return;
    } else if (richstring instanceof XBinaryOperation) {
      _format((XBinaryOperation)richstring, document);
      return;
    } else if (richstring instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)richstring, document);
      return;
    } else if (richstring instanceof XFeatureCall) {
      _format((XFeatureCall)richstring, document);
      return;
    } else if (richstring instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)richstring, document);
      return;
    } else if (richstring instanceof XPostfixOperation) {
      _format((XPostfixOperation)richstring, document);
      return;
    } else if (richstring instanceof XWhileExpression) {
      _format((XWhileExpression)richstring, document);
      return;
    } else if (richstring instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)richstring, document);
      return;
    } else if (richstring instanceof RichString) {
      _format((RichString)richstring, document);
      return;
    } else if (richstring instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)richstring, document);
      return;
    } else if (richstring instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)richstring, document);
      return;
    } else if (richstring instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)richstring, document);
      return;
    } else if (richstring instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)richstring, document);
      return;
    } else if (richstring instanceof XBlockExpression) {
      _format((XBlockExpression)richstring, document);
      return;
    } else if (richstring instanceof XCastedExpression) {
      _format((XCastedExpression)richstring, document);
      return;
    } else if (richstring instanceof XClosure) {
      _format((XClosure)richstring, document);
      return;
    } else if (richstring instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)richstring, document);
      return;
    } else if (richstring instanceof XConstructorCall) {
      _format((XConstructorCall)richstring, document);
      return;
    } else if (richstring instanceof XForLoopExpression) {
      _format((XForLoopExpression)richstring, document);
      return;
    } else if (richstring instanceof XIfExpression) {
      _format((XIfExpression)richstring, document);
      return;
    } else if (richstring instanceof XInstanceOfExpression) {
      _format((XInstanceOfExpression)richstring, document);
      return;
    } else if (richstring instanceof XReturnExpression) {
      _format((XReturnExpression)richstring, document);
      return;
    } else if (richstring instanceof XSwitchExpression) {
      _format((XSwitchExpression)richstring, document);
      return;
    } else if (richstring instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)richstring, document);
      return;
    } else if (richstring instanceof XThrowExpression) {
      _format((XThrowExpression)richstring, document);
      return;
    } else if (richstring instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)richstring, document);
      return;
    } else if (richstring instanceof XTypeLiteral) {
      _format((XTypeLiteral)richstring, document);
      return;
    } else if (richstring instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)richstring, document);
      return;
    } else if (richstring instanceof XAnnotation) {
      _format((XAnnotation)richstring, document);
      return;
    } else if (richstring instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)richstring, document);
      return;
    } else if (richstring instanceof XExpression) {
      _format((XExpression)richstring, document);
      return;
    } else if (richstring instanceof XImportDeclaration) {
      _format((XImportDeclaration)richstring, document);
      return;
    } else if (richstring instanceof XImportSection) {
      _format((XImportSection)richstring, document);
      return;
    } else if (richstring instanceof EObject) {
      _format((EObject)richstring, document);
      return;
    } else if (richstring == null) {
      _format((Void)null, document);
      return;
    } else if (richstring != null) {
      _format(richstring, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(richstring, document).toString());
    }
  }
}

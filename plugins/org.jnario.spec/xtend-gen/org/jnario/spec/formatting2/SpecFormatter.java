/**
 * generated by Xtext
 */
package org.jnario.spec.formatting2;

import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
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
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.jnario.Assertion;
import org.jnario.ExampleCell;
import org.jnario.ExampleColumn;
import org.jnario.ExampleRow;
import org.jnario.JnarioField;
import org.jnario.JnarioFunction;
import org.jnario.JnarioMember;
import org.jnario.JnarioParameter;
import org.jnario.JnarioTypeDeclaration;
import org.jnario.Should;
import org.jnario.ShouldThrow;
import org.jnario.formatter.JnarioFormatter;
import org.jnario.spec.spec.After;
import org.jnario.spec.spec.Before;
import org.jnario.spec.spec.Example;
import org.jnario.spec.spec.ExampleGroup;
import org.jnario.spec.spec.SpecFile;

@SuppressWarnings("all")
public class SpecFormatter extends JnarioFormatter {
  protected void _format(final SpecFile specfile, @Extension final IFormattableDocument document) {
    this.format(specfile.getImportSection(), document);
    EList<JnarioTypeDeclaration> _xtendTypes = specfile.getXtendTypes();
    for (final JnarioTypeDeclaration xtendTypes : _xtendTypes) {
      this.format(xtendTypes, document);
    }
  }
  
  protected void _format(final ExampleGroup examplegroup, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.setNewLines(1, 1, 2);
      }
    };
    final ISemanticRegion open = document.append(this.textRegionExtensions.regionFor(examplegroup).keyword("{"), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    final ISemanticRegion close = document.prepend(this.textRegionExtensions.regionFor(examplegroup).keyword("}"), _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.indent();
      }
    };
    document.<ISemanticRegion, ISemanticRegion>interior(open, close, _function_2);
    this.format(examplegroup.getTargetType(), document);
    EList<JnarioMember> _members = examplegroup.getMembers();
    for (final JnarioMember members : _members) {
      this.format(members, document);
    }
    this.format(examplegroup.getAnnotationInfo(), document);
  }
  
  protected void _format(final JnarioMember jnariomember, @Extension final IFormattableDocument document) {
    EList<XAnnotation> _annotations = jnariomember.getAnnotations();
    for (final XAnnotation annotations : _annotations) {
      this.format(annotations, document);
    }
  }
  
  protected void _format(final Example example, @Extension final IFormattableDocument document) {
    this.format(example.getExpr(), document);
    this.format(example.getExpression(), document);
    this.format(example.getAnnotationInfo(), document);
  }
  
  protected void _format(final Before before, @Extension final IFormattableDocument document) {
    this.format(before.getExpression(), document);
    this.format(before.getAnnotationInfo(), document);
  }
  
  protected void _format(final After after, @Extension final IFormattableDocument document) {
    this.format(after.getExpression(), document);
    this.format(after.getAnnotationInfo(), document);
  }
  
  protected void _format(final JnarioField jnariofield, @Extension final IFormattableDocument document) {
    this.format(jnariofield.getType(), document);
    this.format(jnariofield.getInitialValue(), document);
    this.format(jnariofield.getAnnotationInfo(), document);
  }
  
  protected void _format(final JnarioFunction jnariofunction, @Extension final IFormattableDocument document) {
    EList<JvmTypeParameter> _typeParameters = jnariofunction.getTypeParameters();
    for (final JvmTypeParameter typeParameters : _typeParameters) {
      this.format(typeParameters, document);
    }
    this.format(jnariofunction.getReturnType(), document);
    EList<JnarioParameter> _parameters = jnariofunction.getParameters();
    for (final JnarioParameter parameters : _parameters) {
      this.format(parameters, document);
    }
    EList<JvmTypeReference> _exceptions = jnariofunction.getExceptions();
    for (final JvmTypeReference exceptions : _exceptions) {
      this.format(exceptions, document);
    }
    this.format(jnariofunction.getExpression(), document);
    this.format(jnariofunction.getAnnotationInfo(), document);
  }
  
  protected void _format(final Should should, @Extension final IFormattableDocument document) {
    this.format(should.getRightOperand(), document);
    this.format(should.getLeftOperand(), document);
  }
  
  protected void _format(final ShouldThrow shouldthrow, @Extension final IFormattableDocument document) {
    this.format(shouldthrow.getType(), document);
    this.format(shouldthrow.getExpression(), document);
  }
  
  @Override
  protected void _format(final XInstanceOfExpression xinstanceofexpression, @Extension final IFormattableDocument document) {
    this.format(xinstanceofexpression.getType(), document);
    this.format(xinstanceofexpression.getExpression(), document);
  }
  
  @Override
  protected void _format(final XBinaryOperation xbinaryoperation, @Extension final IFormattableDocument document) {
    this.format(xbinaryoperation.getRightOperand(), document);
    this.format(xbinaryoperation.getLeftOperand(), document);
  }
  
  protected void _format(final Assertion assertion, @Extension final IFormattableDocument document) {
    this.format(assertion.getExpression(), document);
  }
  
  protected void _format(final ExampleColumn examplecolumn, @Extension final IFormattableDocument document) {
    this.format(examplecolumn.getType(), document);
  }
  
  protected void _format(final ExampleRow examplerow, @Extension final IFormattableDocument document) {
    EList<ExampleCell> _cells = examplerow.getCells();
    for (final ExampleCell cells : _cells) {
      this.format(cells, document);
    }
  }
  
  protected void _format(final ExampleCell examplecell, @Extension final IFormattableDocument document) {
    this.format(examplecell.getExpression(), document);
  }
  
  protected void _format(final JnarioParameter jnarioparameter, @Extension final IFormattableDocument document) {
    EList<XAnnotation> _annotations = jnarioparameter.getAnnotations();
    for (final XAnnotation annotations : _annotations) {
      this.format(annotations, document);
    }
    this.format(jnarioparameter.getParameterType(), document);
  }
  
  public void format(final Object examplegroup, final IFormattableDocument document) {
    if (examplegroup instanceof ExampleGroup) {
      _format((ExampleGroup)examplegroup, document);
      return;
    } else if (examplegroup instanceof After) {
      _format((After)examplegroup, document);
      return;
    } else if (examplegroup instanceof Before) {
      _format((Before)examplegroup, document);
      return;
    } else if (examplegroup instanceof Example) {
      _format((Example)examplegroup, document);
      return;
    } else if (examplegroup instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)examplegroup, document);
      return;
    } else if (examplegroup instanceof ExampleCell) {
      _format((ExampleCell)examplegroup, document);
      return;
    } else if (examplegroup instanceof Should) {
      _format((Should)examplegroup, document);
      return;
    } else if (examplegroup instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)examplegroup, document);
      return;
    } else if (examplegroup instanceof XtextResource) {
      _format((XtextResource)examplegroup, document);
      return;
    } else if (examplegroup instanceof XAssignment) {
      _format((XAssignment)examplegroup, document);
      return;
    } else if (examplegroup instanceof XBinaryOperation) {
      _format((XBinaryOperation)examplegroup, document);
      return;
    } else if (examplegroup instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XFeatureCall) {
      _format((XFeatureCall)examplegroup, document);
      return;
    } else if (examplegroup instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)examplegroup, document);
      return;
    } else if (examplegroup instanceof XPostfixOperation) {
      _format((XPostfixOperation)examplegroup, document);
      return;
    } else if (examplegroup instanceof XWhileExpression) {
      _format((XWhileExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)examplegroup, document);
      return;
    } else if (examplegroup instanceof JnarioField) {
      _format((JnarioField)examplegroup, document);
      return;
    } else if (examplegroup instanceof JnarioFunction) {
      _format((JnarioFunction)examplegroup, document);
      return;
    } else if (examplegroup instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)examplegroup, document);
      return;
    } else if (examplegroup instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)examplegroup, document);
      return;
    } else if (examplegroup instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)examplegroup, document);
      return;
    } else if (examplegroup instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XBlockExpression) {
      _format((XBlockExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XCastedExpression) {
      _format((XCastedExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XClosure) {
      _format((XClosure)examplegroup, document);
      return;
    } else if (examplegroup instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)examplegroup, document);
      return;
    } else if (examplegroup instanceof XConstructorCall) {
      _format((XConstructorCall)examplegroup, document);
      return;
    } else if (examplegroup instanceof XForLoopExpression) {
      _format((XForLoopExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XIfExpression) {
      _format((XIfExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XInstanceOfExpression) {
      _format((XInstanceOfExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XReturnExpression) {
      _format((XReturnExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XSwitchExpression) {
      _format((XSwitchExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XThrowExpression) {
      _format((XThrowExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XTypeLiteral) {
      _format((XTypeLiteral)examplegroup, document);
      return;
    } else if (examplegroup instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)examplegroup, document);
      return;
    } else if (examplegroup instanceof XAnnotation) {
      _format((XAnnotation)examplegroup, document);
      return;
    } else if (examplegroup instanceof Assertion) {
      _format((Assertion)examplegroup, document);
      return;
    } else if (examplegroup instanceof JnarioMember) {
      _format((JnarioMember)examplegroup, document);
      return;
    } else if (examplegroup instanceof JnarioParameter) {
      _format((JnarioParameter)examplegroup, document);
      return;
    } else if (examplegroup instanceof ShouldThrow) {
      _format((ShouldThrow)examplegroup, document);
      return;
    } else if (examplegroup instanceof SpecFile) {
      _format((SpecFile)examplegroup, document);
      return;
    } else if (examplegroup instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)examplegroup, document);
      return;
    } else if (examplegroup instanceof XExpression) {
      _format((XExpression)examplegroup, document);
      return;
    } else if (examplegroup instanceof XImportDeclaration) {
      _format((XImportDeclaration)examplegroup, document);
      return;
    } else if (examplegroup instanceof XImportSection) {
      _format((XImportSection)examplegroup, document);
      return;
    } else if (examplegroup instanceof ExampleColumn) {
      _format((ExampleColumn)examplegroup, document);
      return;
    } else if (examplegroup instanceof ExampleRow) {
      _format((ExampleRow)examplegroup, document);
      return;
    } else if (examplegroup instanceof EObject) {
      _format((EObject)examplegroup, document);
      return;
    } else if (examplegroup == null) {
      _format((Void)null, document);
      return;
    } else if (examplegroup != null) {
      _format(examplegroup, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(examplegroup, document).toString());
    }
  }
}

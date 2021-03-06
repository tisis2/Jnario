/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/*
* generated by Xtext
*/
package org.jnario.spec.ui.contentassist;

import static com.google.common.collect.Iterables.filter;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions.VariableType;
import org.eclipse.xtext.common.types.xtext.ui.TypeMatchFilters;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.jnario.JnarioClass;
import org.jnario.JnarioField;
import org.jnario.JnarioPackage;
import org.jnario.JnarioParameter;
import org.jnario.spec.services.SpecGrammarAccess;
import org.jnario.spec.spec.SpecPackage;
import org.jnario.spec.spec.TestFunction;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
/**
 * @author Sebastian Benz - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class SpecProposalProvider extends AbstractSpecProposalProvider {
	
	@Inject private JdtVariableCompletions completions;
	@Inject private SpecGrammarAccess grammarAccess;
	
	@Override
	public void completeXAnnotation_AnnotationType(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, 
				TypeMatchFilters.all(IJavaSearchConstants.ANNOTATION_TYPE), acceptor);
	}
	
//	@Override
//	public void completeMockLiteral_Type(EObject model, Assignment assignment,
//			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
//		completeJavaTypes(context, XbasePackage.Literals.XTYPE_LITERAL__TYPE, 
//				TypeMatchFilters.all(IJavaSearchConstants.CLASS_AND_INTERFACE), acceptor);
//	}
	
	@Override
	public void completeType_TargetType(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, SpecPackage.Literals.EXAMPLE_GROUP__TARGET_TYPE, true, getQualifiedNameValueConverter(), new TypeMatchFilters.All(IJavaSearchConstants.TYPE), acceptor);
	}
	
	@Override
	public void completeMember_TargetType(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, SpecPackage.Literals.EXAMPLE_GROUP__TARGET_TYPE, true, getQualifiedNameValueConverter(), new TypeMatchFilters.All(IJavaSearchConstants.TYPE), acceptor);
	}
	
	@Override
	public void completeMember_TargetOperation(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeMember_TargetOperation(model, assignment, context, acceptor);
	}
	
	@Override
	public void completeXFeatureCall_Feature(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof TestFunction) {
			EObject xtendClass = model.eContainer();
			while(xtendClass != null && (xtendClass instanceof JnarioClass)){
				for (JnarioField field : filter(((JnarioClass)xtendClass).getMembers(), JnarioField.class)) {
					acceptor.accept(createCompletionProposal(field.getName(), field.getName(), getImage(field),  context));
				}
				xtendClass = xtendClass.eContainer();
			}
			createLocalVariableAndImplicitProposals(model, context, acceptor);
		}else if (model instanceof JnarioField) {
			createLocalVariableAndImplicitProposals(model, context, acceptor);
		} else {
			super.completeXFeatureCall_Feature(model, assignment, context, acceptor);
		}
	}

	// TODO NO_XTEND
	@Override
	public void complete_RICH_TEXT(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeInRichString(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_RICH_TEXT_START(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeInRichString(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_RICH_TEXT_END(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeInRichString(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_RICH_TEXT_INBETWEEN(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeInRichString(model, ruleCall, context, acceptor);
	}

//	@Override
//	public void complete_COMMENT_RICH_TEXT_END(EObject model, RuleCall ruleCall, ContentAssistContext context,
//			ICompletionProposalAcceptor acceptor) {
//		completeInRichString(model, ruleCall, context, acceptor);
//	}
//
//	@Override
//	public void complete_COMMENT_RICH_TEXT_INBETWEEN(EObject model, RuleCall ruleCall, ContentAssistContext context,
//			ICompletionProposalAcceptor acceptor) {
//		completeInRichString(model, ruleCall, context, acceptor);
//	}
	
	@Override
	public void completeParameter_Name(final EObject model, Assignment assignment, final ContentAssistContext context,
			final ICompletionProposalAcceptor acceptor) {
		if (model instanceof JnarioParameter) {
			final List<JnarioParameter> siblings = EcoreUtil2.getSiblingsOfType(model, JnarioParameter.class);
			Set<String> alreadyTaken = Sets.newHashSet();
			for(JnarioParameter sibling: siblings) {
				alreadyTaken.add(sibling.getName());
			}
			alreadyTaken.addAll(getAllKeywords());
			completions.getVariableProposals(model, JnarioPackage.Literals.JNARIO_PARAMETER__PARAMETER_TYPE,
					VariableType.PARAMETER, alreadyTaken, new JdtVariableCompletions.CompletionDataAcceptor() {
						public void accept(String replaceText, StyledString label, Image img) {
							acceptor.accept(createCompletionProposal(replaceText, label, img, context));
						}
					});
		} else {
			super.completeParameter_Name(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeMember_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof JnarioField) {
			// don't propose types everywhere but only if there's already an indicator for fields, e.g. static, extension, var, val
			completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, true,
					getQualifiedNameValueConverter(), new TypeMatchFilters.All(IJavaSearchConstants.TYPE), acceptor);
		}
	}
	
	@Override
	public void completeMember_ReturnType(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, true,
				getQualifiedNameValueConverter(), new TypeMatchFilters.All(IJavaSearchConstants.TYPE), acceptor);
	}
	
	@Override
	public void completeMember_Name(final EObject model, Assignment assignment, final ContentAssistContext context,
			final ICompletionProposalAcceptor acceptor) {
		if (model instanceof JnarioField) {
			//TODO go up type hierarchy and collect all local fields
			final List<JnarioField> siblings = EcoreUtil2.getSiblingsOfType(model, JnarioField.class);
			Set<String> alreadyTaken = Sets.newHashSet();
			for(JnarioField sibling: siblings) {
				alreadyTaken.add(sibling.getName());
			}
			alreadyTaken.addAll(getAllKeywords());
			completions.getVariableProposals(model, JnarioPackage.Literals.JNARIO_FIELD__TYPE,
					VariableType.INSTANCE_FIELD, alreadyTaken, new JdtVariableCompletions.CompletionDataAcceptor() {
						public void accept(String replaceText, StyledString label, Image img) {
							acceptor.accept(createCompletionProposal(replaceText, label, img, context));
						}
					});
		} else {
			super.completeMember_Name(model, assignment, context, acceptor);
		}
	}
	

	protected Set<String> getAllKeywords() {
		return GrammarUtil.getAllKeywords(grammarAccess.getGrammar());
	}
	
	protected void addGuillemotsProposal(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(new ConfigurableCompletionProposal("\u00AB\u00BB", context.getOffset(), context
				.getSelectedText().length(), 1));
	}
	
	public void completeInRichString(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		INode node = context.getCurrentNode();
		ITextRegion textRegion = node.getTextRegion();
		int offset = textRegion.getOffset();
		int length = textRegion.getLength();
		String currentNodeText = node.getText();
		if (currentNodeText.startsWith("\u00BB") && offset + 1 <= context.getOffset()
				|| currentNodeText.startsWith("'''") && offset + 3 <= context.getOffset()) {
			if (context.getOffset() > offset && context.getOffset() < offset + length)
				addGuillemotsProposal(context, acceptor);
		} else if (currentNodeText.startsWith("\u00AB\u00AB")) {
			try {
				IDocument document = context.getViewer().getDocument();
				int nodeLine = document.getLineOfOffset(offset);
				int completionLine = document.getLineOfOffset(context.getOffset());
				if (completionLine > nodeLine) {
					addGuillemotsProposal(context, acceptor);
				}
			} catch (BadLocationException e) {
				// ignore
			}
		}
	}
}

package de.bmw.carit.jnario.spec.scoping;

import static com.google.common.collect.Iterables.filter;
import static org.eclipse.xtext.scoping.Scopes.scopeFor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xtend2.scoping.Xtend2ScopeProvider;

import com.google.inject.Inject;

import de.bmw.carit.jnario.spec.naming.OperationNameProvider;
import de.bmw.carit.jnario.spec.spec.ExampleGroup;
import de.bmw.carit.jnario.spec.spec.SpecPackage;

/**
 */
@SuppressWarnings("restriction")
public class SpecScopeProvider extends Xtend2ScopeProvider {
	
	@Inject
	private OperationNameProvider operationNameProvider;
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if(reference == SpecPackage.Literals.EXAMPLE_GROUP__TARGET_OPERATION){
			return targetOperation(context, reference);
		}
		return super.getScope(context, reference);
	}

	private IScope targetOperation(EObject subject, EReference reference) {
		ExampleGroup context = EcoreUtil2.getContainerOfType(subject.eContainer(), ExampleGroup.class);
		if(context == null){
			return IScope.NULLSCOPE;
		}
		JvmDeclaredType targetType = context.getTargetType();
		if(targetType == null){
			return IScope.NULLSCOPE;
		}
		Iterable<JvmOperation> operations = filter(targetType.getMembers(), JvmOperation.class);
		return scopeFor(operations, operationNameProvider, IScope.NULLSCOPE);
	}
	
}

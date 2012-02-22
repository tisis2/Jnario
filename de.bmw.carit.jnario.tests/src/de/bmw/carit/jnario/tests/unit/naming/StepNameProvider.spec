/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.bmw.carit.jnario.tests.unit.naming

import com.google.inject.Inject
import de.bmw.carit.jnario.jnario.JnarioFactory
import de.bmw.carit.jnario.jnario.Step
import de.bmw.carit.jnario.runner.InstantiateWith
import de.bmw.carit.jnario.tests.util.ModelStore
import de.bmw.carit.jnario.tests.util.SpecTestInstantiator

import static de.bmw.carit.jnario.tests.util.Query.*
import de.bmw.carit.jnario.naming.StepNameProvider

/**
 * @author Sebastian Benz - Initial contribution and API
 */
@InstantiateWith(typeof(SpecTestInstantiator))
describe StepNameProvider{

	@Inject extension ModelStore modelStore
	
	it "should return null if the step has no name"{
		assert subject.nameOf(emptyStep) == null
	}
	
	it "should return null if the step has no reference"{
		assert subject.nameOf(emptyRef) == null
	}
	
	it "should return the name for a step with definition"{
		parseScenario('''
			Feature: Example
				Scenario: MyScenario
					Given a step with an implementation
						"the implementation"
		''')
		
		assert stepName == "Given a step with an implementation"
	}
	
	it "should return the name for a step with resolved reference"{
		parseScenario('''
			Feature: Example
				Scenario: MyScenario 2
					Given a step with a resolved reference
				Scenario: MyScenario 1
					Given a step with a resolved reference
						"implementation"
		''')
		
		assert stepName == "Given a step with a resolved reference"
	}
	
	it "should return the name for a step with unresolved reference"{
		parseScenario('''
			Feature: Example
				Scenario: MyScenario 2
					Given a step with an unresolved reference
		''')
		
		assert stepName == "Given a step with an unresolved reference"
	}
	
	def stepName(){
		val step = query(modelStore).first(typeof(Step))
		return subject.nameOf(step)
	}
	
	def emptyStep(){
		return JnarioFactory::eINSTANCE.createGiven
	}
	
	def emptyRef(){
		return JnarioFactory::eINSTANCE.createGivenReference
	}
	
}
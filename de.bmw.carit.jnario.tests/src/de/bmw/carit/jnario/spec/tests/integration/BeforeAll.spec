/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
 package de.bmw.carit.jnario.spec.tests.integration

import static de.bmw.carit.jnario.common.test.util.ResultMatchers.*


import static extension de.bmw.carit.jnario.tests.util.SpecExecutor.*


/**
 * @author Sebastian Benz - Initial contribution and API
 */ 
describe "BeforeAll" {
 
	it "should be executed before all tests"{
		val spec = '
			package bootstrap 
			
			describe "BeforeAll"{
				
				static int beforeExecutionCount = 0
				
				before all{
					beforeExecutionCount = beforeExecutionCount + 1
				}
				
				it "should be executed before all tests (1)"{
					beforeExecutionCount.should.be(1)
				}	
				
				it "should be executed before all tests (2)"{
					beforeExecutionCount.should.be(1)
				}	
			}
		'
		spec.execute.should.be(successful)
	}

}
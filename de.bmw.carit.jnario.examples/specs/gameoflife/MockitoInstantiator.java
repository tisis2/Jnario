/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package gameoflife;

import org.mockito.MockitoAnnotations;

import de.bmw.carit.jnario.runner.DefaultTestInstantiator;

public class MockitoInstantiator extends DefaultTestInstantiator {

	@Override
	public Object createTest(Class<?> klass) throws Exception {
		Object test = super.createTest(klass);
		MockitoAnnotations.initMocks(test);
		return test;
	}

}

/**
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jnario.suite.unit;

import org.eclipse.xtext.conversion.IValueConverter;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.suite.conversion.SuiteValueConverterService;
import org.jnario.suite.unit.SuiteValueConverterToStringSpec;
import org.jnario.suite.unit.SuiteValueConverterToValueSpec;
import org.junit.runner.RunWith;

@Contains({ SuiteValueConverterToStringSpec.class, SuiteValueConverterToValueSpec.class })
@Named("SuiteValueConverter")
@RunWith(ExampleGroupRunner.class)
@SuppressWarnings("all")
public class SuiteValueConverterSpec {
  final IValueConverter<String> subject = new SuiteValueConverterService().getSuiteValueConverter();
}

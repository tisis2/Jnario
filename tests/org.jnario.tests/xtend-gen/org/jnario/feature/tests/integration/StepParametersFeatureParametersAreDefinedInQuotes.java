/**
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jnario.feature.tests.integration;

import org.jnario.feature.tests.integration.StepParametersFeature;
import org.jnario.jnario.test.util.FeatureExecutor;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.StepArguments;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Named("Scenario: Parameters are defined in quotes")
@SuppressWarnings("all")
public class StepParametersFeatureParametersAreDefinedInQuotes extends StepParametersFeature {
  CharSequence jnarioFile;
  
  @Test
  @Order(0)
  @Named("When I have a feature with parameters")
  public void _whenIHaveAFeatureWithParameters() {
    final StepArguments args = new StepArguments("package bootstrap\nFeature: Test feature\n\tScenario: using fields in step definitions\n\t\tString x\n\t\tGiven some values \"3\", \"4\"\n\t\t\tx = args.get(0)\n\t\tThen it should be possible to get the value\n\t\t\tx => \"3\"\n");
    this.jnarioFile = JnarioIterableExtensions.<String>first(args);
  }
  
  @Test
  @Order(1)
  @Named("Then it should execute successfully")
  public void _thenItShouldExecuteSuccessfully() {
    FeatureExecutor.isSuccessful(this.jnarioFile);
  }
}

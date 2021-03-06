/**
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jnario.feature.tests.integration;

import org.jnario.feature.tests.integration.CalculatorFeature;
import org.jnario.jnario.test.util.FeatureExecutor;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.StepArguments;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Named("Scenario: Simple calculator test with background and references")
@SuppressWarnings("all")
public class CalculatorFeatureSimpleCalculatorTestWithBackgroundAndReferences extends CalculatorFeature {
  CharSequence jnarioFile;
  
  @Test
  @Order(0)
  @Named("When I have a feature with a background and references")
  public void _whenIHaveAFeatureWithABackgroundAndReferences() {
    final StepArguments args = new StepArguments("package demo\nFeature: Calculator\n  Background:\n   int result \n   Given a calculator\n  Scenario: Adding two numbers 2 \n   When I enter two numbers \"20\" and \"70\"\n       result = args.first.toInt + args.second.toInt\n   Then it returns \"90\"\n     \tresult => args.first.toInt\n  Scenario: Adding two numbers wer\n    When I enter two numbers \"20\" and \"80\"\n    Then it returns \"100\"   \n");
    this.jnarioFile = JnarioIterableExtensions.<String>first(args);
  }
  
  @Test
  @Order(1)
  @Named("Then it should execute successfully")
  public void _thenItShouldExecuteSuccessfully() {
    FeatureExecutor.isSuccessful(this.jnarioFile);
  }
}

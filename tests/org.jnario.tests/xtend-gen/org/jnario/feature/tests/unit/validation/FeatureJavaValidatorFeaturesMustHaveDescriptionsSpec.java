/**
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jnario.feature.tests.unit.validation;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.jnario.feature.feature.Feature;
import org.jnario.feature.tests.unit.validation.FeatureJavaValidatorSpec;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;

@Named("Features must have descriptions")
@RunWith(ExampleGroupRunner.class)
@SuppressWarnings("all")
public class FeatureJavaValidatorFeaturesMustHaveDescriptionsSpec extends FeatureJavaValidatorSpec {
  @Test
  @Named("\\\'\\\'\\\' Feature: \\\'\\\'\\\'.select[typeof[Feature]].assertErrorContains[\\\"description\\\"]")
  @Order(1)
  public void _featureSelectTypeofFeatureAssertErrorContainsDescription() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Feature: ");
    _builder.newLine();
    this.select(_builder, Feature.class).assertErrorContains("description");
  }
}

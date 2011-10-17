package com.perhab.bigdecimalchallenge;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import bigdecimalchallenge.test.InitialisationTest;
import bigdecimalchallenge.test.object.ObjectTests;
import bigdecimalchallenge.test.simplemath.SimpleMathTests;

@RunWith(Suite.class)
@SuiteClasses({
	InitialisationTest.class,
	ObjectTests.class,
	SimpleMathTests.class
})
public class TestSuite {
	
	@BeforeClass
	public static void impl() {
		System.setProperty("bigdecimalchallenge.impl", PerhabBigDecimal.class.getCanonicalName());
	}
}

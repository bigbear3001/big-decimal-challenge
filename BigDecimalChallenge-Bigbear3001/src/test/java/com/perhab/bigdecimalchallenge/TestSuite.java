package com.perhab.bigdecimalchallenge;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import bigdecimalchallenge.test.FullTests;
import bigdecimalchallenge.test.InitialisationTest;

@RunWith(Suite.class)
@SuiteClasses({
	FullTests.class
})
public class TestSuite {
	
	@BeforeClass
	public static void impl() {
		System.setProperty("bigdecimalchallenge.impl", PerhabBigDecimal.class.getCanonicalName());
	}
}
package bigdecimalchallenge.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import bigdecimalchallenge.test.simplemath.SimpleMathTests;

import junit.framework.TestSuite;
@RunWith(Suite.class)
@SuiteClasses({
	InitialisationTest.class,
	SimpleMathTests.class
})

public class FullTests extends TestSuite {

}

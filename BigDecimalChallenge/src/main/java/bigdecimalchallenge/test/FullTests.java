package bigdecimalchallenge.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import bigdecimalchallenge.test.object.ObjectTests;
import bigdecimalchallenge.test.simplemath.SimpleMathTests;
import bigdecimalchallenge.test.simplemathWithLargeNumbers.LargeNumbersMathTests;

import junit.framework.TestSuite;
@RunWith(Suite.class)
@SuiteClasses({
	InitialisationTest.class,
	ObjectTests.class,
	SimpleMathTests.class,
	LargeNumbersMathTests.class
})

public class FullTests extends TestSuite {

}

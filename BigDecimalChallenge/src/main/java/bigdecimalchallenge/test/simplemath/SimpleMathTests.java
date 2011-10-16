package bigdecimalchallenge.test.simplemath;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	AddTest.class,
	SubtractTest.class,
	MultiplyTest.class,
	DivideTest.class
})

public class SimpleMathTests extends TestSuite {
}

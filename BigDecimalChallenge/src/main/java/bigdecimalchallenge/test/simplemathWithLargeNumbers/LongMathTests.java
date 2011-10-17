package bigdecimalchallenge.test.simplemathWithLargeNumbers;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import bigdecimalchallenge.test.simplemath.AddTest;
import bigdecimalchallenge.test.simplemath.DivideTest;
import bigdecimalchallenge.test.simplemath.MultiplyTest;
import bigdecimalchallenge.test.simplemath.SimpleMathTest;
import bigdecimalchallenge.test.simplemath.SubtractTest;


import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	AddTest.class,
	SubtractTest.class,
	MultiplyTest.class,
	DivideTest.class
})

public class LongMathTests extends TestSuite {
	
	@BeforeClass
	public static void init() {
		SimpleMathTest.mode(SimpleMathTest.Mode.LONG);
	}
}

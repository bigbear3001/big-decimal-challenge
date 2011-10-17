package bigdecimalchallenge.test.simplemathWithLargeNumbers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	IntegerMathTests.class,
	LongMathTests.class
})

public class LargeNumbersMathTests extends TestSuite {
}

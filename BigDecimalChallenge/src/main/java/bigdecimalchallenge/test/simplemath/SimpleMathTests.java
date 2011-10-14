package bigdecimalchallenge.test.simplemath;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import bigdecimalchallenge.test.InitialisationTest;

import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	AddTest.class
})

public class SimpleMathTests extends TestSuite {
}

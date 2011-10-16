package bigdecimalchallenge.test.object;

import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	EqualsTest.class,
	CopyTest.class
})


public class ObjectTests extends TestSuite {

}

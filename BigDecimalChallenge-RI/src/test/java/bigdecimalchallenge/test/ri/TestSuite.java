package bigdecimalchallenge.test.ri;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import bigdecimalchallenge.ri.BigDecimalRI;
import bigdecimalchallenge.test.FullTests;

@RunWith(Suite.class)
@SuiteClasses({
	FullTests.class
})
public class TestSuite {
	
	@BeforeClass
	public static void impl() {
		System.setProperty("bigdecimalchallenge.impl", BigDecimalRI.class.getCanonicalName());
	}
}

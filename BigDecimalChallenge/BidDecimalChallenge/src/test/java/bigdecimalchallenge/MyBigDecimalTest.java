package bigdecimalchallenge;

import junit.framework.TestCase;

public abstract class MyBigDecimalTest extends TestCase {
	
	MyBigDecimal decimalToTest;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		decimalToTest = getImplementation().newInstance();
	}
	
	public abstract Class<MyBigDecimal> getImplementation();
}

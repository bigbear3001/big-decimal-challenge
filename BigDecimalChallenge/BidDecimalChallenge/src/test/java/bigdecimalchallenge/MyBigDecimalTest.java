package bigdecimalchallenge;

import junit.framework.TestCase;

public abstract class MyBigDecimalTest extends TestCase {
	
	MyBigDecimal decimalToTest;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		decimalToTest = getImplementation().newInstance().fromNumber(0);
	}
	
	public void testFromNumber() {
		MyBigDecimal value = decimalToTest.fromNumber(0);
		assertEquals("toString of 0 is not correct.", "0", value.toString());
		value = decimalToTest.fromNumber(0.66);
		assertEquals("toString of 0.66 is not correct.", "0.66", value.toString());
		value = decimalToTest.fromNumber(-0.12);
		assertEquals("toString of -0.12 is not correct.", "-0.12", value.toString());
	}
	
	public void testAdd() {
		MyBigDecimal value = decimalToTest.add(1);
		assertEquals("toString of 1 is not correct.", "1", value.toString());
		value = decimalToTest.add(1.99);
		assertEquals("toString of 2.99 is not correct.", "2.99", value.toString());
		value = decimalToTest.add(-1.66);
		assertEquals("toString of 1.33 is not correct.", "1.33", value.toString());
		
	}
	
	public abstract Class<? extends MyBigDecimal> getImplementation();
}

package bigdecimalchallenge;

import junit.framework.TestCase;

public abstract class InitialisationTest extends TestCase {
	
	BigDecimal decimalToTest;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		decimalToTest = getImplementation().newInstance().fromNumber(0);
	}
	
	public void test01FromNumberInteger() {
		BigDecimal value = decimalToTest.fromNumber(0);
		assertEquals("fromNumber of 0 is not correct.", "0", value.toString());
		value = decimalToTest.fromNumber(5);
		assertEquals("fromNumber of 5 is not correct.", "5", value.toString());
		value = decimalToTest.fromNumber(17);
		assertEquals("fromNumber of 17 is not correct.", "17", value.toString());
		value = decimalToTest.fromNumber(999);
		assertEquals("fromNumber of 999 is not correct.", "999", value.toString());
	}

	public void test02FromNumberDouble() {
		BigDecimal value = decimalToTest.fromNumber(0.66);
		assertEquals("fromNumber of 0.66 is not correct.", "0.66", value.toString());
		value = decimalToTest.fromNumber(0.67);
		assertEquals("fromNumber of 0.67 is not correct.", "0.67", value.toString());
		value = decimalToTest.fromNumber(999.67);
		assertEquals("fromNumber of 999.67 is not correct.", "999.67", value.toString());
		value = decimalToTest.fromNumber(-0.12);
		assertEquals("fromNumber of -0.12 is not correct.", "-0.12", value.toString());
	}

	
	public void test03ToNumber() throws NotANumberException {
		BigDecimal value = decimalToTest.fromNumber(0);
		assertEquals("toNumber of 0 is not correct.", 0, value.toNumber());
		value = decimalToTest.fromNumber(0.66);
		assertEquals("toNumber of 0.66 is not correct.", 0.66, value.toNumber());
		value = decimalToTest.fromNumber(-0.12);
		assertEquals("toNumber of -0.12 is not correct.", -0.12, value.toNumber());
		value = decimalToTest.fromNumber(-67890.12);
		assertEquals("toNumber of -67890.12 is not correct.", -67890.12, value.toNumber());
	}
	
	
	public void test04Add() {
		BigDecimal value = decimalToTest.add(1);
		assertEquals("add of 0 and 1 not correct.", "1", value.toString());
		value = decimalToTest.add(1.99);
		assertEquals("add of 1 and 1.99 not correct.", "2.99", value.toString());
		value = decimalToTest.add(-1.66);
		assertEquals("add of 2.99 and 1.66 not correct.", "1.33", value.toString());
		
	}
	
	public abstract Class<? extends BigDecimal> getImplementation();
}

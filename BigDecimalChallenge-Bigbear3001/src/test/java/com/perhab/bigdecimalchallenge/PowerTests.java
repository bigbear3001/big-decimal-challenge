package com.perhab.bigdecimalchallenge;

import static junit.framework.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class PowerTests {
	
	public void testPower(String base, String power) {
		Integer bInt = Integer.parseInt(power);
		BigDecimal result = new BigDecimal(base).pow(bInt);
		testPower(base, power, result.toPlainString());
	}
	
	public void testPower(String base, String power, String expected) {
		PerhabBigDecimal a = new PerhabBigDecimal(base);
		PerhabBigDecimal b = new PerhabBigDecimal(power);
		assertEquals(expected, a.power(b).toString());
	}
	
	@Test
	public void testPowerTen() {
		testPower("10", "0");
		testPower("10", "1");
		testPower("10", "2");
		testPower("10", "3");
		testPower("10", "4");
	}
	
	@Test
	public void testPowerTwo() {
		testPower("2", "0");
		testPower("2", "1");
		testPower("2", "2");
		testPower("2", "3");
		testPower("2", "4");
	}
	
	@Test
	public void testPowerInteger() {
		testPower(Integer.MAX_VALUE + "", "0");
		testPower(Integer.MAX_VALUE + "", "1");
		testPower(Integer.MAX_VALUE + "", "2");
		testPower(Integer.MAX_VALUE + "", "3");
		testPower(Integer.MAX_VALUE + "", "4");
	}
	
	@Test
	public void testNegativePower() {
		testPower("10", "-1", "0.1");
		testPower("10", "-2", "0.01");
		testPower("10", "-3", "0.001");
		testPower("10", "-4", "0.0001");
	}
	
	@Test
	public void testNegativePowerOfTwo() {
		testPower("2", "-1", "0.5");
		testPower("2", "-2", "0.25");
		testPower("2", "-3", "0.125");
		testPower("2", "-4", "0.0625");
	}
	
	
}

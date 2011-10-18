package com.perhab.bigdecimalchallenge;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class EqualsTests {
	
	@Test
	public void testEqual() {
		PerhabBigDecimal a = new PerhabBigDecimal("36.1234");
		PerhabBigDecimal b = new PerhabBigDecimal("36.1234");
		assertEquals(a, b);
	}
	
	@Test
	public void testEqualDifferentPlaces() {
		PerhabBigDecimal a = new PerhabBigDecimal("36.1234");
		PerhabBigDecimal b = new PerhabBigDecimal("36.123400000");
		assertEquals(a, b);
	}
	
	@Test
	public void testEqualDifferentPlaces2() {
		PerhabBigDecimal a = new PerhabBigDecimal("0000036.1234");
		PerhabBigDecimal b = new PerhabBigDecimal("36.1234");
		assertEquals(a, b);
	}
	
	@Test
	public void testFalseZero() {
		PerhabBigDecimal a = new PerhabBigDecimal("0");
		PerhabBigDecimal b = new PerhabBigDecimal("-0");
		assertEquals(a, b);
	}
	
	
}

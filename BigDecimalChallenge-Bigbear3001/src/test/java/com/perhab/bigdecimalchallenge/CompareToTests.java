package com.perhab.bigdecimalchallenge;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class CompareToTests {
	
	private static final int GREATER_THAN = 1;
	private static final int SMALLER_THAN = -1;
	private static final int EQUAL = 0;
	@Test
	public void testMorePlaces() {
		PerhabBigDecimal a = new PerhabBigDecimal("36");
		PerhabBigDecimal b = new PerhabBigDecimal("9");
		assertEquals(GREATER_THAN, a.compareTo(b));
	}
	
	@Test
	public void testMorePlacesDecimal() {
		PerhabBigDecimal a = new PerhabBigDecimal("36.12349");
		PerhabBigDecimal b = new PerhabBigDecimal("9.45689");
		assertEquals(GREATER_THAN, a.compareTo(b));
	}
	
	@Test
	public void testBiggerSamePlaces() {
		PerhabBigDecimal a = new PerhabBigDecimal("9");
		PerhabBigDecimal b = new PerhabBigDecimal("3");
		assertEquals(GREATER_THAN, a.compareTo(b));
	}
	
	@Test
	public void testBiggerSamePlacesDecimal() {
		PerhabBigDecimal a = new PerhabBigDecimal("9.1234");
		PerhabBigDecimal b = new PerhabBigDecimal("3.456890");
		assertEquals(GREATER_THAN, a.compareTo(b));
	}
	
	
	@Test
	public void testSmallerSamePlaces() {
		PerhabBigDecimal a = new PerhabBigDecimal("3");
		PerhabBigDecimal b = new PerhabBigDecimal("4");
		assertEquals(SMALLER_THAN, a.compareTo(b));
	}
	
	@Test
	public void testSmallerSamePlacesDecimal() {
		PerhabBigDecimal a = new PerhabBigDecimal("9.123400");
		PerhabBigDecimal b = new PerhabBigDecimal("9.456890");
		assertEquals(SMALLER_THAN, a.compareTo(b));
	}
	
	@Test
	public void testEqual() {
		PerhabBigDecimal a = new PerhabBigDecimal("36.1234");
		PerhabBigDecimal b = new PerhabBigDecimal("36.1234");
		assertEquals(EQUAL, a.compareTo(b));
	}
	
	@Test
	public void testEqualDifferentPlaces() {
		PerhabBigDecimal a = new PerhabBigDecimal("36.1234");
		PerhabBigDecimal b = new PerhabBigDecimal("36.123400000");
		assertEquals(EQUAL, a.compareTo(b));
	}
	
	@Test
	public void testEqualDifferentPlaces2() {
		PerhabBigDecimal a = new PerhabBigDecimal("0000036.1234");
		PerhabBigDecimal b = new PerhabBigDecimal("36.1234");
		assertEquals(EQUAL, a.compareTo(b));
	}

	@Test
	public void testNegativePositive() {
		PerhabBigDecimal a = new PerhabBigDecimal("-9");
		PerhabBigDecimal b = new PerhabBigDecimal("9");
		assertEquals(SMALLER_THAN, a.compareTo(b));
	}
	
	@Test
	public void testPositiveNegative() {
		PerhabBigDecimal a = new PerhabBigDecimal("4.25");
		PerhabBigDecimal b = new PerhabBigDecimal("-2.23");
		assertEquals(GREATER_THAN, a.compareTo(b));
	}
	
	@Test
	public void testNegative() {
		PerhabBigDecimal a = new PerhabBigDecimal("-9");
		PerhabBigDecimal b = new PerhabBigDecimal("-8");
		assertEquals(SMALLER_THAN, a.compareTo(b));
	}
	
	@Test
	public void testBothNegative() {
		PerhabBigDecimal a = new PerhabBigDecimal("-1.25");
		PerhabBigDecimal b = new PerhabBigDecimal("-2.23");
		assertEquals(GREATER_THAN, a.compareTo(b));
	}
	
	@Test
	public void testMoreDecimalPlaces() {
		PerhabBigDecimal a = new PerhabBigDecimal("-2.2312");
		PerhabBigDecimal b = new PerhabBigDecimal("-2.23");
		assertEquals(SMALLER_THAN, a.compareTo(b));
	}
	
	@Test
	public void testLessDecimalPlaces() {
		PerhabBigDecimal a = new PerhabBigDecimal("-2.23");
		PerhabBigDecimal b = new PerhabBigDecimal("-2.2312");
		assertEquals(GREATER_THAN, a.compareTo(b));
	}
	
	@Test
	public void testSmaller() {
		PerhabBigDecimal a = new PerhabBigDecimal("0.36");
		PerhabBigDecimal b = new PerhabBigDecimal("9");
		assertEquals(SMALLER_THAN, a.compareTo(b));
	}
	
	@Test
	public void testFalseZero() {
		PerhabBigDecimal a = new PerhabBigDecimal("0");
		PerhabBigDecimal b = new PerhabBigDecimal("-0");
		assertEquals(EQUAL, a.compareTo(b));
	}
	
	
}

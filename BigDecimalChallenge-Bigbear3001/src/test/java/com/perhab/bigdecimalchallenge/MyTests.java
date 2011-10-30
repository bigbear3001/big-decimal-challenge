package com.perhab.bigdecimalchallenge;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class MyTests {
	
	@Test
	public void testDivide() {
		PerhabBigDecimal a = new PerhabBigDecimal("36");
		PerhabBigDecimal b = new PerhabBigDecimal("9");
		assertEquals("4", a.divide(b).toString());
	}
	
	
	@Test
	public void testDivide2() {
		PerhabBigDecimal a = new PerhabBigDecimal("459");
		PerhabBigDecimal b = new PerhabBigDecimal("9");
		assertEquals("51", a.divide(b).toString());
	}
	
	
	@Test
	public void testDivide3() {
		PerhabBigDecimal a = new PerhabBigDecimal("1004916");
		PerhabBigDecimal b = new PerhabBigDecimal("110");
		assertEquals("9135.6", a.divide(b).toString());
	}
	
	@Test
	public void testDivide4() {
		PerhabBigDecimal a = new PerhabBigDecimal("7604916");
		PerhabBigDecimal b = new PerhabBigDecimal("110");
		assertEquals("69135.6", a.divide(b).toString());
	}
}

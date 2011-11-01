package com.perhab.bigdecimalchallenge;

import static junit.framework.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class MyTests {
	
	@Test
	@Ignore
	public void testDivide() {
		PerhabBigDecimal a = new PerhabBigDecimal("36");
		PerhabBigDecimal b = new PerhabBigDecimal("9");
		assertEquals("4", a.divide(b, 0).toString());
	}
	
	@Test
	@Ignore
	public void testDivide2() {
		PerhabBigDecimal a = new PerhabBigDecimal("459");
		PerhabBigDecimal b = new PerhabBigDecimal("9");
		assertEquals("51", a.divide(b, 0).toString());
	}
	
	@Test
	@Ignore
	public void testDivide3() {
		PerhabBigDecimal a = new PerhabBigDecimal("1004916");
		PerhabBigDecimal b = new PerhabBigDecimal("110");
		assertEquals("9135.6", a.divide(b, 1).toString());
	}
	
	@Test
	@Ignore
	public void testDivide4() {
		PerhabBigDecimal a = new PerhabBigDecimal("7604916");
		PerhabBigDecimal b = new PerhabBigDecimal("110");
		assertEquals("69135.6", a.divide(b, 1).toString());
	}
	
	@Test
	@Ignore
	public void testDivide5() {
		PerhabBigDecimal a = new PerhabBigDecimal("0.1");
		PerhabBigDecimal b = new PerhabBigDecimal("10");
		assertEquals("0.01", a.divide(b, 2).toString());
	}
	
	@Test
	public void testDivide6() {
		PerhabBigDecimal a = new PerhabBigDecimal("1");
		PerhabBigDecimal b = new PerhabBigDecimal("9");
		assertEquals("0.11", a.divide(b, 2).toString());
	}
	
	@Test
	public void testDivide7() {
		PerhabBigDecimal a = new PerhabBigDecimal("555");
		PerhabBigDecimal b = new PerhabBigDecimal("1000");
		assertEquals("0.56", a.divide(b, 2).toString());
	}
	
	@Test
	public void testDivide8() {
		PerhabBigDecimal a = new PerhabBigDecimal("9");
		PerhabBigDecimal b = new PerhabBigDecimal("55");
		assertEquals("0.16364", a.divide(b, 5).toString());
	}
	
	
	@Test
	public void testDivide9() {
		PerhabBigDecimal a = new PerhabBigDecimal("1");
		PerhabBigDecimal b = new PerhabBigDecimal("15");
		assertEquals("0.06667", a.divide(b, 5).toString());
	}
	
	
}

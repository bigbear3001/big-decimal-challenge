package bigdecimalchallenge.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bigdecimalchallenge.BigDecimal;

/**
 * Tests the initialization of the BigDecimal implementation and the toString method.
 * 
 * @author fgutmann
 */
public class InitialisationTest extends BigDecimalTest {

	final static Logger logger = LoggerFactory.getLogger(InitialisationTest.class);
	
	/**
	 * Creates a big decimal from the given string and asserts that it is equal to the toString() output.
	 * Provides a nice error message on failure.
	 * 
	 * @param numberString The number as string to test
	 */
	private void assertCreation(String numberString) {
		logger.debug("Testing big decimal creation of number \"{}\"", numberString);
		
		BigDecimal<Object> bigDecimal = number(numberString);
		assertEquals("Creating number from String " + numberString + " doesn't equal number.toString()", numberString, bigDecimal.toString());
	}
	
	/**
	 * Tests integers either positive or negative
	 * 
	 * @param positive If the integers should be positive or negative
	 */
	public void testInteger(boolean positive) {
		// digits, one to hundred
		for(String number : Numbers.digits) {
			if(!positive && number.equals("0")) {
				continue; // skip -0
			}
			assertCreation((positive ? "" : "-") + number);
		}
		
		// 1 to 100
		for(String number : Numbers.oneToHundred) {
			assertCreation((positive ? "" : "-") + number);
		}
		
		// 1, 12, 123, 1234, 12345, ... until 1000 digits
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < 1000; i++) {
			builder.append((i + 1) % 10);
			assertCreation((positive ? "" : "-") + builder.toString());
		}
	}
	
	/**
	 * Tests for creating floating point Operations
	 * 
	 * @param positive If the numbers should be positive or negative
	 */
	public void testFloatingPoint(boolean positive) {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.digits.length; j++) {
				assertCreation((positive ? "" : "-") + Numbers.digits[i] + "." + Numbers.digits[j]);
			}
		}
		
		for(int k = 0; k < Numbers.oneToHundred.length; k++) {
			for(int l = 0; l < Numbers.oneToHundred.length; l++) {
				assertCreation((positive ? "" : "-") + Numbers.oneToHundred[k] + "." + Numbers.oneToHundred[l]);
			}
		}
	}
	
	/**
	 * Tests for initializing positive floating points
	 */
	@Test
	public void positiveFloatingPoint() {
		testFloatingPoint(true);
	}
	
	/**
	 * Tests for initializing negative floating points
	 */
	@Test
	public void negativeFloatingPoint() {
		testFloatingPoint(false);
	}
	
	/**
	 * Tests initialization of positive integer values
	 */
	@Test
	public void positiveInteger() {
		testInteger(true);
	}
	
	/**
	 * Tests initialization of negative integers
	 */
	@Test
	public void negativeInteger() {
		testInteger(false);
	}
}

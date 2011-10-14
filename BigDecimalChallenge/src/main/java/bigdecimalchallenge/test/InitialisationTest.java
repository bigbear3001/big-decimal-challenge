package bigdecimalchallenge.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import bigdecimalchallenge.BigDecimal;

/**
 * Tests the initialization of the BigDecimal implementation and the toString method.
 * 
 * @author fgutmann
 */
public class InitialisationTest extends BigDecimalTest {

	/**
	 * Creates a big decimal from the given string and asserts that it is equal to the toString() output.
	 * Provides a nice error message on failure.
	 * 
	 * @param numberString The number as string to test
	 */
	private void assertCreation(String numberString) {
		System.out.println("Creating number from String " + numberString + " doesn't equal number.toString()");
		BigDecimal<Object> bigDecimal = number(numberString);
		assertEquals("Creating number from String " + numberString + " doesn't equal number.toString()", numberString, bigDecimal.toString());
	}
	
	/**
	 * Tests integers either positive or negative
	 * 
	 * @param positive If the integers should be positive or negative
	 */
	public void integer(boolean positive) {
		
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
	 * Tests initialization of positive integer values
	 */
	@Test
	public void positiveInteger() {
		integer(true);
	}
	
	/**
	 * Tests initialization of negative integers
	 */
	@Test
	public void negativeInteger() {
		integer(false);
	}
}

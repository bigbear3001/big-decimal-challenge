package bigdecimalchallenge.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import bigdecimalchallenge.BigDecimal;

/**
 * Tests the initialization of the BigDecimal implementation and the toString method.
 * 
 * @author fgutmann
 */
public class InitialisationTest {
	
	/**
	 * Tests integers either positive or negative
	 * 
	 * @param positive If the integers should be positive or negative
	 */
	public void integer(boolean positive) {
		// all digits
		for(String number : Numbers.digits) {
			assertEquals("Creating number from String " + number + " doesn't equal number.toString()", number, bd.toString());
		}
		
//		// some simple numbers
//		for (String number : integers) {
//			if(!positive) {
//				number = "-" + number;
//			}
//			
//			BigDecimal<?> bd = TestUtils.createInstance(number);
//			assertEquals("Creating number from String " + number + " doesn't equal number.toString()", number, bd.toString());
//		}
//		
//		// all numbers concatenated together
//		StringBuilder largeInteger = new StringBuilder();
//		for(String number : integers) {
//			largeInteger.append(number);
//		}
//		
//		// double the integer digits every run and test initialisation
//		for (int i = 0; i < 10; i++) {
//			BigDecimal<?> bd = TestUtils.createInstance(largeInteger.toString());
//			assertEquals("Creating number from String " + largeInteger.toString() + " doesn't equal number.toString()", largeInteger.toString(), bd.toString());
//			largeInteger.append(largeInteger.toString());
//		}		
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

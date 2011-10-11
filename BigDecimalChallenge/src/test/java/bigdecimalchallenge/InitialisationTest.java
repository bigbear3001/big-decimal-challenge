package bigdecimalchallenge;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Tests the initialization of the BigDecimal implementation and the toString method.
 * 
 * @author fgutmann
 */
public class InitialisationTest {
	
	/**
	 * Tests initialization of positive integer values
	 */
	@Test
	public void positiveInteger() {
		String [] numbers = new String [] {
			"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"100", "1000", "1000", "10000", "100000", "100000", "1000000", "1000000",
		};
		
		// some simple numbers
		for (String number : numbers) {
			BigDecimal bd = TestUtils.createInstance(number);
			assertEquals("Creating number from String " + number + " doesn't equal number.toString()", number, bd.toString());
		}
		
		// all numbers concatenated together
		StringBuilder largeInteger = new StringBuilder();
		for(String number : numbers) {
			largeInteger.append(number);
		}
		for (int i = 0; i < 10; i++) {
			BigDecimal bd = TestUtils.createInstance(largeInteger.toString());
			assertEquals("Creating number from String " + largeInteger.toString() + " doesn't equal number.toString()", largeInteger.toString(), bd.toString());
			largeInteger.append(largeInteger.toString());
		}
	}
}

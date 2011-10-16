package bigdecimalchallenge.test.simplemath;

import static junit.framework.Assert.*;
import bigdecimalchallenge.BigDecimal;


/**
 * This tests the subtract method of the implementation. Therefore the result is compared to the java big decimal.
 * @author bigbear3001
 *
 */
public class SubtractTest extends SimpleMathTest {
	/**
	 * Helper method to subtract the two numbers and compare the result to the java big decimal
	 * @param number1 - first number serves as base
	 * @param number2 - second number is subtracted from the first number
	 */
	protected void testOperation(String number1, String number2) {
		BigDecimal<Object> result = number(number1).subtract(number(number2));
		java.math.BigDecimal expected = new java.math.BigDecimal(number1).subtract(new java.math.BigDecimal(number2));
		assertEquals("The implementation doesn't match the result of the java big decimal calculation (" + number1 + " - " + number2 + ")", expected.stripTrailingZeros().toPlainString(), result.toString());
	}
}

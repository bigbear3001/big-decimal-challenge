package bigdecimalchallenge.test.simplemath;

import static junit.framework.Assert.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bigdecimalchallenge.BigDecimal;


/**
 * This tests the add method of the implementation. Therefore the result is compared to the java big decimal.
 * @author bigbear3001
 *
 */
public class AddTest extends SimpleMathTest {
	
	final static Logger logger = LoggerFactory.getLogger(AddTest.class);
	
	/**
	 * Helper method to add the two numbers and compare the result to the java big decimal
	 * @param number1 - first number serves as base
	 * @param number2 - second number is added to the first number
	 */
	protected void testOperation(String number1, String number2) {
		logger.debug("Testing adding numbers {} and {}", number1, number2);
		BigDecimal<Object> result = number(number1).add(number(number2));
		java.math.BigDecimal expected = new java.math.BigDecimal(number1).add(new java.math.BigDecimal(number2));
		assertEquals("The implementation doesn't match the result of the java big decimal calculation (" + number1 + " + " + number2 + ")", expected.stripTrailingZeros().toPlainString(), result.toString());
	}
	
}

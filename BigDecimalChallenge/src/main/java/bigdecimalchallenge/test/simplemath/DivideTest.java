package bigdecimalchallenge.test.simplemath;

import static junit.framework.Assert.*;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bigdecimalchallenge.BigDecimal;
import bigdecimalchallenge.test.TestUtils;


/**
 * This tests the divide method of the implementation. Therefore the result is compared to the java big decimal.
 * @author bigbear3001
 *
 */
public class DivideTest extends SimpleMathTest {
	
	final static Logger logger = LoggerFactory.getLogger(DivideTest.class);
	
	/**
	 * We prepare to get an Arithmetic Exception when dividing by zero or getting a periodical result as with 1/9.
	 * !Important: don't overload this with ExpectedException.none() when running tests as the framework holds a reference to the initial ExpectedException.
	 * Instead use thrown.expect((Matcher<Object>) null) to reset the ExpectedException.
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Helper method to divide the two numbers and compare the result to the java big decimal
	 * @param number1 - first number serves as base
	 * @param number2 - first number is divided by the second number
	 */
	protected void testOperation(String number1, String number2) {
		logger.debug("Testing subtracting numbers {} by {}", number1, number2);
		boolean exceptionExpected = false;
		java.math.BigDecimal expected = null;
		//If we divide by zero we expect an ArithmeticException
		//otherwise we test the big decimal result first to get the eventually expected exception
		//if we get an exception (e.g. 1 divided by 9 throws an ArithmeticException) than we expect the implementation also to throw an exception
		//
		//TODO: eventually there will com an implementation that can handle the periodical numbers,
		//then we will have to modify this test to check for this (e.g. implementation.canHandlePeriodicalResults())
		//of course than we would have to find another way to verify the result.
		if(number2.matches("^(0\\.|\\.)0*$")) {
			thrown.expect(ArithmeticException.class);
			exceptionExpected = true;
		} else {
			try {
				expected = new java.math.BigDecimal(number1).divide(new java.math.BigDecimal(number2));
				thrown.expect((Matcher<Object>) null);
			} catch (ArithmeticException e) {
				thrown.expect(ArithmeticException.class);
				exceptionExpected=true;
			}
			
		}
		BigDecimal<Object> result = number(number1).divide(number(number2));
		if(exceptionExpected) {
			fail("We expect te division by zero (" + number1 + " / " + number2 + ") to fail with an ArithmeticExcpetion.");
		}
		assertEquals("The implementation doesn't match the result of the java big decimal calculation (" + number1 + " / " + number2 + ")", TestUtils.toBigDecimalString(expected), result.toString());
	}
}

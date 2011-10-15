package bigdecimalchallenge.test.simplemath;

import static junit.framework.Assert.*;
import bigdecimalchallenge.test.Numbers;

import org.junit.Test;

import bigdecimalchallenge.BigDecimal;
import bigdecimalchallenge.test.BigDecimalTest;


/**
 * This tests the add method of the implementation. Therefore the result is compared to the java big decimal.
 * @author bigbear3001
 *
 */
public class AddTest extends BigDecimalTest {
	/**
	 * add simple integers to digits
	 */
	@Test
	public void addIntegers() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.oneToHundred.length; j++) {
				assertAdd(Numbers.digits[i], Numbers.oneToHundred[j]);
			}
		}
	}
	/**
	 * add negative integers to digits
	 */
	@Test
	public void addNegativeIntegers() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.oneToHundred.length; j++) {
				assertAdd(Numbers.digits[i], "-" + Numbers.oneToHundred[j]);
			}
		}
	}
	
	/**
	 * add simple doubles to doubles
	 */
	@Test
	public void addDoubles() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.digits.length; j++) {
				for(int k = 0; k < Numbers.oneToHundred.length; k++) {
					for(int l = 0; l < Numbers.oneToHundred.length; l++) {
						assertAdd(Numbers.digits[i] + "." + Numbers.digits[j], Numbers.oneToHundred[k] + "." + Numbers.oneToHundred[l]);
					}
				}
			}
		}
	}
	
	/**
	 * add negative doubles to doubles
	 */
	@Test
	public void addNegativeDoubles() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.digits.length; j++) {
				for(int k = 0; k < Numbers.oneToHundred.length; k++) {
					for(int l = 0; l < Numbers.oneToHundred.length; l++) {
						assertAdd(Numbers.digits[i] + "." + Numbers.digits[j], "-" + Numbers.oneToHundred[k] + "." + Numbers.oneToHundred[l]);
					}
				}
			}
		}
	}
	
	/**
	 * add integers to doubles
	 */
	@Test
	public void addIntegersToDoubles() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.digits.length; j++) {
				for(int k = 0; k < Numbers.oneToHundred.length; k++) {
					assertAdd(Numbers.digits[i] + "." + Numbers.digits[j], Numbers.oneToHundred[k]);
				}
			}
		}
	}
	
	/**
	 * add negative integers to doubles
	 */
	@Test
	public void addNegativeIntegersToDoubles() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.digits.length; j++) {
				for(int k = 0; k < Numbers.oneToHundred.length; k++) {
					assertAdd(Numbers.digits[i] + "." + Numbers.digits[j], "-" + Numbers.oneToHundred[k]);
				}
			}
		}
	}
	
	/**
	 * add doubles to integers
	 */
	@Test
	public void addDoublesToIntegers() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.digits.length; j++) {
				for(int k = 0; k < Numbers.oneToHundred.length; k++) {
					assertAdd(Numbers.oneToHundred[k], Numbers.digits[i] + "." + Numbers.digits[j]);
				}
			}
		}
	}
	
	/**
	 * add negative doubles to integers
	 */
	@Test
	public void addNegativeDoublesToIntegers() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.digits.length; j++) {
				for(int k = 0; k < Numbers.oneToHundred.length; k++) {
					assertAdd(Numbers.oneToHundred[k], "-" + Numbers.digits[i] + "." + Numbers.digits[j]);
				}
			}
		}
	}
	
	/**
	 * Helper method to add the two numbers and compare the result to the java big decimal
	 * @param number1 - first number serves as base
	 * @param number2 - second number is added to the first number
	 */
	private void assertAdd(String number1, String number2) {
		BigDecimal<Object> result = number(number1).add(number(number2));
		java.math.BigDecimal expected = new java.math.BigDecimal(number1).add(new java.math.BigDecimal(number2));
		assertEquals("The implementation doesn't match the result of the java big decimal calculation (" + number1 + " + " + number2 + ")", expected.stripTrailingZeros().toPlainString(), result.toString());
	}
}

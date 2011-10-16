package bigdecimalchallenge.test.simplemath;

import org.junit.Test;

import bigdecimalchallenge.test.BigDecimalTest;
import bigdecimalchallenge.test.Numbers;

/**
 * This tests various data against an operation (add,divide,multiply,subtract).
 * @author bigbear3001
 */
public abstract class SimpleMathTest extends BigDecimalTest {

	public SimpleMathTest() {
		super();
	}

	/**
	 * Tests the operation with two numbers.
	 * @param number1 - first number
	 * @param number2 - second number
	 */
	protected abstract void testOperation(String number1, String number2);
	
	/**
	 * add simple integers to digits
	 */
	@Test
	public void integers() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.oneToHundred.length; j++) {
				testOperation(Numbers.digits[i], Numbers.oneToHundred[j]);
			}
		}
	}
	/**
	 * add negative integers to digits
	 */
	@Test
	public void negativeIntegers() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.oneToHundred.length; j++) {
				testOperation(Numbers.digits[i], "-" + Numbers.oneToHundred[j]);
			}
		}
	}
	
	/**
	 * add simple doubles to doubles
	 */
	@Test
	public void doubles() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.digits.length; j++) {
				for(int k = 0; k < Numbers.oneToHundred.length; k++) {
					for(int l = 0; l < Numbers.oneToHundred.length; l++) {
						testOperation(Numbers.digits[i] + "." + Numbers.digits[j], Numbers.oneToHundred[k] + "." + Numbers.oneToHundred[l]);
					}
				}
			}
		}
	}
	
	/**
	 * add negative doubles to doubles
	 */
	@Test
	public void negativeDoubles() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.digits.length; j++) {
				for(int k = 0; k < Numbers.oneToHundred.length; k++) {
					for(int l = 0; l < Numbers.oneToHundred.length; l++) {
						testOperation(Numbers.digits[i] + "." + Numbers.digits[j], "-" + Numbers.oneToHundred[k] + "." + Numbers.oneToHundred[l]);
					}
				}
			}
		}
	}
	
	/**
	 * add integers to doubles
	 */
	@Test
	public void integersToDoubles() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.digits.length; j++) {
				for(int k = 0; k < Numbers.oneToHundred.length; k++) {
					testOperation(Numbers.digits[i] + "." + Numbers.digits[j], Numbers.oneToHundred[k]);
				}
			}
		}
	}
	
	/**
	 * add negative integers to doubles
	 */
	@Test
	public void negativeIntegersToDoubles() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.digits.length; j++) {
				for(int k = 0; k < Numbers.oneToHundred.length; k++) {
					testOperation(Numbers.digits[i] + "." + Numbers.digits[j], "-" + Numbers.oneToHundred[k]);
				}
			}
		}
	}
	
	/**
	 * add doubles to integers
	 */
	@Test
	public void doublesToIntegers() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.digits.length; j++) {
				for(int k = 0; k < Numbers.oneToHundred.length; k++) {
					testOperation(Numbers.oneToHundred[k], Numbers.digits[i] + "." + Numbers.digits[j]);
				}
			}
		}
	}
	
	/**
	 * add negative doubles to integers
	 */
	@Test
	public void negativeDoublesToIntegers() {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.digits.length; j++) {
				for(int k = 0; k < Numbers.oneToHundred.length; k++) {
					testOperation(Numbers.oneToHundred[k], "-" + Numbers.digits[i] + "." + Numbers.digits[j]);
				}
			}
		}
	}
}
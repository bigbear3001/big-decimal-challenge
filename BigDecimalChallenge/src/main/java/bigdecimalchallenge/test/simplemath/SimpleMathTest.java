package bigdecimalchallenge.test.simplemath;

import org.junit.Test;

import bigdecimalchallenge.test.BigDecimalTest;
import bigdecimalchallenge.test.Numbers;

/**
 * This tests various data against an operation (add,divide,multiply,subtract).
 * @author bigbear3001
 */
public abstract class SimpleMathTest extends BigDecimalTest {

	
	/**
	 * Scaling mode for the numbers.
	 * @author bigbear3001
	 *
	 */
	public static enum Mode {
		/**
		 * Generates numbers in the range arround {@link Long#MAX_VALUE} to test overflow of longs
		 */
		LONG(Long.MAX_VALUE / 100),
		/**
		 * Generates numbers in the range arround {@link Integer#MAX_VALUE} to test overflow of integers
		 */
		INTEGER((long) (Integer.MAX_VALUE / 10)),
		/**
		 * Generated numbers in the range between 0 and 100
		 */
		HUNDRED(1L);
		
		private Long value;
		
		Mode(Long givenValue) {
			value = givenValue;
		}
	};

	private static Mode mode = Mode.HUNDRED;
	
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
	 * test simple integers to digits
	 */
	@Test
	public void integers() {
		for(int i = 0; i < Numbers.intDigits.length; i++) {
			for(int j = 0; j < Numbers.intOneToHundred.length; j++) {
				testOperation("" + Numbers.intDigits[i] * mode.value, "" + Numbers.intOneToHundred[j] * mode.value);
			}
		}
	}
	/**
	 * test negative integers to digits
	 */
	@Test
	public void negativeIntegers() {
		for(int i = 0; i < Numbers.intDigits.length; i++) {
			for(int j = 0; j < Numbers.intOneToHundred.length; j++) {
				testOperation("" + Numbers.intDigits[i] * mode.value, "-" + Numbers.intOneToHundred[j] * mode.value);
			}
		}
	}
	
	/**
	 * test negative integers to negative digits
	 */
	@Test
	public void negativeWithNegativeIntegers() {
		for(int i = 0; i < Numbers.intDigits.length; i++) {
			for(int j = 0; j < Numbers.intOneToHundred.length; j++) {
				testOperation("-" + Numbers.intDigits[i] * mode.value, "-" + Numbers.intOneToHundred[j] * mode.value);
			}
		}
	}
	
	/**
	 * test simple doubles to doubles
	 */
	@Test
	public void doubles() {
		for(int i = 0; i < Numbers.intDigits.length; i++) {
			for(int j = 0; j < Numbers.intDigits.length; j++) {
				for(int k = 0; k < Numbers.intOneToHundred.length; k++) {
					for(int l = 0; l < Numbers.intOneToHundred.length; l++) {
						testOperation(Numbers.intDigits[i] * mode.value + "." + Numbers.intDigits[j] * mode.value, Numbers.intOneToHundred[k] * mode.value + "." + Numbers.intOneToHundred[l] * mode.value);
					}
				}
			}
		}
	}
	
	/**
	 * test negative doubles to doubles
	 */
	@Test
	public void negativeDoubles() {
		for(int i = 0; i < Numbers.intDigits.length; i++) {
			for(int j = 0; j < Numbers.intDigits.length; j++) {
				for(int k = 0; k < Numbers.intOneToHundred.length; k++) {
					for(int l = 0; l < Numbers.intOneToHundred.length; l++) {
						testOperation(Numbers.intDigits[i] * mode.value + "." + Numbers.intDigits[j] * mode.value, "-" + Numbers.intOneToHundred[k] * mode.value + "." + Numbers.intOneToHundred[l] * mode.value);
					}
				}
			}
		}
	}
	
	/**
	 * test negative doubles to negative doubles
	 */
	@Test
	public void negativeWithNegativeDoubles() {
		for(int i = 0; i < Numbers.intDigits.length; i++) {
			for(int j = 0; j < Numbers.intDigits.length; j++) {
				for(int k = 0; k < Numbers.intOneToHundred.length; k++) {
					for(int l = 0; l < Numbers.intOneToHundred.length; l++) {
						testOperation("-" + Numbers.intDigits[i] * mode.value + "." + Numbers.intDigits[j] * mode.value, "-" + Numbers.intOneToHundred[k] * mode.value + "." + Numbers.intOneToHundred[l] * mode.value);
					}
				}
			}
		}
	}
	
	/**
	 * test integers to doubles
	 */
	@Test
	public void integersToDoubles() {
		for(int i = 0; i < Numbers.intDigits.length; i++) {
			for(int j = 0; j < Numbers.intDigits.length; j++) {
				for(int k = 0; k < Numbers.intOneToHundred.length; k++) {
					testOperation(Numbers.intDigits[i] * mode.value + "." + Numbers.intDigits[j] * mode.value, "" + Numbers.intOneToHundred[k] * mode.value);
				}
			}
		}
	}
	
	/**
	 * test negative integers to doubles
	 */
	@Test
	public void negativeIntegersToDoubles() {
		for(int i = 0; i < Numbers.intDigits.length; i++) {
			for(int j = 0; j < Numbers.intDigits.length; j++) {
				for(int k = 0; k < Numbers.intOneToHundred.length; k++) {
					testOperation(Numbers.intDigits[i] * mode.value + "." + Numbers.intDigits[j] * mode.value, "-" + Numbers.intOneToHundred[k] * mode.value);
				}
			}
		}
	}
	
	/**
	 * test doubles to integers
	 */
	@Test
	public void doublesToIntegers() {
		for(int i = 0; i < Numbers.intDigits.length; i++) {
			for(int j = 0; j < Numbers.intDigits.length; j++) {
				for(int k = 0; k < Numbers.intOneToHundred.length; k++) {
					testOperation("" + Numbers.intOneToHundred[k] * mode.value, Numbers.intDigits[i] * mode.value + "." + Numbers.intDigits[j] * mode.value);
				}
			}
		}
	}
	
	/**
	 * test negative doubles to integers
	 */
	@Test
	public void negativeDoublesToIntegers() {
		for(int i = 0; i < Numbers.intDigits.length; i++) {
			for(int j = 0; j < Numbers.intDigits.length; j++) {
				for(int k = 0; k < Numbers.intOneToHundred.length; k++) {
					testOperation("" + Numbers.intOneToHundred[k] * mode.value, "-" + Numbers.intDigits[i] * mode.value + "." + Numbers.intDigits[j] * mode.value);
				}
			}
		}
	}

	/**
	 * set the scaling mode for the numbers
	 * @param newMode - scaling to set for the numbers
	 * @see Mode
	 */
	public static void mode(Mode newMode) {
		mode = newMode;
	}
}
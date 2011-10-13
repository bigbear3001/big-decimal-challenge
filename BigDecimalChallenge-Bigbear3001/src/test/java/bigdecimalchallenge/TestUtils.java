package bigdecimalchallenge;

import com.perhab.bigdecimalchallenge.PerhabBigDecimal;

public class TestUtils {
	
	/**
	 * Creates a BigDecimal instance for a given number.
	 * 
	 * @param number The number for which to create a BigDecimal.
	 * @return The instance initialized with the number.
	 */
	public static BigDecimal createInstance(String number) {
		try {
			return PerhabBigDecimal.class.getConstructor(String.class).newInstance(number);
		} catch (Exception e) {
			throw new RuntimeException("Can't create big decimal", e);
		}
	}
}

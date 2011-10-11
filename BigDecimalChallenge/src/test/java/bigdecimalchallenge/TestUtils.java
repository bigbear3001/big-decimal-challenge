package bigdecimalchallenge;

import java.util.ServiceLoader;

public class TestUtils {
	
	/**
	 * Creates a BigDecimal instance for a given number.
	 * 
	 * @param number The number for which to create a BigDecimal.
	 * @return The instance initialized with the number.
	 */
	public static BigDecimal createInstance(String number) {
		ServiceLoader<BigDecimal> loader = ServiceLoader.load(BigDecimal.class);
		for (BigDecimal bigDecimal : loader) {
			System.out.println("Using BigDecimal Implementation" + bigDecimal.getClass().getCanonicalName());
			return bigDecimal;
		}
		
		throw new RuntimeException("No BigDecimal implementation found");
	}
}

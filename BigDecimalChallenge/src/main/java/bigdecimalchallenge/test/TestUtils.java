package bigdecimalchallenge.test;

import java.lang.reflect.Constructor;
import java.util.regex.Pattern;

import bigdecimalchallenge.BigDecimal;

/**
 * BigDecimal test utils
 * 
 * @author fgutmann
 */
public class TestUtils<T> {
	
	private static TestUtils<BigDecimal<Object>> instance = new TestUtils<BigDecimal<Object>>();
	
	private Class<T> clazz;
	private Constructor<T> implConstructor;
	
	public TestUtils () {
		String name = System.getProperty("bigdecimalchallenge.impl");
		if (name == null) {
			throw new RuntimeException("You need to define the system property 'bigdecimalchallenge.impl'");
		}
		
		try {
			clazz = (Class<T>) Class.forName(name);
			if(! BigDecimal.class.isAssignableFrom(clazz)) {
				throw new Exception("Must implement " + BigDecimal.class.getCanonicalName());
			}
			implConstructor = clazz.getConstructor(String.class);
		} catch (Exception e) {
			throw new RuntimeException("Error initializing BigDecimal implementation " + name, e);
		}
	}
	
	/**
	 * Creates a BigDecimal instance for a given number.
	 * 
	 * @param number The number for which to create a BigDecimal.
	 * @return The instance initialized with the number.
	 */
	public T getNumber(String number) {
		try {
			return (T) implConstructor.newInstance(number);	
		} catch (Exception e) {
			throw new RuntimeException("Could not instantiate BigDecimal of type " + clazz.getCanonicalName() + " for number " + number, e);
		}
	}
	
	/**
	 * Normalizes a given number to an accepted number for BigDecimal implementations.
	 * FIXME: Normalization must be implemented way more efficiently, or even better totally avoided in the first place.
	 * 
	 * @param number The number to normalize
	 * @return The normalized number
	 */
	public static String normalize(String number) {
		String result = toBigDecimalString(new java.math.BigDecimal(number));
		if(!result.equals(number)) {
			System.out.println("normalized " + number + " to " + result);
		}
		return result;
	}
	
	/**
	 * Get the current instance of TestUtils
	 */
	public static TestUtils<BigDecimal<Object>> getInstance() {
		return instance;
	}
	
	/**
	 * This method gives us the string equivalent of the java big decimal
	 * @param decimal - decimal to convert to string
	 * @return string in compliance with the big decimal challenge
	 */
	public static String toBigDecimalString(java.math.BigDecimal decimal) {
		return decimal.stripTrailingZeros().toPlainString().replaceAll("\\.0+$", "");
	}
}

package bigdecimalchallenge.test;

import java.lang.reflect.Constructor;

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
	 * Get the current instance of TestUtils
	 */
	public static TestUtils<BigDecimal<Object>> getInstance() {
		return instance;
	}
}

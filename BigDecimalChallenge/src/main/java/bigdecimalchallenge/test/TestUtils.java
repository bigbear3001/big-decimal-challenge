package bigdecimalchallenge.test;

import java.lang.reflect.Constructor;

import bigdecimalchallenge.BigDecimal;

public class TestUtils {
	
	static Class<?>clazz;
	static Constructor<? extends BigDecimal<?>> implConstructor;
	
	static {
		String name = System.getProperty("bigdecimalchallenge.impl");
		if (name == null) {
			throw new RuntimeException("You need to define the system property 'bigdecimalchallenge.impl'");
		}
		
		try {
			clazz = Class.forName(name);
			if(! BigDecimal.class.isAssignableFrom(clazz)) {
				throw new Exception("Must implement " + BigDecimal.class.getCanonicalName());
			}
			implConstructor = (Constructor<? extends BigDecimal<?>>) clazz.getConstructor(String.class);
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
	public static BigDecimal<? extends BigDecimal<?>> createInstance(String number) {
		try {
			return (BigDecimal)implConstructor.newInstance(number);	
		} catch (Exception e) {
			throw new RuntimeException("Could not instantiate BigDecimal of type " + clazz.getCanonicalName() + " for number " + number, e);
		}
	}
}

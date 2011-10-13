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
	@SuppressWarnings("unchecked")
	public static BigDecimal<? extends BigDecimal<?>> createInstance(String number) {
		try {
			return (BigDecimal<? extends BigDecimal<?>>) implConstructor.newInstance(number);	
		} catch (Exception e) {
			throw new RuntimeException("Could not instantiate BigDecimal of type " + clazz.getCanonicalName() + " for number " + number, e);
		}
	}
	
	public static BigDecimal<?> add(BigDecimal one, BigDecimal two) {
		return (BigDecimal<?>) one.add(two);
	}
	
	public static BigDecimal<?> subtract(BigDecimal one, BigDecimal two) {
		return (BigDecimal<?>) one.subtract(two);
	}
	
	public static BigDecimal<?> multiply(BigDecimal one, BigDecimal two) {
		return (BigDecimal<?>) one.multiply(two);
	}
		
	public static BigDecimal<?> divide(BigDecimal one, BigDecimal two) {
		return (BigDecimal<?>) one.divide(two);
	}	
}

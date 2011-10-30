package bigdecimalchallenge.test.object;

import static junit.framework.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bigdecimalchallenge.BigDecimal;
import bigdecimalchallenge.test.BigDecimalTest;
import bigdecimalchallenge.test.Numbers;
import bigdecimalchallenge.test.simplemath.AddTest;

/**
 * Test to verify each operation creates new objects.
 * TODO: verify that the source objects are not manipulated.
 * @author bigbear3001
 *
 */
public class CopyTest extends BigDecimalTest {
	
	final static Logger logger = LoggerFactory.getLogger(AddTest.class);
	
	/**
	 * Test the add method of the implementation for not returning the same object as the caller object nor the same as the given object.
	 * @throws IllegalArgumentException - @see {@link Method#invoke(Object, Object...)}
	 * @throws IllegalAccessException - @see {@link Method#invoke(Object, Object...)}
	 * @throws InvocationTargetException - @see {@link Method#invoke(Object, Object...)}
	 * @throws SecurityException - @see {@link Class#getMethod(String, Class...)}
	 * @throws NoSuchMethodException - @see {@link Class#getMethod(String, Class...)}
	 */
	@Test
	public void testCopyAdd() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
		testCopy(getMethod("add"));
	}
	
	/**
	 * Test the subtract method of the implementation for not returning the same object as the caller object nor the same as the given object.
	 * @throws IllegalArgumentException - @see {@link Method#invoke(Object, Object...)}
	 * @throws IllegalAccessException - @see {@link Method#invoke(Object, Object...)}
	 * @throws InvocationTargetException - @see {@link Method#invoke(Object, Object...)}
	 * @throws SecurityException - @see {@link Class#getMethod(String, Class...)}
	 * @throws NoSuchMethodException - @see {@link Class#getMethod(String, Class...)}
	 */
	@Test
	public void testCopySubtract() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
		testCopy(getMethod("subtract"));
	}
	
	/**
	 * Test the multiply method of the implementation for not returning the same object as the caller object nor the same as the given object.
	 * @throws IllegalArgumentException - @see {@link Method#invoke(Object, Object...)}
	 * @throws IllegalAccessException - @see {@link Method#invoke(Object, Object...)}
	 * @throws InvocationTargetException - @see {@link Method#invoke(Object, Object...)}
	 * @throws SecurityException - @see {@link Class#getMethod(String, Class...)}
	 * @throws NoSuchMethodException - @see {@link Class#getMethod(String, Class...)}
	 */
	@Test
	public void testCopyMultiply() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
		testCopy(getMethod("multiply"));
	}
	
	/**
	 * Test the divide method of the implementation for not returning the same object as the caller object nor the same as the given object.
	 * @throws IllegalArgumentException - @see {@link Method#invoke(Object, Object...)}
	 * @throws IllegalAccessException - @see {@link Method#invoke(Object, Object...)}
	 * @throws InvocationTargetException - @see {@link Method#invoke(Object, Object...)}
	 * @throws SecurityException - @see {@link Class#getMethod(String, Class...)}
	 * @throws NoSuchMethodException - @see {@link Class#getMethod(String, Class...)}
	 */
	@Test
	public void testCopyDivide() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
		testCopy(getMethod("divide"));
	}
	
	/**
	 * get the method with the given name for the current used implementation of {@link BigDecimal}.
	 * @param methodName - name of the method to get
	 * @return the method of the implementation
	 * @throws SecurityException - @see {@link Class#getMethod(String, Class...)}
	 * @throws NoSuchMethodException - @see {@link Class#getMethod(String, Class...)}
	 */
	@SuppressWarnings("unchecked")
	private Method getMethod(String methodName) throws SecurityException, NoSuchMethodException {
		Class<? extends BigDecimal> clazz = number("0").getClass();
		if (methodName == "divide") {
			Class<?> clazzInt = int.class;
			return clazz.getMethod(methodName, clazz, clazzInt);
		} else {
			return clazz.getMethod(methodName, clazz);
		}
	}

	/**
	 * Verifies the result of the given method is not the same object as the parameter nor the same object as the call object.
	 * @param method - method to test
	 * @throws IllegalArgumentException - @see {@link Method#invoke(Object, Object...)}
	 * @throws IllegalAccessException - @see {@link Method#invoke(Object, Object...)}
	 * @throws InvocationTargetException - @see {@link Method#invoke(Object, Object...)}
	 */
	public void testCopy(Method method) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		for(int i = 0; i < Numbers.digits.length; i++) {
			for(int j = 0; j < Numbers.oneToHundred.length; j++) {
				try{
					BigDecimal<Object> a = number(Numbers.digits[i]);
					BigDecimal<Object> b = number(Numbers.oneToHundred[j]);
					Object c;
					if(method.getName() == "divide") {
						c = method.invoke(a, b, 100);
					} else {
						c = method.invoke(a, b);
					}
					assertNotSame("initialisation shoul not return the same object for " + a + " and " + b + ".", a, b);
					assertNotSame("the " + method.getName() + " operation should generate a new object with each call.", a, c);
					assertNotSame("the " + method.getName() + " operation should generate a new object with each call.", b, c);
				} catch (ArithmeticException e) {
					logger.debug("Testing '{}'.{}('{}') failed with arithmetic exception. Since we are not testing for that, we will ignore it.", e);
				}
			}
		}
	}
	
	
}

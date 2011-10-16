package bigdecimalchallenge.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bigdecimalchallenge.BigDecimal;

/**
 * Base test for all big decimal tests.
 * Provides a simple way for getting a big decimal number.
 * 
 * @author fgutmann
 */
public class BigDecimalTest {
	/**
	 * TestUtils that provide big decimal instances.
	 */
	TestUtils<BigDecimal<Object>> testUtils = new TestUtils<BigDecimal<Object>>();
	
	/**
	 * Get a big decimal for the desired number
	 * 
	 * @param number The number to create a big decimal for
	 * @return Big Decimal for the number.
	 */
	public BigDecimal<Object> number(String number) {
		return testUtils.getNumber(number);
	}
}

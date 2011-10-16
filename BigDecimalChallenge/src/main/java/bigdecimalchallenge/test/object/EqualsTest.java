package bigdecimalchallenge.test.object;

import static junit.framework.Assert.*;

import org.junit.Test;

import bigdecimalchallenge.BigDecimal;
import bigdecimalchallenge.test.BigDecimalTest;
import bigdecimalchallenge.test.Numbers;

/**
 * Verify that the equals method returns the correct values
 * @author bigbear3001
 *
 */
public class EqualsTest extends BigDecimalTest {
	/**
	 * Verifies that the equals method is implemented.
	 */
	@Test
	public void testEquals(){
		for(int i = 0; i < Numbers.oneToHundred.length; i++) {
			BigDecimal<Object> a = number(Numbers.oneToHundred[i]);
			BigDecimal<Object> b = number(Numbers.oneToHundred[i]);
			assertEquals("Two equal numbers should return true in the equals function", a, b);
		}
		
	}
}

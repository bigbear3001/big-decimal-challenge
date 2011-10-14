package bigdecimalchallenge.test.simplemath;

import bigdecimalchallenge.BigDecimal;
import bigdecimalchallenge.test.BigDecimalTest;
import bigdecimalchallenge.test.TestUtils;


public class AddTest extends BigDecimalTest {
	public void addIntegers() {
		String[] numbers = new String[]{"1", "2", "3", "9", "99", "100", "999", "3333", "6666", "-9999"};
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers.length; i++) {
				BigDecimal<Object> a = number(numbers[i]);
				BigDecimal<Object> b = number(numbers[i]);
				BigDecimal<Object> result = a.add(b);
			}
		}
	}
}

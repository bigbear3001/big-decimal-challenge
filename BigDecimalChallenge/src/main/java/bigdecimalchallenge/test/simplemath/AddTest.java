package bigdecimalchallenge.test.simplemath;

import bigdecimalchallenge.BigDecimal;
import bigdecimalchallenge.test.TestUtils;


public class AddTest<T extends BigDecimal> {
	public void addIntegers() {
		String[] numbers = new String[]{"1", "2", "3", "9", "99", "100", "999", "3333", "6666", "-9999"};
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers.length; i++) {
				BigDecimal<T> zero = (BigDecimal<T>) TestUtils.createInstance("0");
				BigDecimal<T> a = zero.add(numbers[i]);
				BigDecimal<T> b = TestUtils.createInstance(numbers[i]);
				BigDecimal<T> result = a.add(b);
			}
		}
	}
}

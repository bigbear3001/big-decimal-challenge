package bigdecimalchallenge.test;

/**
 * Helper class that provides numbers for testing as static fields.
 * 
 * @author fgutmann
 */
public class Numbers {
	
	public static final String [] digits = new String [] {
		"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
	};
	
	/**
	 * Get n times a given digit
	 * @param digit The digit
	 * @param times How many times you want the digit
	 * @return N-times the digit as string
	 */
	public static final String digits(byte digit, int times) {
		StringBuilder digitBuilder = new StringBuilder();
		for(int i = 0; i < times; i++) {
			digitBuilder.append(digit);
		}
		return digitBuilder.toString();
	}
}

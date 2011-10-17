package bigdecimalchallenge.test;

/**
 * Helper class that provides numbers for testing as static fields.
 * 
 * @author fgutmann
 */
public class Numbers {
	
	
	
	/**
	 * All digits from 0 to 9 as int
	 */
	public static final int [] intDigits = new int [] {
		0, 1, 2, 3, 4, 5, 6, 7, 8, 9
	};
	
	
	/**
	 * All digits from 0 to 9
	 */
	public static final String [] digits = new String [] {
		"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
	};
	
	/**
	 * Some numbers in the range of 1 to 100 as int
	 */
	public static final int [] intOneToHundred = new int [] {
		9, 15, 18, 39, 59, 30, 80, 85, 76, 99,
		19, 25, 27, 60, 11, 2, 50, 66, 78, 55
	};
	
	/**
	 * Some numbers in the range of 1 to 100
	 */
	public static final String [] oneToHundred = new String [] {
		"9", "15", "18", "39", "59", "30", "80", "85", "76", "99",
		"19", "25", "27", "60", "11", "2", "50", "66", "78", "55"
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

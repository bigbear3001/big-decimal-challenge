package bigdecimalchallenge;
/**
 * Interface to implement for the big decimal challenge.
 * 
 * The implementation must contain a constructor that takes a number as string argument.<br /><br />
 * 
 * The string argument represents the number and is defined as follows:
 * <ul>
 * 		<li>
 * 			If the number is negative, it starts with a dash sign ("-").
 * 			If it is positive, it has no sign.
 * 		</li>
 * 		<li>
 * 			The comma is represented by a single dot (".").
 * 		</li>
 * 		<li>
 * 			All other characters in the string are letters from zero to nine.
 * 		</li>
 * 		<li>
 * 			The number have no trailing zeros.
 * 			For example "1.20" is invalid, it must be represented as "1.2"
 * 		</li>
 * 		<li>
 * 			The number has no unnecessary leading zeros.
 * 			For example "01.02" is invalid, it must be represented as "1.02".
 * 		</li>
 * 		<li>
 * 			The number has at least one digit before the comma.
 * 			For example ".2" is invalid, it must be represented as "0.2".
 * 		</li>
 * </ul>
 * 
 * It's fine if the implementation also allows to create a number from other strings.
 * But the {@link #toString()} method must always output a string that follows the rules above.
 * 
 * @author bigbear3001, fgutmann
 */
public interface BigDecimal<T> {
	
	/**
	 * Transforms the number back into string representation.<br /><br />
	 * The returning String must meet the same criteria as the constructor string parameter.
	 * 
	 * See the BigDecimal interface documentation for details.
	 * 
	 * @return String representation of the big decimal
	 */
	public String toString();
	
	/**
	 * add a big decimal to this big decimal
	 * @param value - value to add to this big decimal
	 * @return new big decimal with the added values of this big decimal and the given big decimal
	 */
	public BigDecimal<T> add(T value);
	
	/**
	 * subtract a big decimal from this big decimal
	 * @param value - value to subtract to this big decimal
	 * @return new big decimal with the value of this big decimal subtracted by the given big decimal
	 */
	public BigDecimal<T> subtract(T value);
	
	/**
	 * divide this big decimal by a big decimal.
	 * @param value - value to divide this big decimal by
	 * @return new big decimal with the added values of this big decimal and the given big decimal
	 */
	public BigDecimal<T> divide(T value);
	
	/**
	 * multiply this big decimal with another big decimal
	 * @param value - value to multiply this big decimal by
	 * @return new big decimal with the multiplied values of this big decimal and the given big decimal
	 */
	public T multiply(T value);
}

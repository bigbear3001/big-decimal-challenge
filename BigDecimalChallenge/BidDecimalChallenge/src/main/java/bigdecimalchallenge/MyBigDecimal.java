package bigdecimalchallenge;


/**
 * Interface to implement for the big decimal challenge
 * @author bigbear3001
 *
 */
public interface MyBigDecimal {
	
	/**
	 * @return String representation of the big decimal
	 */
	public String toString();
	
	/**
	 * add a big decimal to this big decimal
	 * @param value - value to add to this big decimal
	 * @return new big decimal with the added values of this big decimal and the given big decimal
	 */
	public MyBigDecimal add(MyBigDecimal value);
	
	/**
	 * add a number to this big decimal.
	 * @param value - value to add to this big decimal
	 * @return new big decimal with the added values of this big decimal and the given number
	 */
	public MyBigDecimal add(Number value);
	
	/**
	 * subtract a big decimal from this big decimal
	 * @param value - value to subtract to this big decimal
	 * @return new big decimal with the value of this big decimal subtracted by the given big decimal
	 */
	public MyBigDecimal sub(MyBigDecimal value);
	
	/**
	 * subtract a big decimal from this big decimal
	 * @param value - value to subtract to this big decimal
	 * @return new big decimal with the value of this big decimal subtracted by the given big decimal
	 */
	public MyBigDecimal sub(Number value);
	
	/**
	 * divide this big decimal by a big decimal.
	 * @param value - value to divide this big decimal by
	 * @return new big decimal with the added values of this big decimal and the given big decimal
	 */
	public MyBigDecimal div(MyBigDecimal value);
	
	/**
	 * add a big decimal to this big decimal
	 * @param value - value to add to this big decimal
	 * @return new big decimal with the added values of this big decimal and the given big decimal
	 */
	public MyBigDecimal div(Number value);
	
	/**
	 * multiply this big decimal with another big decimal
	 * @param value - value to multiply this big decimal by
	 * @return new big decimal with the multiplied values of this big decimal and the given big decimal
	 */
	public MyBigDecimal mul(MyBigDecimal value);
	
	/**
	 * multiply this big decimal with a number
	 * @param value - value to multiply this big decimal by
	 * @return new big decimal with the multiplied values of this big decimal and the given big decimal
	 */
	public MyBigDecimal mul(Number value);
	
	/**
	 * initialize a new big decimal from a number
	 * @param value - value to initialize the new big decimal with
	 * @return new big decimal with the given value
	 */
	public MyBigDecimal fromNumber(Number value);
	
	/**
	 * @return the value of this big decimal as number.
	 */
	public Number toNumber() throws NotANumberException;
}

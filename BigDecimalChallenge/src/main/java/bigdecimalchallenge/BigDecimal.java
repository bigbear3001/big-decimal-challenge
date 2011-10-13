package bigdecimalchallenge;


/**
 * Interface to implement for the big decimal challenge.
 * The implementation must contain a constructor that takes a number as string argument.
 * 
 * @author bigbear3001, fgutmann
 */
public interface BigDecimal {
	
	/**
	 * @return String representation of the big decimal
	 */
	public String toString();
	
	/**
	 * add a big decimal to this big decimal
	 * @param value - value to add to this big decimal
	 * @return new big decimal with the added values of this big decimal and the given big decimal
	 */
	public BigDecimal add(BigDecimal value);
	
	/**
	 * subtract a big decimal from this big decimal
	 * @param value - value to subtract to this big decimal
	 * @return new big decimal with the value of this big decimal subtracted by the given big decimal
	 */
	public BigDecimal subtract(BigDecimal value);
	
	/**
	 * divide this big decimal by a big decimal.
	 * @param value - value to divide this big decimal by
	 * @return new big decimal with the added values of this big decimal and the given big decimal
	 */
	public BigDecimal divide(BigDecimal value);
	
	/**
	 * multiply this big decimal with another big decimal
	 * @param value - value to multiply this big decimal by
	 * @return new big decimal with the multiplied values of this big decimal and the given big decimal
	 */
	public BigDecimal multiply(BigDecimal value);
}

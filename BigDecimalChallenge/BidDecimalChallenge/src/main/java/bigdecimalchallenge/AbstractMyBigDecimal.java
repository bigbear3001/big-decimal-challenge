package bigdecimalchallenge;

/**
 * Simple Implementation of the number methods in {@link MyBigDecimal}.
 * @author bigbear3001
 *
 */
public abstract class AbstractMyBigDecimal implements MyBigDecimal {

	public MyBigDecimal add(Number value) {
		return add(fromNumber(value));
	}

	public MyBigDecimal div(Number value) {
		return div(fromNumber(value));
	}

	public MyBigDecimal mul(Number value) {
		return mul(fromNumber(value));
	}

	public MyBigDecimal sub(Number value) {
		return sub(fromNumber(value));
	}

}

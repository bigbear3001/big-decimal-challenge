package bigdecimalchallenge.ri;

import bigdecimalchallenge.BigDecimal;

/**
 * Big decimal reference implementation based on java.math.BigDecimal.
 * 
 * @author fgutmann
 */
public class BigDecimalRI implements BigDecimal<BigDecimalRI> {
	
	private java.math.BigDecimal bd;
	
	public BigDecimalRI(String number) {
		bd = new java.math.BigDecimal(number);
	}

	private BigDecimalRI(java.math.BigDecimal number) {
		this.bd = number;
	}
	
	@Override
	public BigDecimalRI add(BigDecimalRI value) {
		return new BigDecimalRI(bd.add(value.bd));
	}

	@Override
	public BigDecimalRI subtract(BigDecimalRI value) {
		return new BigDecimalRI(bd.subtract(value.bd));
	}

	@Override
	public BigDecimalRI divide(BigDecimalRI value) {
		return new BigDecimalRI(bd.divide(value.bd));
	}

	@Override
	public BigDecimalRI multiply(BigDecimalRI value) {
		return new BigDecimalRI(bd.multiply(value.bd));
	}
	
	@Override
	public String toString() {
		return bd.toString();
	}
}

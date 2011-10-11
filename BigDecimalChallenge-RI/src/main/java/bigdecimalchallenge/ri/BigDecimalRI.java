package bigdecimalchallenge.ri;

import bigdecimalchallenge.BigDecimal;

/**
 * Big decimal reference implementation based on java.math.BigDecimal.
 * 
 * @author fgutmann
 */
public class BigDecimalRI implements BigDecimal {
	
	private java.math.BigDecimal bd;
	
	public BigDecimalRI(String number) {
		bd = new java.math.BigDecimal(number);
	}

	private BigDecimalRI(java.math.BigDecimal number) {
		this.bd = number;
	}
	
	@Override
	public BigDecimal add(BigDecimal value) {
		BigDecimalRI number = (BigDecimalRI) value;
		
		return new BigDecimalRI(bd.add(number.bd));
	}

	@Override
	public BigDecimal subtract(BigDecimal value) {
		BigDecimalRI number = (BigDecimalRI) value;
		
		return new BigDecimalRI(bd.subtract(number.bd));
	}

	@Override
	public BigDecimal divide(BigDecimal value) {
		BigDecimalRI number = (BigDecimalRI) value;
		
		return new BigDecimalRI(bd.divide(number.bd));
	}

	@Override
	public BigDecimal multiply(BigDecimal value) {
		BigDecimalRI number = (BigDecimalRI) value;
		
		return new BigDecimalRI(bd.multiply(number.bd));
	}
	
	@Override
	public String toString() {
		return bd.toString();
	}
}

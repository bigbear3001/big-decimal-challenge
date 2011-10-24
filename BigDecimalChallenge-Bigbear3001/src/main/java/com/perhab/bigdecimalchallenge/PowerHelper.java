package com.perhab.bigdecimalchallenge;


public class PowerHelper {

	public static PerhabBigDecimal power(PerhabBigDecimal base,
			PerhabBigDecimal power) {
		if(power.equals(PerhabBigDecimal.ZERO)) {
			return new PerhabBigDecimal("1");
		} else if (power.isDecimal()) {
			throw new RuntimeException("The power method with decimal power is not yet implemented");
		} else if (power.isNegative()) {
			//a ^ -b == 1 / a ^ b
			return new PerhabBigDecimal("1").divide(base.power(power.getPostive()));
		}
		PerhabBigDecimal iterator = power.clone().subtract(new PerhabBigDecimal("1"));
		PerhabBigDecimal result = base.clone();
		while(iterator.largerThan(PerhabBigDecimal.ZERO)) {
			result = result.multiply(base);
			iterator = iterator.subtract(new PerhabBigDecimal("1"));
		}
		return result;
	}

}

package com.perhab.bigdecimalchallenge;

import bigdecimalchallenge.MyBigDecimal;
import bigdecimalchallenge.MyBigDecimalTest;

public class PerhabBigDecimalTest extends MyBigDecimalTest {

	@Override
	public Class<? extends MyBigDecimal> getImplementation() {
		return PerhabBigDecimal.class;
	}

}

package com.perhab.bigdecimalchallenge;

import bigdecimalchallenge.BigDecimal;
import bigdecimalchallenge.InitialisationTest;

public class PerhabBigDecimalTest extends InitialisationTest {

	@Override
	public Class<? extends BigDecimal> getImplementation() {
		return PerhabBigDecimal.class;
	}

}

package com.perhab.bigdecimalchallenge;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import bigdecimalchallenge.AbstractMyBigDecimal;
import bigdecimalchallenge.MyBigDecimal;

public class PerhabBigDecimal extends AbstractMyBigDecimal {

	/**
	 * {@link PerhabBigDecimalValue} represents the value of {@link PerhabBigDecimal}.
	 * @author bigbear3001
	 */
	private class PerhabBigDecimalValue {
		public PerhabBigDecimalValue(List<Integer> givenData, int givenFloatingPointPosition) {
			data = givenData;
			floatingPointPosition = givenFloatingPointPosition;
		}
		/**
		 * holding the raw data of the decimal.
		 */
		private List<Integer> data;
		
		/**
		 * defines the floating points position.
		 */
		private int floatingPointPosition; 
	}
	
	private static final int BASE = 10;
	
	private PerhabBigDecimalValue data;
	
	public PerhabBigDecimal() {
		data = new PerhabBigDecimalValue(Arrays.asList(new Integer[]{0}), 0);
	}
	
	private PerhabBigDecimal(PerhabBigDecimalValue value) {
		data = value;
	}
	
	public MyBigDecimal add(MyBigDecimal value) {
		
		throw new RuntimeException("Not yet implemented");
	}
	
	public MyBigDecimal div(MyBigDecimal value) {
		throw new RuntimeException("Not yet implemented");
	}
	
	public MyBigDecimal mul(MyBigDecimal value) {
		throw new RuntimeException("Not yet implemented");
	}
	
	public MyBigDecimal sub(MyBigDecimal value) {
		throw new RuntimeException("Not yet implemented");
	}
	
	public MyBigDecimal sub(Number value) {
		throw new RuntimeException("Not yet implemented");
	}
	
	public MyBigDecimal fromNumber(Number value) {
		if(value instanceof Integer) {
			Vector<Integer> newValue = new Vector<Integer>();
			int intValue = ((Integer) value).intValue();
			while(intValue != 0) {
				newValue.add(intValue % BASE);
				intValue = intValue / BASE;
			}
			return new PerhabBigDecimal(new PerhabBigDecimalValue(newValue, 0));
		}
		throw new RuntimeException("Not yet implemented");
	}
	
	public Number toNumber(){
		if(data.floatingPointPosition == 0) {
			
		}
		throw new RuntimeException("Not yet implemented");
	}

	
	private PerhabBigDecimalValue getData() {
		return data;
	}






}

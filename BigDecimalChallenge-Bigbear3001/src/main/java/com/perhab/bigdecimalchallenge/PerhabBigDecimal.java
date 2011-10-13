package com.perhab.bigdecimalchallenge;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import bigdecimalchallenge.BigDecimal;

public class PerhabBigDecimal implements BigDecimal {

	/**
	 * {@link PerhabBigDecimalValue} represents the value of {@link PerhabBigDecimal}.
	 * @author bigbear3001
	 */
	private class PerhabBigDecimalValue {
		public PerhabBigDecimalValue(List<Integer> givenData, int givenFloatingPointPosition) {
			data = givenData;
			decimalPlaces = givenFloatingPointPosition;
		}
		/**
		 * holding the raw data of the decimal.
		 */
		private List<Integer> data;
		
		/**
		 * defines the floating points position.
		 */
		private int decimalPlaces; 
	}
	
	private static final int BASE = 10;
	
	private PerhabBigDecimalValue data;
	
	public PerhabBigDecimal() {
		data = new PerhabBigDecimalValue(Arrays.asList(new Integer[]{0}), 0);
	}
	
	private PerhabBigDecimal(PerhabBigDecimalValue value) {
		data = value;
	}
	
	public BigDecimal add(BigDecimal value) {
		PerhabBigDecimal perhabValue = toPerhabBigDecimal(value);
		PerhabBigDecimalValue newData = new PerhabBigDecimalValue(new Vector<Integer>(), 0);
		if(perhabValue.data.decimalPlaces > data.decimalPlaces) {
			newData.decimalPlaces = perhabValue.data.decimalPlaces;
		} else {
			newData.decimalPlaces = data.decimalPlaces; 
		}
		for(int i = 0; i < newData.decimalPlaces; i++) {
			int placeValue = 0;
			if(perhabValue.data.decimalPlaces > i) {
				placeValue += perhabValue.data.data.get(i);
			}
			newData.data.add(placeValue);
		}
		for(int i = newData.decimalPlaces; i < perhabValue.data.data.size() || i < data.data.size(); i++) {
			int placeValue = 0;
			if(perhabValue.data.data.size() > i) {
				placeValue += perhabValue.data.data.get(i);
			}
			if(data.data.size() > i) {
				placeValue += data.data.get(i);
			}
			newData.data.add(placeValue);
		}
		return new PerhabBigDecimal(newData);
	}
	
	public BigDecimal divide(BigDecimal value) {
		throw new RuntimeException("Not yet implemented");
	}
	
	public BigDecimal multiply(BigDecimal value) {
		throw new RuntimeException("Not yet implemented");
	}
	
	public BigDecimal subtract(BigDecimal value) {
		throw new RuntimeException("Not yet implemented");
	}
	
	public BigDecimal sub(Number value) {
		throw new RuntimeException("Not yet implemented");
	}
	
	public BigDecimal fromNumber(Number value) {
		if(value instanceof Integer) {
			return fromInteger((Integer) value);
		} else if(value instanceof Double) {
			return fromDouble((Double) value);
		}
		throw new RuntimeException("Not yet implemented");
	}
	
	public Number toNumber(){
		if(data.decimalPlaces == 0) {
			int intValue = 0;
			for(int i = 0; i < data.data.size(); i++) {
				intValue += Math.pow(BASE, i) * data.data.get(i);
			}
			return intValue;
		}
		throw new RuntimeException("Not yet implemented");
	}
	
	public String toString(){
		StringBuilder value = new StringBuilder();
		for(int i = data.data.size() -1 ; i >= 0; i--) {
			value.append(data.data.get(i));
			if(i == data.decimalPlaces && i != 0) {
				value.append('.');
			}
		}
		return value.toString();
	}

	
	
	
	private PerhabBigDecimalValue getData() {
		return data;
	}
	
	private PerhabBigDecimal toPerhabBigDecimal(BigDecimal value) {
		PerhabBigDecimal perhabValue;
		if(!(value instanceof PerhabBigDecimal)) {
			try {
				perhabValue = (PerhabBigDecimal) fromNumber(value.toNumber());
			} catch (NotANumberException e) {
				throw new RuntimeException("Cannot read the given value as number and it's not an implementation of PerhabBigDecimal.", e);
			}
		} else {
			perhabValue = (PerhabBigDecimal) value;
		}
		return perhabValue;
	}
	
	private int getDecimalPlaces(Double value) {
		String decimalString = value.toString().replaceAll("[0-9]+\\.", "");
		return decimalString.length();
	}
	
	private BigDecimal fromDouble(Double value) {
		PerhabBigDecimal newValue = toPerhabBigDecimal(fromInteger(value.intValue()));
		int decimalPlaces = getDecimalPlaces(value);
		Double doubleDecimals = (Math.pow(10, decimalPlaces) * (value)) - (Math.pow(10, decimalPlaces) * value.intValue());
		PerhabBigDecimal doubleValue = toPerhabBigDecimal(fromInteger(doubleDecimals.intValue()));
		
		newValue.data.data.addAll(0, doubleValue.data.data);
		newValue.data.decimalPlaces = decimalPlaces;
		return newValue;
	}

	private BigDecimal fromInteger(Integer value) {
		Vector<Integer> newValue = new Vector<Integer>();
		int intValue = value.intValue();
		while(intValue != 0) {
			newValue.add(intValue % BASE);
			intValue = intValue / BASE;
		}
		if(newValue.size() == 0) {
			newValue.add(0);
		}
		return new PerhabBigDecimal(new PerhabBigDecimalValue(newValue, 0));
	}

}

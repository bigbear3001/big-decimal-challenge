package com.perhab.bigdecimalchallenge;

import java.io.IOException;
import java.io.StringReader;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import bigdecimalchallenge.BigDecimal;
import bigdecimalchallenge.InvalidNumberFormatException;

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
		
		/**
		 * defines if the number is negative
		 */
		private boolean negative = false;
	}
	
	private static final int BASE = 10;
	
	private static final String VALID_NUMBER = "-?[0-9]+(\\.[0-9]+)?";
	
	private PerhabBigDecimalValue data;
	
	public PerhabBigDecimal() {
		data = new PerhabBigDecimalValue(Arrays.asList(new Integer[]{0}), 0);
	}
	/**
	 * reads the big decimal from a string in the form -?[0-9]+(\.[0-9]+)?)
	 * @param number - number as string
	 */
	public PerhabBigDecimal(String number) {
		if(number.matches(VALID_NUMBER)) {
			try {
				data = new PerhabBigDecimalValue(new Vector<Integer>(), 0);
				StringReader reader = new StringReader(number);
				if(number.startsWith("-")) {
					data.negative = true;
					reader.read();
				}
				char read;
				boolean foundDecimalPoint = false;
				while((read = (char) reader.read()) != -1) {
					if (read != '.') {
						int value = Integer.parseInt(read + "");
						data.data.add(0,value);
						if(foundDecimalPoint) {
							data.decimalPlaces++;
						}
					} else {
						foundDecimalPoint = true;
					}
				}
			} catch (Exception e) {
				throw new InvalidNumberFormatException("We got an exception reading the String.", e);
			}
		} else {
			throw new InvalidNumberFormatException(number + " doesn't match " + VALID_NUMBER);
		}
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
	
	public String toString(){
		StringBuilder value = new StringBuilder();
		if(data.negative) {
			value.append('-');
		}
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
			perhabValue = new PerhabBigDecimal(value.toString());
		} else {
			perhabValue = (PerhabBigDecimal) value;
		}
		return perhabValue;
	}
	
	private int getDecimalPlaces(Double value) {
		String decimalString = value.toString().replaceAll("[0-9]+\\.", "");
		return decimalString.length();
	}
	
}

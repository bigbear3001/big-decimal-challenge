package com.perhab.bigdecimalchallenge;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import bigdecimalchallenge.BigDecimal;
import bigdecimalchallenge.InvalidNumberFormatException;

public class PerhabBigDecimal implements BigDecimal<PerhabBigDecimal> {

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
		
		@Override
		public String toString(){
			return new PerhabBigDecimal(this).toString();
		}
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
				int read;
				boolean foundDecimalPoint = false;
				while((read = reader.read()) != -1) {
					if ((char) read != '.') {
						int value = Integer.parseInt(((char) read) + "");
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
	
	public PerhabBigDecimal add(PerhabBigDecimal value) {
		PerhabBigDecimalValue newData = new PerhabBigDecimalValue(new Vector<Integer>(), 0);
		if(value.data.decimalPlaces > data.decimalPlaces) {
			newData.decimalPlaces = value.data.decimalPlaces;
		} else {
			newData.decimalPlaces = data.decimalPlaces; 
		}
		for(int i = 0; i < newData.decimalPlaces; i++) {
			int placeValue = 0;
			if(value.data.decimalPlaces > i) {
				placeValue += value.data.data.get(i);
			}
			newData.data.add(placeValue);
		}
		int carrier = 0;
		for(int i = newData.decimalPlaces; i < value.data.data.size() || i < data.data.size(); i++) {
			int placeValue = carrier;
			carrier = 0;
			int valueOffset = 0;
			int dataOffset = 0;
			if(value.data.data.size() > i) {
				placeValue += value.data.data.get(i);
			}
			if(data.data.size() > i) {
				placeValue += data.data.get(i);
			}
			if(placeValue >= BASE) {
				carrier = 1;
				placeValue -= BASE;
			}
			newData.data.add(placeValue);
		}
		if(carrier != 0) {
			newData.data.add(carrier);
		}
		return new PerhabBigDecimal(newData);
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

	
	
	
	public PerhabBigDecimal subtract(PerhabBigDecimal value) {
		// TODO Auto-generated method stub
		return null;
	}
	public PerhabBigDecimal divide(PerhabBigDecimal value) {
		// TODO Auto-generated method stub
		return null;
	}
	public PerhabBigDecimal multiply(PerhabBigDecimal value) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

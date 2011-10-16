package com.perhab.bigdecimalchallenge;

import java.io.StringReader;
import java.util.ArrayList;
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
		public PerhabBigDecimalValue(List<Integer> givenData, int givenFloatingPointPosition, boolean givenNegative) {
			data = givenData;
			decimalPlaces = givenFloatingPointPosition;
			negative = givenNegative;
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
		
		@Override
		public PerhabBigDecimalValue clone() {
			return new PerhabBigDecimalValue(new ArrayList<Integer>(data), decimalPlaces, negative);
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
		if(data.negative && value.data.negative) {
			PerhabBigDecimalValue newData = (PerhabBigDecimalValue) data.clone();
			newData.negative = false;
			PerhabBigDecimalValue newValue = (PerhabBigDecimalValue) value.data.clone();
			newValue.negative = false;
			PerhabBigDecimal result = new PerhabBigDecimal(newValue).add(new PerhabBigDecimal(newData));
			result.data.negative = true;
			return result;
		} else if(data.negative && !value.data.negative) {
			PerhabBigDecimalValue newData = (PerhabBigDecimalValue) data.clone();
			newData.negative = false;
			return value.subtract(new PerhabBigDecimal(newData));
		} else if(!data.negative && value.data.negative) {
			PerhabBigDecimalValue newData = (PerhabBigDecimalValue) value.data.clone();
			newData.negative = false;
			return subtract(new PerhabBigDecimal(newData));
		}
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
	
	public PerhabBigDecimal subtract(PerhabBigDecimal value) {
		if(data.negative && value.data.negative) {
			PerhabBigDecimalValue newData = (PerhabBigDecimalValue) data.clone();
			newData.negative = false;
			PerhabBigDecimalValue newValue = (PerhabBigDecimalValue) data.clone();
			newData.negative = false;
			PerhabBigDecimal result = new PerhabBigDecimal(newValue).subtract(new PerhabBigDecimal(newData));
			if(result.data.negative) {
				result.data.negative = false;
			} else {
				result.data.negative = true;
			}
			return result;
		} else if(data.negative && !value.data.negative) {
			PerhabBigDecimalValue newData = (PerhabBigDecimalValue) data.clone();
			newData.negative = false;
			PerhabBigDecimal result = value.add(new PerhabBigDecimal(newData));
			result.data.negative = true;
			return result;
		} else if(!data.negative && value.data.negative) {
			PerhabBigDecimalValue newData = (PerhabBigDecimalValue) value.data.clone();
			newData.negative = false;
			return add(new PerhabBigDecimal(newData));
		} else if(data.data.size() == 1 && data.data.get(0) == 0) {
			PerhabBigDecimalValue newData = (PerhabBigDecimalValue) value.data.clone();
			newData.negative = true;
			return new PerhabBigDecimal(newData);
		}
		
		int valueOffset = 0;
		int dataOffset = 0;
		if(value.data.decimalPlaces > data.decimalPlaces) {
			dataOffset = value.data.decimalPlaces - data.decimalPlaces;
		} else {
			valueOffset = data.decimalPlaces - value.data.decimalPlaces;
		}
		PerhabBigDecimalValue newValue = new PerhabBigDecimalValue(new ArrayList<Integer>(), dataOffset > valueOffset ? dataOffset : valueOffset);
		boolean carry = false;
		int places = Math.max(dataOffset + data.data.size(), valueOffset + value.data.data.size());
		for(int i = 0; i < places; i++) {
			int place = i < dataOffset || (i - dataOffset) >= data.data.size() ? 0 : data.data.get(i - dataOffset);
			int sub = i < valueOffset || (i - valueOffset) >= value.data.data.size() ? 0 : value.data.data.get(i - valueOffset);
			if(carry) {
				sub += 1;
				carry = false;
			}
			if(place < sub) {
				place += BASE;
				carry = true;
			}
			place -= sub;
			newValue.data.add(place);
		}
		//if we still have a carry bit we have to subtract the result from the next tenfold
		if(carry) {
			PerhabBigDecimal complement = new PerhabBigDecimal(Math.pow(BASE, newValue.data.size()) + "");
			complement = complement.subtract(new PerhabBigDecimal(newValue));
			complement.data.negative = true;
			return complement;
		}
		return new PerhabBigDecimal(newValue);
	}
	public PerhabBigDecimal divide(PerhabBigDecimal value) {
		// TODO Auto-generated method stub
		return null;
	}
	public PerhabBigDecimal multiply(PerhabBigDecimal value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PerhabBigDecimal){
			return toString().equals(((PerhabBigDecimal) obj).toString());
		}
		return false;
	}
	
	public String toString(){
		stripTrailingZeros();
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
	
	
	
	private void stripTrailingZeros() {
		
		int place = data.data.get(0);
		while (data.decimalPlaces > 0 && place == 0) {
			data.data.remove(0);
			data.decimalPlaces--;
			place = data.data.get(0);
		}
		
		place = data.data.get(data.data.size() - 1);
		while (place == 0 && data.data.size() > 1) {
			data.data.remove(data.data.size() - 1);
			place = data.data.get(data.data.size() - 1);
		}
	}
}

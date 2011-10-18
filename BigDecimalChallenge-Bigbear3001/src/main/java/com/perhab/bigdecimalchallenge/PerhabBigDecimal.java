package com.perhab.bigdecimalchallenge;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import bigdecimalchallenge.BigDecimal;
import bigdecimalchallenge.InvalidNumberFormatException;

public class PerhabBigDecimal implements BigDecimal<PerhabBigDecimal>, Comparable<PerhabBigDecimal> {

	/**
	 * {@link PerhabBigDecimalValue} represents the value of {@link PerhabBigDecimal}.
	 * @author bigbear3001
	 */
	private class PerhabBigDecimalValue implements Cloneable {
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
		validate();
	}
	
	private PerhabBigDecimal(PerhabBigDecimalValue value) {
		data = value;
		validate();
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
		int valueOffset = 0;
		int dataOffset = 0;
		if(value.data.decimalPlaces > data.decimalPlaces) {
			dataOffset = value.data.decimalPlaces - data.decimalPlaces;
		} else {
			valueOffset = data.decimalPlaces - value.data.decimalPlaces;
		}
		PerhabBigDecimalValue newValue = new PerhabBigDecimalValue(new ArrayList<Integer>(), value.data.decimalPlaces > data.decimalPlaces ? value.data.decimalPlaces : data.decimalPlaces);
		boolean carry = false;
		int places = Math.max(dataOffset + data.data.size(), valueOffset + value.data.data.size());
		for(int i = 0; i < places; i++) {
			int place = i < dataOffset || (i - dataOffset) >= data.data.size() ? 0 : data.data.get(i - dataOffset);
			int add = i < valueOffset || (i - valueOffset) >= value.data.data.size() ? 0 : value.data.data.get(i - valueOffset);
			if(carry) {
				add += 1;
				carry = false;
			}
			place += add;
			if(place >= BASE) {
				place -= BASE;
				carry = true;
			}
			newValue.data.add(place);
		}
		if(carry) {
			newValue.data.add(1);
		}
		return new PerhabBigDecimal(newValue);
	}
	
	public PerhabBigDecimal subtract(PerhabBigDecimal value) {
		if(data.negative && value.data.negative) {
			PerhabBigDecimalValue newData = (PerhabBigDecimalValue) data.clone();
			newData.negative = false;
			PerhabBigDecimalValue newValue = (PerhabBigDecimalValue) value.data.clone();
			newValue.negative = false;
			PerhabBigDecimal result = new PerhabBigDecimal(newData).subtract(new PerhabBigDecimal(newValue));
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
		PerhabBigDecimalValue newValue = new PerhabBigDecimalValue(new ArrayList<Integer>(), value.data.decimalPlaces > data.decimalPlaces ? value.data.decimalPlaces : data.decimalPlaces);
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
			PerhabBigDecimal complement = new PerhabBigDecimal(((long) Math.pow(BASE, places - newValue.decimalPlaces)) + "");
			complement = complement.subtract(new PerhabBigDecimal(newValue));
			complement.data.negative = true;
			return complement;
		}
		return new PerhabBigDecimal(newValue);
	}
	public PerhabBigDecimal divide(PerhabBigDecimal value) {
		if(value.isZero()) {
			throw new ArithmeticException("Division by zero");
		}
		return new PerhabBigDecimal();
	}
	public PerhabBigDecimal multiply(PerhabBigDecimal value) {
		if(isZero() || value.isZero()) {
			return new PerhabBigDecimal();
		}
		PerhabBigDecimal result = new PerhabBigDecimal();
		for(int i = 0; i < data.data.size(); i++) {
			PerhabBigDecimalValue newValue = new PerhabBigDecimalValue(new ArrayList<Integer>(), 0);
			int carry = 0;
			for(int j = 0; j < value.data.data.size(); j++) {
				int place = data.data.get(i);
				place *= value.data.data.get(j);
				if(carry != 0) {
					place += carry;
					carry = 0;
				}
				if(place >= BASE) {
					carry = place / BASE;
					place = place % BASE;
				}
				newValue.data.add(place);
			}
			if(carry != 0) {
				newValue.data.add(carry);
			}
			for(int j = 0; j < i; j++) {
				newValue.data.add(0,0);
			}
			result = result.add(new PerhabBigDecimal(newValue));
		}
		
		result.data.negative = (data.negative != value.data.negative);
		result.data.decimalPlaces = value.data.decimalPlaces + data.decimalPlaces;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PerhabBigDecimal){
			return compareTo((PerhabBigDecimal) obj) == 0;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return data.data.hashCode();
	}
	
	public String toString(){
		validate();
		StringBuilder value = new StringBuilder();
		if(data.negative) {
			value.append('-');
		}
		if (data.decimalPlaces == data.data.size()) {
			value.append("0.");
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
		while (place == 0 && data.data.size() - data.decimalPlaces > 1) {
			data.data.remove(data.data.size() - 1);
			place = data.data.get(data.data.size() - 1);
		}
	}
	
	private void validate() {
		stripTrailingZeros();
		if(isZero() && isNegative()) {
			data.negative = false;
		}
	}

	private boolean isZero() {
		for(int i = 0; i < data.data.size(); i++) {
			if(data.data.get(i) != 0) {
				return false;
			}
		}
		return true;
	}
	private boolean isNegative() {
		return data.negative;
	}
	
	public boolean largerThan(PerhabBigDecimal number) {
		return compareTo(number) == 1;
	}
	
	public boolean smallerThan(PerhabBigDecimal number) {
		return compareTo(number) == -1;
	}

	public int compareTo(PerhabBigDecimal number) {
		if(data.negative && !number.data.negative) {
			return -1;
		} else if(!data.negative && number.data.negative) {
			return 1;
		}
		int negativeCorrection = data.negative ? -1 : 1;
		if(data.data.size() - data.decimalPlaces > number.data.data.size() - number.data.decimalPlaces) {
			//We have more places before the decimal point
			return 1 * negativeCorrection;
		} else if (data.data.size() - data.decimalPlaces < number.data.data.size() - number.data.decimalPlaces) {
			//we have less places before the decimal point
			return -1 * negativeCorrection;
		}
		int numberOffset = number.data.data.size() - data.data.size();
		for(int i = data.data.size() - 1 ; i >= 0; i--) {
			if(i + numberOffset < 0) {
				return 1 * negativeCorrection;
			}
			int dataPlace = data.data.get(i);
			int numberPlace = number.data.data.get(i + numberOffset);
			if(dataPlace > numberPlace) {
				return 1 * negativeCorrection;
			} else if (dataPlace < numberPlace) {
				return -1 * negativeCorrection;
			}
		}
		if(data.data.size() < number.data.data.size()) {
			return -1 * negativeCorrection;
		}
		return 0;
	}
}

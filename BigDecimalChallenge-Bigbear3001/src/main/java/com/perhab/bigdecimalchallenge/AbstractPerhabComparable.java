package com.perhab.bigdecimalchallenge;

public abstract class AbstractPerhabComparable<T> implements Comparable<T> {

	public T clazz;
	
	public abstract int compareTo(T o);
	
	public abstract int hashCode();
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if(obj.getClass().isAssignableFrom(this.getClass())){
			return compareTo((T) obj) == 0;
		}
		return false;
	}
	
	public boolean largerThan(T o) {
		return compareTo(o) == 1;
	}
	
	public boolean smallerThan(T o) {
		return compareTo(o) == -1;
	}
}

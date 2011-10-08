package bigdecimalchallenge;

public interface MyBigDecimal {
	
	public String toString();
	
	public MyBigDecimal add(MyBigDecimal value);
	
	public MyBigDecimal sub(MyBigDecimal value);
	
	public MyBigDecimal div(MyBigDecimal value);
	
	public MyBigDecimal mul(MyBigDecimal value);
}

package model;

/** An Object to represent a numeric value.
 * 
 * @author VietN
 *
 */
public class MyNumber {

	private int value;
	
	public MyNumber() {}
	
	public MyNumber( int value ) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}

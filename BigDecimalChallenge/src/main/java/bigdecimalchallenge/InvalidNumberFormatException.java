package bigdecimalchallenge;

/**
 * This exception is thrown when a number isn't in the correct format.
 * @author bigbear3001
 *
 */
public class InvalidNumberFormatException extends RuntimeException {

	/**
	 * generate a new exception with a custom message
	 * @param message - message for this exception
	 */
	public InvalidNumberFormatException(String message) {
		super(message);
	}
	/**
	 * constructor to wrap an exception with a custom message into this exception.
	 * @param message - message for this exception
	 * @param e - exception to wrap
	 */
	public InvalidNumberFormatException(String message, Exception e) {
		super(message, e);
	}

	/**
	 * unique generated id for serialization.
	 */
	private static final long serialVersionUID = -4269715903320085639L;

}

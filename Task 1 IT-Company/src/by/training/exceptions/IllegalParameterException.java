package by.training.exceptions;

/**
 * 
 * Custom Exception.
 *
 */

public class IllegalParameterException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message 
	 */
	public IllegalParameterException(final String message) {
		super(message);
	}
}

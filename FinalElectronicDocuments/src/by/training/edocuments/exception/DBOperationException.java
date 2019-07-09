package by.training.edocuments.exception;

/**
 * Custom Exception, throw when return parameter is null.
 *
 */
public class DBOperationException extends Exception {

	/**
	 * Unique ID.
	 */
	private static final long serialVersionUID = -4340830903264514658L;

	/**
	 * Override method.
	 */
	public DBOperationException() {
	}

	/**
	 * Override method.
	 * @param message - message.
	 */
	public DBOperationException(final String message) {
		super(message);
	    }


	/**
	 * Override method.
	 * @param message - message.
	 * @param exception - exception.
	 */
	public DBOperationException(final String message, final Throwable exception) {
		super(message, exception);
	    }

	/**
	 * Override method.
	 * @param exception - exception.
	 */
	public DBOperationException(final Throwable exception) {
	    }
}

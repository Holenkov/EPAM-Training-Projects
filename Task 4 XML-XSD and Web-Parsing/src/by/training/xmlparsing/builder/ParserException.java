package by.training.xmlparsing.builder;

/**
 * Custom Exception, throw when return parameter is null.
 *
 */
public class ParserException extends Exception {

	/**
	 * Unique ID.
	 */
	private static final long serialVersionUID = -4340830903264514658L;

	/**
	 * Override method.
	 */
	public ParserException() {
	}

	/**
	 * Override method.
	 * @param message - message.
	 */
	public ParserException(final String message) {
		super(message);
	    }


	/**
	 * Override method.
	 * @param message - message.
	 * @param exception - exception.
	 */
	public ParserException(final String message, final Throwable exception) {
		super(message, exception);
	    }

	/**
	 * Override method.
	 * @param exception - exception.
	 */
	public ParserException(final Throwable exception) {
	    }
}

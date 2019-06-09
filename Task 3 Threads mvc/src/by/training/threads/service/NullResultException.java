package by.training.threads.service;

/**
 * Custom Exception, throw when return parameter is null.
 *
 */
public class NullResultException extends Exception {
	private static final long serialVersionUID = 3782609993504948245L;

	/**
	 * Override method.
	 */
	public NullResultException() {
	}

	/**
	 * Override method.
	 * @param message - message.
	 */
	public NullResultException(final String message) {
		super(message);
	    }


	/**
	 * Override method.
	 * @param message - message.
	 * @param exception - exception.
	 */
	public NullResultException(final String message, final Throwable exception) {
		super(message, exception);
	    }

	/**
	 * Override method.
	 * @param exception - exception.
	 */
	public NullResultException(final Throwable exception) {
	    }
}

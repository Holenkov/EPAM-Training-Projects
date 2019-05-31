package by.training.threads.exception;

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
	 */
	public NullResultException(final String message) {
		super(message);
	    }

	/**
	 * Override method.
	 */
	public NullResultException(String message, Throwable exception) {
		super(message, exception);
	    }

	/**
	 * Override method.
	 */
	public NullResultException(Throwable exception) {
	    }
}

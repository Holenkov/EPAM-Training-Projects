package by.training.infohandling.exception;

/**
 * Custom Exception, throws when return parameter is null.
 */
public class NullResultException extends Exception {
	/** UID. */
	private static final long serialVersionUID = 3782609993504948245L;

	/** Constructor. */
	public NullResultException() {
	}

	/**
	 * Return message from exception.
	 */
	@Override
	public String getMessage() {
		return super.getMessage();
	}

	/**
	 * Overraided method.
	 * @param message message
	 */
	public NullResultException(final String message) {
		super(message);
	}

	/**
	 * Override method.
	 * @param message message.
	 * @param exception exception.
	 */
	public NullResultException(final String message, final Throwable exception) {
		super(message, exception);
	}

	/**
	 * Override method.
	 * @param exception thows.
	 */
	public NullResultException(final Throwable exception) {
	}
}

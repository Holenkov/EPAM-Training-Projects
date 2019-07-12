package by.training.edocuments.exception;

public class PoolInitException extends Exception{

	/**
	 * Unique ID.
	 */
	private static final long serialVersionUID = 6006538338741480644L;

	/**
	 * Override method.
	 */
	public PoolInitException() {
	}

	/**
	 * Override method.
	 * @param message - message.
	 */
	public PoolInitException(final String message) {
		super(message);
	    }


	/**
	 * Override method.
	 * @param message - message.
	 * @param exception - exception.
	 */
	public PoolInitException(final String message, final Throwable exception) {
		super(message, exception);
	    }

	/**
	 * Override method.
	 * @param exception - exception.
	 */
	public PoolInitException(final Throwable exception) {
	    }
}
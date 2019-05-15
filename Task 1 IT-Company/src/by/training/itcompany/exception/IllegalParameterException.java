package by.training.itcompany.exception;

/**
 * 
 * Custom Exception for Illegal parameters.
 *
 */

public class IllegalParameterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2602117741756825531L;

	public IllegalParameterException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public IllegalParameterException(final String message) {
		super(message);
	}

	public IllegalParameterException(final String message, Throwable exeption) {
		super(message, exeption);
	}

	public IllegalParameterException(Throwable exeption) {
		super(exeption);
	}

}

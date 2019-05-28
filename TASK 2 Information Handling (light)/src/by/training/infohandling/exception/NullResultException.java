package by.training.infohandling.exception;

/**
 * Custom Exception, throw when return parameter is null.
 *
 */
public class NullResultException extends Exception{
	private static final long serialVersionUID = 3782609993504948245L;

	public NullResultException() {
	}
	
	public NullResultException(String message) { 
		super(message);
	    }
	
	public NullResultException(String message, Throwable exception) { 
		super(message, exception);
	    }
	
	public NullResultException(Throwable exception) { 
	    }
}

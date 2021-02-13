package Exceptions;

public class InvalidPortNumberException extends Exception {

	public InvalidPortNumberException() {
	}

	public InvalidPortNumberException(String message) {
		super(message);
	}

	public InvalidPortNumberException(Throwable cause) {
		super(cause);
	}

	public InvalidPortNumberException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPortNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

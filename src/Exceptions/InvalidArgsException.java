package Exceptions;

public class InvalidArgsException extends Exception {

	private static final long serialVersionUID = -581486433377573843L;

	public InvalidArgsException() {}

	public InvalidArgsException(String message) {
		super(message);
	}

	public InvalidArgsException(Throwable cause) {
		super(cause);
	}

	public InvalidArgsException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidArgsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

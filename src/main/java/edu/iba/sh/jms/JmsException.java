package edu.iba.sh.jms;

public class JmsException extends Exception {

	public JmsException() {
		super();
	}

	public JmsException(String message, Throwable cause) {
		super(message, cause);
	}

	public JmsException(String message) {
		super(message);
	}

	public JmsException(Throwable cause) {
		super(cause);
	}

}

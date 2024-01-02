package main2;

import java.io.Serializable;

public class NoSuchUserException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * The method calls if user does not exists when delivering message 
	 * @param message
	 */
	public NoSuchUserException(String message) {
		super(message);
	}
}

package main2;

import java.io.Serializable;

public class OutOfGradeException extends Exception implements Serializable {
	/**
	 * Display exception that the grade exceeds limit
	 * @param message
	 */
	public OutOfGradeException(String message) {
		super(message);
	}
}

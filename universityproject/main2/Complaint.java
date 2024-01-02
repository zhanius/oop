package main2;

import java.io.Serializable;
import java.util.Date;

public class Complaint implements Serializable{
	public Teacher addresser;
	public Dean receiver;
	String message;
	Date date;
	UrgencyLevel level;
	/**
	 * Constructor for complaint
	 * @param addresser
	 * @param receiver
	 * @param message
	 * @param date
	 * @param level
	 */
	public Complaint(Teacher addresser, Dean receiver, String message, Date date, UrgencyLevel level) {
		super();
		this.addresser = addresser;
		this.receiver = receiver;
		this.message = message;
		this.date = date;
		this.level = level;
	}

	/**
	 * Display all information about complaint
	 * @return addresser
	 * @return receiver
	 * @return message
	 * @return date
	 * @return level
	 */
	@Override
	public String toString() {
		return "Complaint [addresser=" + addresser + ", receiver=" + receiver + ", message=" + message + ", date="
				+ date + ", level=" + level + "]";
	}
	
	
}

package main2;

import java.io.Serializable;
import java.util.Date;

public class UserAction implements Serializable {
	private User user;
	private Date date;
	private String description;
	/**
	 * Constructor for user actions
	 * @param date
	 * @param description
	 */
	public UserAction(Date date, String description) {
		this.date = date;
		this.description = description;
	}
	/**
	 * Get user
	 * @return user
	 */
	public User getUser() {
		return user;
	}
	/** 
	 * Display date and description of user action
	 * @return date
	 * @return description
	 */
	public String toString() {
		return date + ":" + this.description;
	}
}

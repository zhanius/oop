package main2;

import java.io.Serializable;
import java.util.Date;

public class Request implements Serializable {
	private String request;
	private Status requestStatus;
	private Date date;
	private Employee addresser;
	

	public Request() {
		
	}
	/**
	 * Constructor for request
	 * @param request
	 * @param requestStatus
	 * @param date
	 * @param addresser
	 */
	public Request(String request,Status requestStatus,Date date,Employee addresser) {
		this.request = request;
		this.requestStatus = requestStatus;
		this.date = date;
		this.addresser = addresser;
		
	}
	/**
	 * Get the request name
	 * @return
	 */
	public String getRequest() {
		return request;
	}
	/**
	 * Set the request name
	 * @param request
	 */
	public void setRequest(String request) {
		this.request = request;
	}
	/**
	 * Get the status of request
	 * @return requestStatus
	 */
	public Status getRequestStatus() {
		return requestStatus;
	}
	/**
	 * Set the status of request
	 * @param requestStatus
	 */
	public void setRequestStatus(Status requestStatus) {
		this.requestStatus = requestStatus;
	}
	/**
	 * Get date of request
	 * @return date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Set the date of request
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * Get the addreser of request
	 * @return addresser
	 */
	public User getAddresser() {
		return addresser;
	}
	/**
	 * Set the addresser of the request
	 * @param addresser
	 */
	public void setAddresser(Employee addresser) {
		this.addresser = addresser;
	}
	/**
	 * Display name, status,date and addresser of the request
	 */
	public String toString() {
		return request + " " + requestStatus + " " + date + " " + addresser;
	}

}

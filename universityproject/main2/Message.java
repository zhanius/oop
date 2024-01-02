package main2;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
	private String text;
	private Employee addresser;
	private Employee receiver;
	private Date date;
	
	public Message() {
		
	}
	/**
	 * Constuctor for the message
	 * @param text
	 * @param addresser
	 * @param receiver
	 * @param date
	 */
	public Message(String text,Employee addresser, Employee receiver, Date date) {
		this.text = text;
		this.addresser = addresser;
		this.receiver = receiver;
		this.date = date;
	}
	/**
	 * Get the of the message
	 * @return text
	 */
	public String getText() {
		return text;
	}
	/**
	 * Set the text of the message
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Get addreser of the message
	 * @return addresser
	 */
	public Employee getAddresser() {
		return addresser;
	}
	/**
	 * Set the addresser of the message
	 * @param adresser
	 */
	public void setAdresser(Employee adresser) {
		this.addresser = adresser;
	}
	
	/**
	 * Get receiver of the message
	 * @return receiver
	 */
	public Employee getReceiver() {
		return receiver;
	}
	/**
	 * Set the receiver of the message
	 * @param receiver
	 */
	public void setReceiver(Employee receiver) {
		this.receiver = receiver;
	}
	
	/**
	 * Get the date of the message
	 * @return date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Set the date of the message
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Get text, addresser and date info of the message
	 * @return getText()
	 * @return getAddresser()
	 * @return getDate()
	 */
	public String toString() {
		return getText() + " " + getAddresser() + " " + getDate();
	}
	

}


package main2;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	private String nameOfOrder;
	private Status orderStatus;
	private Date date;
	private Employee addresser;
	
	public Order() {
		
	}
	/**
	 * Constructor for order
	 * @param nameOfOrder
	 * @param date
	 * @param addresser
	 */
	public Order(String nameOfOrder,Date date, Employee addresser) {
		this.nameOfOrder = nameOfOrder;
		this.date = date;
		this.addresser = addresser;
	}
	/**
	 * Get the name of the order
	 * @return nameOfOrder
	 */
	public String getNameOfOrder() {
		return nameOfOrder;
	}
	/**
	 * Set the name of the order
	 * @param nameOfOrder
	 */
	public void setNameOfOrder(String nameOfOrder) {
		this.nameOfOrder = nameOfOrder;
	}
	
	/**
	 * Get status of the order
	 * @return
	 */
	public Status getOrderStatus() {
		return orderStatus;
	}
	/**
	 * Set the status of the order
	 * @param orderStatus
	 */
	public void setOrderStatus(Status orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	/**
	 * Get date of the order
	 * @return date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Set the date of the order
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Get addresser of the order
	 * @return addresser
	 */
	public Employee getAddresser() {
		return addresser;
	}
	/**
	 * Set the addresser of the order
	 * @param addresser
	 */
	public void setAddresser(Employee addresser) {
		this.addresser = addresser;
	}
	/**
	 * Display name,status,date and addresser of the order
	 */
	public String toString() {
		return getNameOfOrder()  + " " + getOrderStatus() + " " + getDate() + " " + getAddresser();
	}
	

}

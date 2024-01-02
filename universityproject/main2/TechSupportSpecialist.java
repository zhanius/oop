package main2;

import java.io.Serializable;
import java.util.Vector;

public class TechSupportSpecialist extends Employee implements Serializable {
	private Vector<Order> newOrders;
	private Vector<Order> acceptedOrders;
	private Vector<Order> doneOrders;
	
	public TechSupportSpecialist() {}
	/**
	 * Constructor for tech support specialist
	 * @param username
	 * @param password
	 * @param userId
	 * @param infoUser
	 * @param salary
	 * @param experienceYear
	 */
	public TechSupportSpecialist(String username, String password, String userId, UserPersonalInfo infoUser,double salary,int experienceYear) {
		super(username, password, userId, infoUser,salary,experienceYear);
	}
	/**
	 * Add received order to new orders
	 * @param order
	 */
	public void receiveOrder(Order order) {
		newOrders.add(order);
	}
	/**
	 * Accept the order,changes it's status, removes it from new orders and add to accepted orders
	 * @param order
	 */
	public void acceptOrder(Order order) {
		if(order.getOrderStatus() != Status.REJECTED && order.getOrderStatus() != Status.DONE) {
			order.setOrderStatus(Status.ACCEPTED);
			newOrders.remove(order);
			acceptedOrders.add(order);
		}
		}
	
	
	/**
	 * Reject the order,removes it from new orders and displays it
	 * @param order
	 */
	public void rejectOrder(Order order) {
		if(order.getOrderStatus() != Status.ACCEPTED && order.getOrderStatus() != Status.DONE ) {
			order.setOrderStatus(Status.REJECTED);
			newOrders.remove(order);
			System.out.println(getUsername() + "'s rejected order " + order);
		}
		}
	
	/**
	 * Remove the order from new orders, changes it's status to done and adds it to done orders
	 * @param order
	 */
	public void completeOrder(Order order) {
		if(order.getOrderStatus() == Status.ACCEPTED) {
			newOrders.remove(order);
			acceptedOrders.remove(order);
			order.setOrderStatus(Status.DONE);
			doneOrders.add(order);
			
		}
	}
	/**
	 * View accepted,new or completed orders
	 */
	public void viewOrders() {
		System.out.println(getUsername() + "'s accepted orders:");
        for (Order order : acceptedOrders) {
            System.out.println(order);
        }
        
        System.out.println(getUsername() + "'s new orders:");
        for (Order order : newOrders) {
            System.out.println(order);
        }
        

		System.out.println(getUsername() + "'s completed orders: ");
		for(Order o: doneOrders) {
			System.out.println(o);
		}
    }
	/**
	 * Get new orders
	 * @return newOrders
	 */
	public Vector<Order> getNewOrders() {
		return newOrders;
	}
	/**
	 * Set the new orders
	 * @param newOrders
	 */
	public void setNewOrders(Vector<Order> newOrders) {
		this.newOrders = newOrders;
	}
	/**
	 * Get the accepted orders
	 * @return acceptedOrders
	 */
	public Vector<Order> getAcceptedOrders() {
		return acceptedOrders;
	}
	/**
	 * Set the accepted orders
	 * @param acceptedOrders
	 */
	public void setAcceptedOrders(Vector<Order> acceptedOrders) {
		this.acceptedOrders = acceptedOrders;
	}
	/**
	 * Get the done orders
	 * @return doneOrders
	 */
	public Vector<Order> getDoneOrders() {
		return doneOrders;
	}
	/**
	 * Set the done orders
	 * @param doneOrders
	 */
	public void setDoneOrders(Vector<Order> doneOrders) {
		this.doneOrders = doneOrders;
	}
	
	
	/**
	 * Display the username of tech support specialist
	 * @return getUsername
	 */
	public String toString() {
		return  getUsername() ;
	}

}


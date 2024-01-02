package main2;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Employee extends User implements Serializable {
	@Serial
	private static final long serialVersionUID = 2474408621432207691L;
	private double salary;
	private int experienceYear;
	private Map<Employee,Vector<Message>> messages;
	
	
	public Employee() {
		
	}
	/**
	 * Constructor for employee
	 * @param username
	 * @param password
	 * @param userId
	 * @param infoUser
	 * @param salary
	 * @param experienceYear
	 */
	public Employee(String username, String password, String userId, UserPersonalInfo infoUser, double salary,int experienceYear) {
		super(username, password, userId, infoUser);
		this.salary = salary;
		this.experienceYear = experienceYear;
		this.messages = new HashMap<>();
	}
	/**
	 * Get the salary of employee
	 * @return
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * Set the salary of employee
	 * @param salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/**
	 * Get how many years employee works
	 * @return
	 */
	public int getExperienceYear() {
		return experienceYear;
	}
	/**
	 * Set how many years employee works
	 * @param experienceYear
	 */
	public void setExperienceYear(int experienceYear) {
		this.experienceYear = experienceYear;
	}
	/**
	 * Display messages of employee
	 * @return messages
	 */
	public Map<Employee, Vector<Message>> getMessages(){
		return this.messages;
	}
	
	/**
	 * Send messages to someone
	 * @param receiver
	 * @param text
	 */
	public void sendMessages(Employee receiver, String text) {
	    Message message = new Message(text, this, receiver, new Date());

	    if (!receiver.messages.containsKey(this)) {
	    	receiver.messages.put(this, new Vector<>());
	    	}

	    receiver.messages.get(this).add(message);
	    
	    }
	/**
	 * Display messages that employee get and display sender name
	 */
	public void displayMessages() {
		 System.out.println("Messages for " + this + ":");
		 for (Map.Entry<Employee, Vector<Message>> entry : messages.entrySet()) {
			 Employee sender = entry.getKey();
			 Vector<Message> messagesFromSender = entry.getValue();

			 System.out.print("From " + sender.getUsername() + ": {");
			 for (Message message : messagesFromSender) {
				 System.out.print("\"" + message.getText() + "\", ");
				 }
			 System.out.println("}");
			 }
	 }
	 
	 /**
	  * Create order for tech support
	  * @param orderName
	  * @param t some tech-support specialist 
	  * @return order
	  */
	 public Order createOrder(String orderName,TechSupportSpecialist t) {
		 Order order = new Order(orderName, new Date(),this);
		 t.receiveOrder(order);
		 return order;
	 }
	 /**
	  * Get username of employee
	  */
	 public String toString() {
		 return this.getUsername();
	}
	
}

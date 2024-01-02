package main2;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Dean extends Employee implements Serializable{
	/**
	 * Here Dean saves all complaints in hashmap
	 */
	static Map<Teacher,Vector<Complaint>> complaints = new HashMap<>();

	public Dean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor for Dean class
	 * @param username
	 * @param password
	 * @param userId
	 * @param infoUser
	 * @param salary
	 * @param experienceYear
	 */
	public Dean(String username, String password, String userId, UserPersonalInfo infoUser, double salary,
			int experienceYear) {
		super(username, password, userId, infoUser, salary, experienceYear);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Display complaints senders
	 * @throws IOException
	 */
	public void displayComplaints() throws IOException {
		 System.out.println("Complaints for " + this + ":");
		 for (Map.Entry<Teacher, Vector<Complaint>> entry : complaints.entrySet()) {
			 Teacher sender = entry.getKey();
			 Vector<Complaint> complaintsFromSender = entry.getValue();

			 System.out.print("From " + sender.getUsername() + ": {");
			 for (Complaint complaint : complaintsFromSender) {
				 System.out.print("\"" + complaint.message + "\", ");
				 Data.INSTANCE.complaints.put(sender, complaintsFromSender);
				 }
			 System.out.println("}");
			 }
		 Data.write();
	 }
	
	
}

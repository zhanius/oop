package main2;


import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

public class Organization implements Serializable {
	private String name;
	private Student head;
	private Date openDate;
	private Vector <Student> members;
	/**
	 * Add student to organization
	 * @param s the student that will be added to organization
	 */
	public void addMember(Student s) {
		members.add(s);
	}
	/**
	 * Constructor for organization
	 * @param name
	 * @param head
	 * @param openDate
	 * @param members
	 */
	public Organization(String name, Student head, Date openDate, Vector<Student> members) {
		this.name = name;
		this.head = head;
		this.openDate = openDate;
		this.members = members;
	}
	/**
	 * Get organization name
	 * @return
	 */
	public String getOrgName() {
		return name;
	}
}

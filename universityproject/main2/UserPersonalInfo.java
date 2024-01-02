package main2;

import java.io.Serializable;
import java.util.Date;

public class UserPersonalInfo implements Serializable{
	  private String firstname;
	  private String lastname;
	  private int age;
	  private String phoneNumber;
	  private Date birthDate;
	  public UserPersonalInfo() {}
	  /**
	   * Constructor for personal info of user
	   * @param firstname
	   * @param lastname
	   * @param age
	   * @param phoneNumber
	   * @param birthDate
	   */
	  public UserPersonalInfo(String firstname,String lastname, int age,String phoneNumber,Date birthDate){
		  this.firstname = firstname;
		  this.lastname = lastname;
		  this.age = age;
		  this.phoneNumber = phoneNumber;
		  this.birthDate = birthDate;
	  }
	  
	  
	    
}

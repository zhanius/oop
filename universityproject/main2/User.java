package main2;

import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable{
	protected String username;
	protected String password;
	protected String userId;
	protected UserPersonalInfo infoUser;
	protected boolean active = true;
	
	public User() {}
	/**
	 * Constructor for user
	 * @param username
	 * @param password
	 * @param userId
	 * @param infoUser
	 */
	public User(String username, String password, String userId, UserPersonalInfo infoUser) {
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.infoUser = infoUser;
	}
/**
 * Get user username
 * @return username
 */
	public String getUsername() {
		return username;
	}
/**
 * Set the user username
 * @param username
 */
	public void changeUsername(String username) {
		this.username = username;
	}
/**
 * Get the password of user
 * @return
 */
	public String getPassword() {
		return password;
	}
	/**
	 * Set the new password of user
	 * @param password
	 */
	public void changePassword(String password) {
		this.password = password;
	}
	/**
	 * Get id of user
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * Get personal info about user
	 * @return infoUser
	 */
	public UserPersonalInfo getInfoUser() {
		return infoUser;
	}
	/**
	 * Set the new personal info about user
	 * @param infoUser
	 */
	public void updateInfoUser(UserPersonalInfo infoUser) {
		this.infoUser = infoUser;
	}
	/**
	 * Method to login by username and password
	 * @param username
	 * @param password
	 * @return true if login is successful
	 * @return false if user does not exist in Database
	 */
	public boolean logIn(String username, String password) {
		for(User u: Data.INSTANCE.users) {		
			if(u.username.equals(username) && u.password.equals(password)) {
				active = true;
				return true;
			}
		}
		return false;
	}
	/**
	 * Method to logout 
	 * @return
	 */
	public boolean logOut() {
		if(this.active == true) {
			this.active = false;
			return true;
		}
		return false;
	}
	/**
	 * View current news
	 */
	public void viewNews() {
		for(News n: Data.INSTANCE.news) {
			System.out.println(n);
		}
	}
	/**
	 * Display id, username and info about user
	 * @return userId
	 * @return username
	 * @return infoUser
	 */
	public String toString() {
		return "UserId: " + this.userId + " and the username: " + this.username 
				+ "\n About user " + this.infoUser; 
	}
	/**
	 * Compares users by id, name,password and info and if they are active
	 * @return true if users id,name,password,info and active status are equal
	 * @return false if some of users variable are not equal or compared object is not user
	 */
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null && this.getClass() != o.getClass()) return false;
		User u = (User)o;
		return this.userId.equals(u.userId) 
				&& this.username.equals(u.username) && this.active == u.active
				&& this.infoUser.equals(u.infoUser) && this.password.equals(u.password);	
	}
	public int hashCode() {
		return Objects.hash(this.userId, this.active, this.infoUser, this.password, this.username);
	}
}

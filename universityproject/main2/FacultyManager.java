package main2;

import java.io.Serializable;

public class FacultyManager extends Manager implements Serializable {
	private Faculty facultyName;
	
	public FacultyManager() {
		
	}
	/**
	 * Faculty Manager have assigned faculty name
	 * @param username
	 * @param password
	 * @param userId
	 * @param infoUser
	 * @param salary
	 * @param experienceYear
	 * @param facultyName
	 */
	public FacultyManager(String username, String password, String userId, UserPersonalInfo infoUser, double salary,int experienceYear,Faculty facultyName) {
		super(username, password, userId, infoUser, salary, experienceYear);
		this.facultyName = facultyName;

	}
	/**
	 * Add certain news to Database
	 * If news already exists, display message that news are already created
	 * @param n news
	 */
	public void createNews(News n) {
		if(!Data.INSTANCE.news.contains(n)) Data.INSTANCE.news.add(n);
		else { System.out.println("You already created this news! ");}
	}
	/**
	 * Delete certain news from Database
	 * Checks if news exists in database, if not - display message that news doesn't exist
	 * @param n news
	 * 
	 */
	public void deleteNews(News n) {
		if(Data.INSTANCE.news.contains(n)) Data.INSTANCE.news.remove(n);
		else {
			System.out.println("You can't delete this news, it doesn't exist!");
		}
	}
	/**
	 * View students in certain faculty
	 * @param f faculty
	 */
	public void viewStudentsInFaculty(Faculty f) {
		for(Student s:Data.INSTANCE.students) {
			if(s.faculty.equals(f)) System.out.println(s);
		}
		
	}
	/**
	 * Get name of faculty
	 * @return facultyName
	 */
	public Faculty getFacultyName() {
		return facultyName;
	}
	/**
	 * Set the name of faculty
	 * @param facultyName
	 */
	public void setFacultyName(Faculty facultyName) {
		this.facultyName = facultyName;
	}
	/**
	 * Get name of faculty
	 * @return getFacultyName() 
	 */
	public String toString() {
		return super.toString() + " " + getFacultyName();
	}
	
	

}

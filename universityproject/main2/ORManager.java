package main2;

import java.io.Serializable;

public class ORManager extends Manager implements Serializable {
	public ORManager() {
		
	}
	/**
	 * Constructor for Office Register Manager
	 * @param username
	 * @param password
	 * @param userId
	 * @param infoUser
	 * @param salary
	 * @param experienceYear
	 */
	public ORManager(String username, String password, String userId, UserPersonalInfo infoUser, double salary,int experienceYear) {
		super(username, password, userId, infoUser, salary, experienceYear);
	}
//	
//	public void addCoursesToStudents(Student s,Course c) {
//		if(Data.INSTANCE.students.contains(s)) {
//			if(Data.INSTANCE.courses.contains(c)) {
//				if(!s.getCourses().containsKey(c)) s.getCourses().put(c, new Mark());
//			}else System.out.println("There is no such course!");
//		}else System.out.println("There is no such student!");
//	}
//	
//	public void assignTeacherToCourse(Teacher t,Course c) {
//		if(Data.INSTANCE.teachers.contains(t)) {
//			if(!Data.INSTANCE.courses.contains(c)) {
//				if(!t.getCourses().contains(c)) t.getCourses().add(c);
//			}else System.out.println("There is no such course!");
//		}else System.out.println("There is no such teacher!");
//	}
//	
//	public void dropCourse(Student s,Course c) {
//		if(s.getCourses().containsKey(c)) s.getCourses().keySet().remove(c);
//		else System.out.println("This student has no " + c + " course!");
//	}
//	
//	public void createCourse(Course c) {
//		if(!Data.INSTANCE.courses.contains(c)) Data.INSTANCE.courses.add(c);
//		else System.out.println("This course already exists!");
//	}
	
	public String toString() {
		return super.toString();
	}
}

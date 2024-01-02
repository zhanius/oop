package main2;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

public class Course implements Serializable {
	/**
	 * Course have name,credits,instructors and lessons
	 */
	private static final long serialVersionUID = 6575069635870674545L;
	public String name;
	private int credits;
	private Vector<Teacher> instructors;
	Vector<Lesson> lessons;
	/**
	 * Constructor for course
	 * @param name
	 * @param credits
	 */
	public Course(String name, int credits) {
		super();
		this.name = name;
		this.credits = credits;
	}
	/**
	 * Get name of course
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set the name of course
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * Get all instructors of course
 * @return instructors All instructors, assigned to course
 */
	public Vector<Teacher> getInstructors() {
		return instructors;
	}
	/**
	 * Set instructors of course
	 * @param instructors
	 */
	public void setInstructors(Vector<Teacher> instructors) {
		this.instructors = instructors;
	}
	/**
	 * Get the lessons of course
	 * @return lessons
	 */
	public Vector<Lesson> getLessons() {
		return lessons;
	}
	/**
	 * Set number of lessons of course
	 * @param lessons
	 */
	public void setLessons(Vector<Lesson> lessons) {
		this.lessons = lessons;
	}
	/**
	 * Set number of credits of course
	 * @param n
	 */
	public void setCredits(int n) {
		this.credits = n;
	}
	/**
	 * Get number of credits of course
	 * @return
	 */
	public int getCredits() {
		return this.credits;
	}
	/**
	 * Display name and num of credits of the course
	 * @return name
	 * @return credits
	 */
	public String toString() {
		return "The name of course: " + this.name  + " [Number of credits for course " + this.credits + "];";
	}
	/**
	 * Generates hashcode to compare courses
	 */
	@Override
	public int hashCode() {
		return Objects.hash(instructors, lessons, name);
	}
	/**
	 * Equal method for courses
	 * @return Compares instructors, lessons and names of courses
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(instructors, other.instructors) && Objects.equals(lessons, other.lessons)
				&& Objects.equals(name, other.name);
	}
	
	
}

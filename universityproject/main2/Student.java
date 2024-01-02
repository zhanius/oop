package main2;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;

public class Student extends User implements Serializable,CanBeResearcher {
	@Serial
	private static final long serialVersionUID = 8102920673474663665L;
	transient Scanner in = new Scanner(System.in);
	public Faculty faculty;
	HashMap<Course,Mark> courses;
	private int numRetake = 0;
	private int studentCredits;
	{
		courses = new HashMap<Course, Mark>();
	}

	public Student(){super();}
	/**
	 * Consturctor for student
	 * @param username
	 * @param password
	 * @param userId
	 * @param infoUser
	 * @param faculty
	 */
	public Student(String username, String password, String userId, UserPersonalInfo infoUser,Faculty faculty) {
		super(username, password, userId, infoUser,faculty);
	}

	/**
	 * Get courses of the student
	 * @return
	 */
	public HashMap<Course, Mark> getCourses() {
		return courses;
	}
	/**
	 * Drop certain course
	 * @param c
	 */
	public void dropCourse(Course c) {
		courses.remove(c);
	}
	/**
	 * Set course for the student
	 * @param courses
	 */
	public void setCourses(HashMap<Course, Mark> courses) {
		this.courses = courses;
	}
	/**
	 * Get number of retakes of the student
	 * @return
	 */
	public int getNumRetake() {
		return numRetake;
	}
	/**
	 * Set the number of retakes of the student
	 * @param numRetake
	 */
	public void setNumRetake(int numRetake) {
		this.numRetake = numRetake;
	}
	/**
	 * Register student to certain course, if register is succesful there will be message  
	 * @param name
	 * @throws IOException
	 */
	public void registerCourse(String name) throws IOException{
		for(Course c: Data.INSTANCE.courses) {
			if(c.getName().equals(name)){
				courses.put(c, null);
				System.out.println(" Yes ");
			}
			
//		if(c.getName().equals(name)&& c.getCredits()<this.studentCredits) {
//			this.studentCredits-=c.getCredits();
//		}
		}
		save();
	}
	/**
	 * View grades of certain course
	 * @param c
	 * @return mark of the course or null if student does not have this course
	 */
	public Mark viewGrade(Course c) {
			for(HashMap.Entry<Course, Mark> entry : courses.entrySet() ) {
				if(c.equals(entry.getKey()))
					return entry.getValue();
				}
			return null;
			}
	/**
	 * Mark the student to the lesson and put him to the attendance list of the lesson
	 * @param l
	 */
	public void markAttendance(Lesson l) {
		HashMap<Student, Boolean> attendance = new HashMap<>();
		attendance.put(this, true);
		l.attendances.put(l.lessonDate,attendance);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = Integer.parseInt(prime * result + super.getUserId());
		result = prime * result + ((this.getUsername() == null) ? 0 : this.getUsername().hashCode());
		return result;
	}
	/**
	 * Enter to certain organization
	 * @param o
	 */
	public void enterOrganization(Organization o) {
		o.addMember(this);

	}
	/**
	 * View transcript of student
	 * @return getTranscript
	 */
	public Map<Student, Mark> viewTranscript(Transcript t) {
		return t.getTranscript();
	}
	/**
	 * Method to save the changes
	 * @throws IOException
	 */
	private void save() throws IOException {
		Data.write();
	}
	/**
	 * Method to exit the menu
	 */
	private void exit() {
		System.out.println("Bye bye");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Menu for student provided with several options, 1st - register for course, 2nd- view transcript, 3rd - drop course
	 * <p>
	 * 4th - mark attendance, 5th- get into organization, 6th - view courses, 7th -exit
	 * @throws IOException
	 */
	public void run() throws IOException {
		try {
			menu: while(true) {
				super.viewNews();
				Scanner in = new Scanner(System.in);
				System.out.println("What do you want to do? "
						+ "\n 1 - Register for course  \n 2 - View transcript \n 3 - Drop course \n 4 - Mark attendance \n 5 - Get into organization \n 6 - view courses \n 7 - exit  " );
				int choice = in.nextInt();
				if(choice == 1) {
					for(Course c: Data.INSTANCE.courses) {
						System.out.println(c);
					}
					String courseName = in.next();
					this.registerCourse(courseName);
					
				}
				else if(choice == 2) {
					for(Transcript t: Data.INSTANCE.transcripts) {
						for(HashMap.Entry<Student,Mark> tr : t.transcript.entrySet())
							if(t.transcript.containsKey(this)) {
								t.getTranscript();
							}
					}
				}
				else if(choice == 3) {
					String courseName = in.next();
					for(Entry<Course, Mark> entry : courses.entrySet()){
						if(entry.getKey().getName().equals(courseName)) {
							courses.remove(entry.getKey());
						}
					}
					
				}
				else if(choice == 4) {
					System.out.println("Enter course name");
					String courseName = in.next();
					System.out.println("Enter lesson type");
					String LessonType = in.next();
						for(Lesson l: Data.INSTANCE.lessons) {
							for(Course c: Data.INSTANCE.courses) {
								if(courseName.equals(c.getName()) && c.lessons.contains(l) && LessonType.equals(l.type)) {
									l.putAttendance(l.lessonDate, this, true);
									System.out.println("You assigned!");
								}
							}
					}
					
				}
				else if(choice == 5) {
					System.out.println("Enter organization name");
					String orgName = in.next();
					for(Organization o: Data.INSTANCE.organizations) {
						if(orgName.equals(o.getOrgName())){
							o.addMember(this);
							System.out.println("You get into organisation!!!");
						}
					}
				}else if(choice == 6) {
					for(Entry<Course,Mark> entry: courses.entrySet()) {
						System.out.println(entry.getKey());
						System.out.println(entry.getValue());
					}
				}
				else if(choice == 7) {
					exit();
					break menu;
				}
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}

	}
	/**
	 * Method to compare students by user id
	 * @return true if students id are equal
	 * @return false if student id are not equal or compared object is not student
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return this.getUserId().equals(other.getUserId());
	}
	/**
	 * Display username and userid of the student
	 * @return getUsername
	 * @return getUserId
	 */
	public String toString(){
		return this.getUsername() + ", id " + this.getUserId() ;
	}

}

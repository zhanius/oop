package main2;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Manager extends Employee implements Serializable{
	/**
	 * Manager has new,accepted and done requests and manager is using the scanner for certain methods 
	 */
	@Serial
	private static final long serialVersionUID = -1831276811715393046L;
	transient Scanner i = new Scanner(System.in);
	private Vector<Request> newRequests;
	private Vector<Request> acceptedRequests;
	private Vector<Request> doneRequests;
	
	public Manager() {
		
	}
	/**
	 * Print the list 
	 * @param list
	 */
	private void printList(List list) {
		for(int i=0; i<list.size(); i++)
			System.out.println(i+1+ ")" +list.get(i));
	}
	/**
	 * Constructor for Manager
	 * @param username
	 * @param password
	 * @param userId
	 * @param infoUser
	 * @param salary
	 * @param experienceYear
	 */
	public Manager(String username, String password, String userId, UserPersonalInfo infoUser, double salary,int experienceYear) {
		super(username, password, userId, infoUser, salary, experienceYear);
	}
	/**
	 * Receive the request and add it to new request vector
	 * @param r the request
	 */
	public void receiveRequest(Request r) {
		newRequests.add(r);
	}
	/**
	 * Uses scanner and adds all information about new student and adds student to Database
	 */
	public void addStudents() {
		System.out.println("Please enter all of information about this student!");
		System.out.println("Username: ");
		String username = i.next();
		System.out.println("Password: ");
		String password = i.next();
		System.out.println("User ID: ");
		String userId = i.next();
		
		Data.INSTANCE.students.add(new Student(username, password, userId, new UserPersonalInfo()));;
	}
	/**
	 * Adds teacher to Database
	 * @param t the teacher that will be added to Database
	 */
	public void addTeacher(Teacher t) {
		Data.INSTANCE.teachers.add(t);
	}
	/**
	 *  Uses scanner and adds all information about new course and adds it to Database
	 *  Display message when course is added
	 */
	private void addCourse() {
		Scanner course = new Scanner(System.in);
		System.out.println("Enter name of the course: ");
		String courseName = course.next();
		System.out.println("Enter number of credits: ");
		int n = course.nextInt();
		Data.INSTANCE.courses.add(new Course(courseName, n));
		System.out.println("Course added! ");		
	}
	/**
	 * Shows all students in Database
	 * @return true if students exists and display message that there are no students
	 * @return false if there are not students
	 */
	public boolean showStudents() {
		if(Data.INSTANCE.students.isEmpty()) {
			System.out.println("There are no students yet!");
			return false;
		}
		else {
			for(Student s:Data.INSTANCE.students) {
				System.out.println(s);
			}
			return true;
		}
	}
	/**
	 * Shows all teacher in Database
	 * Displays message if there are no teachers
	 */
	public void showTeachers() {
		if(Data.INSTANCE.teachers.isEmpty()) System.out.println("There are no teachers yet!");
		else {
			for(Teacher t:Data.INSTANCE.teachers) {
				System.out.println(t);
			}
		}
	}
	/**
	 * Show all courses in Database
	 * @return true if courses exists
	 * @return false if there are not courses
	 */
	public boolean showCourses(){
		if(Data.INSTANCE.courses.isEmpty()) {
			System.out.println("No courses yet...");
			return false;
		}
		printList(Data.INSTANCE.courses);
		return true;
	}
	
	/**
	 * Accept the request, updates the status of request,remove it from new requests and add it to accepted requests
	 * @param request
	 */
	public void acceptRequest(Request request) {
		if(request.getRequestStatus() != Status.REJECTED && request.getRequestStatus() != Status.DONE) {
			request.setRequestStatus(Status.ACCEPTED);
			newRequests.remove(request);
			acceptedRequests.add(request);
		}
		}
	/**
	 * Reject the request, updates the status of request, remove it from new requests and display rejected order of requests
	 * @param request
	 */
	public void rejectRequest(Request request) {
		if(request.getRequestStatus() != Status.ACCEPTED && request.getRequestStatus() != Status.DONE ) {
			request.setRequestStatus(Status.REJECTED);
			newRequests.remove(request);
			System.out.println(getUsername() + "'s rejected order " + request);
		}
		}
	
	/**
	 * Completes the order by removing it from new and accepted requests and updates it's status to done and adds it to done requests and display completed orders
	 * @param request
	 */
	public void completeRequest(Request request) {
		if(request.getRequestStatus() == Status.ACCEPTED) {
			newRequests.remove(request);
			acceptedRequests.remove(request);
			request.setRequestStatus(Status.DONE);
			doneRequests.add(request);
			
			System.out.println(getUsername() + "'s completed orders: ");
			for(Request r: doneRequests) {
				System.out.println(r);
			}
		}
	}
	/**
	 * Saves the changes
	 * @throws IOException 
	 */
	private void save() throws IOException {
		Data.write();
	}
	/**
	 * Exit from the menu {@link #run}
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
	 * Views accepted requests, new requests and done requests
	 */
	public void viewRequests() {
		System.out.println(getUsername() + "'s accepted requests:");
        for (Request r : acceptedRequests) {
            System.out.println(r);
        }
        	
        System.out.println(getUsername() + "'s new requests:");
        for (Request r : newRequests) {
            System.out.println(r);
        }
       
		System.out.println(getUsername() + "'s completed requests: ");
		for(Request r: doneRequests) {
			System.out.println(r);
		}
    }
	/**
	 * Add course to certain student, checks if course does exist and in succesful case adds it to student
	 * If student already registered to course, method will display another message
	 * @param s
	 */
	private void addCourseToStudent(Student s) {
		int a = i.nextInt()-1;
		Course c = Data.INSTANCE.courses.get(a);
		if(!s.courses.containsKey(c)) {
			s.courses.put(c, new Mark());
			System.out.println("Course "+Data.INSTANCE.courses.get(a) +" added to  "+s.getUsername());
		}
		else System.out.println("Student " + s.getUsername()+ " already registered to "+c);
	}

	/**
	 * Assing course to the teacher
	 * If teacher already assigned, the method will display message
	 * @param t the teacher
	 * @param c the course
	 */
	public void assignCourseToTeacher(Teacher t, Course c){
		if(Data.INSTANCE.courses.contains(c) && Data.INSTANCE.teachers.contains(t)) {
			t.setCourses(c);
			System.out.println("This teacher assigned to the course");

		}
	}
	/**
	 * Menu for manager, uses 5 options, 
	 * 1st calls {@link #addCourse()}, 2nd calls {@link #addCourseToStudent(Student)}, 
	 * <p>
	 * 3rd calls {@link #showStudents()}, 4th calls {@link #assignCourseToTeacher(Teacher, Course)}, 5th calls {@link #exit()}
	 * @throws IOException when the error happens in one of the methods or in the menu
	 */
	public void run() throws IOException {
		try {
			System.out.println("Welcome!");
			menu : while(true){
				Scanner in = new Scanner(System.in); 
				System.out.println("What do you want to do?\n 1) Add course  \n 2) Add course to a Student  \n 3) View students \n 4) Assign course to Teacher \n 5) Exit");
				int choice = in.nextInt();
				if (choice==1){
					addCourse: while(true){
						addCourse();
						System.out.println("\n 1) Add another course  \n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addCourse;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice==2){
					addCourseToStudent: while(true){
						System.out.println("Choose student to which you want to add course: (Enter number)");
						if(!showStudents()) continue menu;
						Student s = Data.INSTANCE.students.get(in.nextInt()-1);
						System.out.println("Choose course: (Enter number)");
						if(!showCourses()) continue menu;
						addCourseToStudent(s);
						System.out.println("\n 1) Add another course to some student  \n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addCourseToStudent;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if (choice==3){
					if(!showStudents()) continue menu;
					System.out.println("\n 1) Return back \n 2) Exit");
					choice = in.nextInt();
					if(choice==1) continue menu;
					if(choice==2) {exit();  break menu;}
					break;
				}
				else if(choice==4){
					int i = 0;
					for(Teacher t: Data.INSTANCE.teachers){
						System.out.println(i + " - " +  t);
						i += 1;
					}
					System.out.println("Enter the position: ");
					int pos = in.nextInt();
					i = 0;
					for(Course c: Data.INSTANCE.courses){
						System.out.println(i + " - " +  c);
						i += 1;
					}
					int cou = in.nextInt();
					this.assignCourseToTeacher(Data.INSTANCE.teachers.get(pos), Data.INSTANCE.courses.get(cou));
				}
				else if (choice==5){
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
	 * Display username and salary
	 * @return getUserName() 
	 * @return getSalary()
	 */
	public String toString() {
		return getUsername() + " " + getSalary();
	}


}


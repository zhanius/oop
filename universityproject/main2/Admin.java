package main2;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class Admin implements Serializable{
	@Serial
	private static final long serialVersionUID = 761401461783975190L;
	transient Scanner in;
	public Admin() {
		this.in = new Scanner(System.in);
	}
	/**
	 * Get all users in this method by getInstance method of singletone
	 */
	public void getUsers() {
		Data.getInstance().users.stream().forEach(u -> System.out.println(u));
	}
	/**
	 * Add users and by using n as option to add concrete type of user(except {@link Researcher})
	 * Each class has it's own parameters {@link Teacher},{@link Student},{@link Manager} 
	 * {@link Teacher} have several cases for it's type
	 * @throws IOException
	 */
	
	public void addUser() throws IOException {
		System.out.println("Who do you want to register? \n 1 - Student \n 2 - Teacher \n 3 - Manager \n 4 - Researcher");
		int n = in.nextInt();
		if(n == 1) {
			System.out.println("Please enter all of information about this user!");
			System.out.println("Username: ");
			String username = in.next();
			System.out.println("Password: ");
			String password = in.next();
			System.out.println("User ID: ");
			String userId = in.next();
			Data.INSTANCE.users.add(new Student(username, password, userId, new UserPersonalInfo()));
			Data.INSTANCE.students.add(new Student(username, password, userId, new UserPersonalInfo()));
		}else if(n == 2) {
			System.out.println("Please enter all of information about this user!");
			System.out.println("Username: ");
			String username = in.next();
			System.out.println("Password: ");
			String password = in.next();
			System.out.println("User ID: ");
			String userId = in.next();
			System.out.println("Enter salary: ");
			double salary = in.nextDouble();
			System.out.println("Enter experience year: ");
			int exYear = in.nextInt();
			System.out.println("Enter position: \n 1 - Professor \n 2 - Assistant \n 3 - Lector \n 4 - Senior Lector ");
			int i = in.nextInt();
			switch (i) {
				case 1: Data.INSTANCE.users.add(new Teacher(username, password, userId, new UserPersonalInfo(), salary, exYear, InstructorType.PROFESSOR));
					    Data.INSTANCE.teachers.add(new Teacher(username, password, userId, new UserPersonalInfo(), salary, exYear, InstructorType.PROFESSOR));
						break;
				case 2: Data.INSTANCE.users.add(new Teacher(username, password, userId, new UserPersonalInfo(), salary, exYear, InstructorType.ASSISTANT));
						Data.INSTANCE.teachers.add(new Teacher(username, password, userId, new UserPersonalInfo(), salary, exYear, InstructorType.ASSISTANT));
						break;
				case 3: Data.INSTANCE.users.add(new Teacher(username, password, userId, new UserPersonalInfo(), salary, exYear, InstructorType.LECTOR));
					    Data.INSTANCE.teachers.add(new Teacher(username, password, userId, new UserPersonalInfo(), salary, exYear, InstructorType.LECTOR));
						break;
				case 4: Data.INSTANCE.users.add(new Teacher(username, password, userId, new UserPersonalInfo(), salary, exYear, InstructorType.SENIOR_LECTOR));
					    Data.INSTANCE.teachers.add(new Teacher(username, password, userId, new UserPersonalInfo(), salary, exYear, InstructorType.SENIOR_LECTOR));
						break;
			}
		} else if(n == 3) {
			System.out.println("Please enter all of information about this user!");
			System.out.println("Username: ");
			String username = in.next();
			System.out.println("Password: ");
			String password = in.next();
			System.out.println("User ID: ");
			String userId = in.next();
			System.out.println("Enter salary: ");
			double salary = in.nextDouble();
			System.out.println("Enter experience year: ");
			int exYear = in.nextInt();
			Manager manager = new Manager(username, password, userId, new UserPersonalInfo(), salary, exYear);
			Data.INSTANCE.users.add(manager);
			Data.INSTANCE.managers.add(manager);
		}
		else if(n == 4){
			System.out.println("Please enter all of information about this user!");
			System.out.println("Username: ");
			String username = in.next();
			System.out.println("Password: ");
			String password = in.next();
			System.out.println("User ID: ");
			String userId = in.next();
			System.out.println("Enter salary: ");
			double salary = in.nextDouble();
			System.out.println("Enter experience year: ");
			int exYear = in.nextInt();
			BaseResearcher baseResearcher = new BaseResearcher(username, password, userId, new UserPersonalInfo(), salary, exYear);
			Data.INSTANCE.users.add(baseResearcher);
			Data.write();
			Data.INSTANCE.researchers.add(baseResearcher);
			Data.write();
			Data.INSTANCE.baseResearchers.add(baseResearcher);
			Data.write();
		}
	}
	/**
	 * Method for removing user by index in University Database
	 * @param n  to remove user by index
	 * @throws Exception
	 */
	public void removeUser(int n) throws Exception {
		Data.INSTANCE.users.remove(n);
	}
	/**
	 * See log files of specific {@link User}
	 * @param u
	 * @throws Exception
	 */
	public void seeLogFiles(User u) throws Exception {
		if(Data.INSTANCE.users.contains(u)) {
			for(UserAction ua : Data.getInstance().userActions) {
				if(ua.getUser().equals(u)) {
					System.out.println(ua);
				}
			}
		}
		throw (new NoSuchUserException("Such user not exists!!!"));
	}
	/**
	 * Save all changes
	 * @throws IOException
	 */
	private void save() throws IOException {
		Data.write();
	}
	/**
	 * Exit from menu {@link run}
	 * Tries to catch Input Output exception 
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
	 * Run admin menu
	 * If selected, provides several options, each of them calls method of the same name as option name
	 * 1st method calls {@link #addUser()}
	 * 2nd method calls {@link #removeUser(int)}  by calling {@link #getUsers()}
	 * 3rd method calls {@link #getUsers()}
	 * 5th method calls {@link #exit()}
	 * @throws IOException if there was an error when admin choosing not available option or getting error from method call
	 * 
	 */
	public void run() throws IOException {
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do?\n 1) Add user \n 2) remove user  \n 3) get Users  \n 4) see log files \n 5) Exit");
				int choice = in.nextInt();
				if(choice==1){
					addUser: while(true){
						addUser();
						System.out.println("\n 1) Add another user  \n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addUser;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if (choice==2){
					removeUser: while(true){
						getUsers();
						//Data.INSTANCE.clearUsers();
						System.out.println("Please enter users index which will be removed!");
						int n = in.nextInt();
						removeUser(n);
						System.out.println("\n 1) remove another User  \n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue removeUser;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice==3){
					getUsers: while(true){
						getUsers();
						System.out.println("\n 1) Return back \n 2) Exit");
						choice = in.nextInt();
						if(choice==1) continue menu;
						if(choice==2) {exit(); break menu;}
						break;
					}
				}
//				else if (choice==4){
//					if(!showStudents()) continue menu;
//					System.out.println("\n 1) Return back \n 2) Exit");
//					choice = in.nextInt();
//					if(choice==1) continue menu;
//					if(choice==2) {exit();  break menu;}
//					break;
//				}
				else if (choice==5){
					exit();
					break menu;
				}
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \nSaving resources...");
			e.printStackTrace();
			save();
		}
	}
	
	public String toString() {
		return "";
	}
}

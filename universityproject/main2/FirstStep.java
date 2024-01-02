package main2;

import java.io.IOException;
import java.util.Scanner;

public class FirstStep {
	public static void main(String[] args) throws IOException {
		Admin a = new Admin();
		/**
		 * Menu for working with Database of University
		 * First, prints the welcome message and asks who is the guest by inputting from 1 to 5: {@link Student},{@link Teacher},{@link Manager},{@link Admin},{@link Researcher}
		 * If guest enters 6 he leaves from the menu
		 * Everytime guest need to login by username and password to start working 
		 */
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println("Welcome to this University site!!! "
					+ "\n Who are you?! \n 1 -> Student \n 2 -> Teacher "
					+ "\n 3 -> Manager \n 4 -> Admin  \n 5 -> Researcher \n 6 -> Exit");
			int choice = in.nextInt();
			if(choice == 1) {
				System.out.println("Student");
				System.out.println("Please enter the username and password");
				String username = in.next();
				String password = in.next();
				Data.INSTANCE.students.stream()
				.filter(u -> u.username.equals(username) && u.password.equals(password))
				.findFirst()
				.ifPresent(student -> {
					try {
						student.run();
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				
			} else if(choice == 2) {
				System.out.println("Teacher");
				System.out.println("Please enter the username and password");
				String username = in.next();
				String password = in.next();
				Data.INSTANCE.teachers.stream()
				.filter(u -> u.username.equals(username) && u.password.equals(password))
				.findFirst()
				.ifPresent(teacher -> {
					try {
						teacher.run();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			} else if(choice == 3) {
				System.out.println("Manager");
				System.out.println("Please enter the username: ");
				String username = in.next();
				System.out.println("Please enter the password: ");
				String password = in.next();
				Data.INSTANCE.managers.stream()
						.filter(u -> u.username.equals(username) && u.password.equals(password))
						.findFirst()
						.ifPresent(manager -> {
							try {
								manager.run();
							} catch (IOException e) {
								e.printStackTrace(); // Handle the exception appropriately
							}
						});
			} else if(choice == 4) {
				try {
					a.run();
				} catch (IOException ioe){
					ioe.printStackTrace();
				}
			} else if(choice == 5) {
				System.out.println("Researcher");
				System.out.println("Please enter the username: ");
				String username = in.next();
				System.out.println("Please enter the password: ");
				String password = in.next();
				Data.INSTANCE.baseResearchers.stream()
						.filter(u -> u.username.equals(username) && u.password.equals(password))
						.findFirst()
						.ifPresent(baseResearcher -> {
							try {
								baseResearcher.run();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						});
			}
			else if(choice == 6) {
				break;
			}
		}
	}
}

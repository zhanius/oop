package main2;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.Vector;
import java.util.*;

public class Teacher extends Employee implements Serializable,CanBeResearcher{
    @Serial
    private static final long serialVersionUID = 8667429774938008107L;
    transient Scanner in = new Scanner(System.in);
    private InstructorType position;
    private Vector<Course> courses;
    private Vector<Lesson> lessons;

    //constructors
    public Teacher(){ super(); }
    /**
     * Constructor for teacher
     * @param username
     * @param password
     * @param userID
     * @param infoUser
     * @param salary
     * @param experienceYear
     * @param position
     */
    public Teacher(String username, String password, String userID, UserPersonalInfo infoUser,Double salary,
                   Integer experienceYear, InstructorType position){
        super(username,password,userID,infoUser,salary,experienceYear);
        this.position = position;
        courses = new Vector<Course>();
    }

    //setters
    /**
     * Add the course to the teacher
     * @param course
     */
    public void setCourses(Course course){
        this.courses.add(course);
    }
    /**
     * Set the position(type) of teacher
     * @param position
     */
    public void setPosition(InstructorType position){
        this.position = position;
    }
    //getters
    /**
     * Get teacher's courses
     * @return courses
     */
    public Vector<Course> getCourses() {
        return courses;
    }
    /**
     * Get position(type) of teacher
     * @return position
     */
    public InstructorType getPosition() {
        return position;
    }

    //adding course into collection courses
  
    public void addCourse(Course course){
        courses.add(course);
    }
    /**
     * View the courses
     */
    public void viewCourses(){
        courses.stream().forEach(c -> System.out.println(c.getName()));
    }

    //send complaints to other Employees
    /**
     * Send the complaints to the other employees 
     * @param complaint
     * @param l  the urgency level
     */
    public void sendComplaints(String complaint,UrgencyLevel l){
    	Dean dean = new Dean();
    	Complaint c = new Complaint(this, dean,complaint,new Date(),l);
    	if (!dean.complaints.containsKey(this)) {
	    	dean.complaints.put(this, new Vector<>());
	    	}

	    dean.complaints.get(this).add(c);
       
    }
    /**
     * Assign grade of course to certain student
     * @param s the student
     * @param c the course
     * @throws Exception
     */
    public void assignGrade(Student s, Course c) throws Exception {
        s.getCourses().get(c);
    }
    /**
     * Check the total score of each student, if student's total score is below 30 student gets +1 retake, else the teacher should enter the point for the final
     * @param c the course
     */
    public void takeFinalExam(Course c){
        Data.INSTANCE.students.stream().forEach(s -> {
            if (s.getCourses().containsKey(c)) {
                double totalPoint = s.getCourses().get(c).getFirstAttestation() + s.getCourses().get(c).getSecondAttestation();
                if (totalPoint < 30) {
                    s.getCourses().get(c).setFinalExam(0);
                    s.setNumRetake(s.getNumRetake() + 1);
                } else {
                    System.out.println("Enter the points for final: ");
                    int finalExam = in.nextInt();
                    s.getCourses().get(c).setFinalExam(finalExam);
                }
            }
        });
    }

    //equals and toString
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
     * Menu for teacher provided by several options, 1st lets to send the complaint and urgency level , 2nd - view courses, 
     * <p>
     * 3rd - assign mark of course to certain student, 4th - assign attendance to the lesson of certain student, 5th -exit 
     * @throws IOException
     */
    public void run() throws IOException {
		try {
			System.out.println("Welcome!");
			menu : while(true){
                Scanner ii = new Scanner(System.in);
				System.out.println("What do you want to do?\n 1) Sent complaint  \n 2) View Courses  \n 3) Assign mark \n 4)Assign attendance \n 5) Exit");
				int choice = ii.nextInt();
				if (choice==1){
					complain: while(true){ 
						System.out.println("Enter the complaint: ");
						String description = ii.next();
						UrgencyLevel level = null;
						System.out.println("Pick the urgency level: \n 1 - low   2 - medium  3 - high");
						int i = ii.nextInt();
						switch (i) {
							case 1: level = UrgencyLevel.LOW;
							case 2: level = UrgencyLevel.MEDIUM;
							case 3: level = UrgencyLevel.HIGH;
						}
						sendComplaints(description, level);
						System.out.println("\n 1) Sent another complaint  \n 2) Return back \n 3) Exit");
						choice = ii.nextInt();
						if(choice==1) continue complain;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice==2){
					viewCourses();
				}
//				else if (choice==3){
//					if(!showStudents()) continue menu;
//					System.out.println("\n 1) Return back \n 2) Exit");
//					choice = in.nextInt();
//					if(choice==1) continue menu;
//					if(choice==2) {exit();  break menu;}
//					break;
//				}
				else if (choice==4){
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
     * Method to compare teachers by position and courses
     * @return true if positions and assigned courses are equal
     * @return false if positions and assigned courses are not equal or compared object is not teacher 
     */
    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;
        if(!(o instanceof Teacher)) return false;
        Teacher t = (Teacher) o;
        return this.position == t.position && this.courses.equals(t.courses);
    }
    /**
     * Displays the username and position of teacher
     * @return getUsername
     * @return getPosition
     */
    public String toString(){
        return super.getUsername() + " with position " + this.getPosition();
    }
}
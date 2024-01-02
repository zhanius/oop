package main2;

import java.io.*;
import java.util.HashMap;
import java.util.Vector;

public class Data implements Serializable{
	@Serial
	/**
	 * Database of University
	 * Contains all about University itself
	 */
	private static final long serialVersionUID = -363875340015837088L;
	Vector<ResearchPaper> researchPapers = new Vector<ResearchPaper>();
	Vector<ResearchProject> researchProjects = new Vector<ResearchProject>();
	Vector<Researcher>researchers = new Vector<Researcher>();
	Vector<BaseResearcher>baseResearchers = new Vector<BaseResearcher>();
	Vector<User> users = new Vector<User>();
	Vector<Course> courses = new Vector<Course>();
	Vector<Student> students  = new Vector<Student>();
	Vector<Teacher> teachers = new Vector<Teacher>();
	Vector<Manager> managers = new Vector<Manager>();
	Vector<News> news = new Vector<News>();
	HashMap<Employee, Vector<Message>> messages = new HashMap<Employee, Vector<Message>>();
	HashMap<Teacher, Vector<Complaint>> complaints = new HashMap<Teacher,Vector<Complaint>>();
	Vector<UserAction>  userActions = new Vector<UserAction>();
	Vector<Lesson> lessons = new Vector<Lesson>();
	Vector<Organization> organizations = new Vector<Organization>();
	Vector<Transcript> transcripts = new Vector<Transcript>();
	public static Data INSTANCE;

	static {
		try {
			if (new File("data").exists()) {
				INSTANCE = read();
			} else {
				INSTANCE = new Data();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Initialize INSTANCE to a default value or handle the exception as appropriate
			INSTANCE = new Data();
		}
	}
	
	private Data() {}
	/**
	 * This method read the data of database 
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Data read() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("data");
		ObjectInputStream oin = new ObjectInputStream(fis);
		return (Data) oin.readObject();
	}
	/**
	 * This method rites and saves the changes of database
	 * @throws IOException
	 */
	public static void write()throws IOException{
		FileOutputStream fos = new FileOutputStream("data");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(INSTANCE);
		oos.close();
	}
	/**
	 * Specific method for some classes
	 * @return INSTANCE
	 */
	public static synchronized Data getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Data();
        }
        return INSTANCE;
    }
}

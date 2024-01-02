package main2;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.*;
public class BaseResearcher extends Employee implements Researcher, Serializable {
	@Serial
	private static final long serialVersionUID = -1332853818577010283L;
	//transient Scanner in = new Scanner(System.in);
	private int hIndex;
	private Vector<ResearchProject> projects;
	private Vector<ResearchPaper> papers;

	
	public BaseResearcher() {super();}
	/**
	 * Constructor for base researcher
	 * add projects and papers vectors to base reseacher
	 * @param username
	 * @param password
	 * @param userID
	 * @param infoUser
	 * @param salary
	 * @param experienceYear
	 */
	public BaseResearcher(String username, String password, String userID, UserPersonalInfo infoUser,Double salary,
				   Integer experienceYear){
		super(username,password,userID,infoUser,salary,experienceYear);
		projects = new Vector<>();
		papers = new Vector<>();
	}

	//getter
	/**
	 * Get the projects of the researcher
	 * @return projects
	 */
	public Vector<ResearchProject> getProjects() {
		return projects;
	}
	/**
	 * Get the papers of the reseacher
	 * @return papers
	 */
	public Vector<ResearchPaper> getPapers() {
		return papers;
	}

	//setter
	/**
	 * Set the project to the reseacher
	 * @param projects
	 */
	public void setProjects(Vector<ResearchProject> projects){
		this.projects = projects;
	}
	/**
	 * Set the papers to the researcher
	 * @param researchPapers
	 */
	public void setPapers(Vector<ResearchPaper> researchPapers){
		this.papers = papers;
	}
	/**
	 * Set the H-index to researcher;
	 * @param hIndex
	 */
	public void sethIndex(int hIndex){
		this.hIndex = hIndex;
	}
	/**
	 * Add papers to the researcher
	 */
	@Override
	public void addPaper(ResearchPaper researchPaper) {
		papers.add(researchPaper);
	}

	/**
	 * Add projects to the researcher
	 */
	@Override
	public void addProject(ResearchProject researchProject){
		projects.add(researchProject);
	}
	/**
	 * Print projects of the researcher
	 */
	@Override
	public void printProjects(){
		projects.stream().forEach(c -> System.out.println(c));
	}
	/**
	 * Join to certain projects
	 * If researcher is already a member of project, display the according message
	 * Else add researcher to the project
	 * @param researchProject
	 */
	public void joinProject(ResearchProject researchProject) {
		if (projects.contains(researchProject)) {
			System.out.println("Is already a member.");
		} else {
			projects.add(researchProject);
			System.out.println("Added into new project.");
		}
	}

	// method to print sorted papers
	/**
	 * Sort papers by date using comparator
	 */
	@Override
	public void printPapers() {
		Collections.sort(papers, new DateComparatorPaper());
		for (ResearchPaper paper : papers) {
			System.out.println(paper);
		}
	}

	//calculate H index
	/**
	 * Calculate the H-index 
	 * @throws  HindexLimitException  there are insufficient h-index
	 * @return hIndex
	 */
	@Override
	public int calcHindex() throws HindexLimitException {
		List<Integer> sortedCounts = papers.stream()
				.flatMap(paper -> paper.getCitationsPlain().values().stream())
				.sorted(Collections.reverseOrder())
				.collect(Collectors.toList()); sortedCounts = papers.stream()
				.flatMap(paper -> paper.getCitationsPlain().values().stream())
				.sorted(Collections.reverseOrder())
				.collect(Collectors.toList());

		int[] sortedCountsArray = sortedCounts.stream().mapToInt(Integer::intValue).toArray();

		int hIndex = 0;
		for(int i = sortedCounts.size() - 1; i>=0; i--){
			int cnt = sortedCounts.size()-i;
			if(sortedCountsArray[i] >= cnt){
				hIndex = cnt;
			}else{
				break;
			}
		}
		return hIndex;
	}
	/**
	 * Menu for researcher has several options, 1st adds research papers, 2nd let to view research papers,
	 * <p>
	 * 3rd calculates H-index, 4th add research project, 5th lets to view research projects, 6th let to exit from menu
	 * @throws IOException
	 */
	public void run() throws IOException {
		try {
			menu: while(true) {
				super.viewNews();
				Scanner ii = new Scanner(System.in);
				System.out.println("What do you want to do? "
						+ "\n 1 - Add research paper  \n 2 - View research papers \n 3 - Calculate H-index \n 4 - Add research project \n 5 - View research projects \n 6 - Exit  " );
				int choice = ii.nextInt();
				if(choice == 1) {
					System.out.println("Please enter the title for Research Paper: ");
					String title = ii.next();
					System.out.println("Please enter the number of pages: ");
					int pages = ii.nextInt();
					System.out.println("Please enter the year of publishment");
					int year = ii.nextInt();
					System.out.println("Please enter the month of publishment");
					int month = ii.nextInt();
					System.out.println("Please enter the day of publishment");
					int day = ii.nextInt();
					LocalDate localDate = LocalDate.of(year,month,day);
					ResearchPaper researchPaper = new ResearchPaper(title,this, pages,localDate);
					addPaper(researchPaper);
					Data.INSTANCE.researchPapers.add(researchPaper);
				}
				else if(choice == 2) {
					printProjects();
				}
				else if(choice == 3) {
					System.out.println("Your H-index is: " + calcHindex());
				}
				else if(choice == 4) {
					System.out.println("Choose: \n 1 - Get into an existing project \n 2 - Add new Research Project");
					int i = ii.nextInt();
					switch (i){
						case 1: Data.INSTANCE.researchProjects.stream().forEach(r -> System.out.println(r));
							System.out.println("Choose the position: ");
							int j = ii.nextInt();
							this.addProject(Data.INSTANCE.researchProjects.get(j));
							Data.INSTANCE.researchProjects.get(j).addMember(this);
						case 2:
							System.out.println("Please enter the title of New Project: ");
							String title = ii.next();
							ResearchProject researchProject = new ResearchProject(title);
							researchProject.addMember(this);
							Data.INSTANCE.researchProjects.add(researchProject);
							this.addProject(researchProject);
					}

				}
				else if(choice == 5) {
					printProjects();
				}
				else if(choice == 6) {
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
	/**
	 * Method to save changes
	 * @throws IOException
	 */
	private void save() throws IOException {
		Data.write();
	}
	/** 
	 * Method to exit
	 */
	private void exit() {
		System.out.println("Bye bye");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
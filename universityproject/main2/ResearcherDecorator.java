package main2;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Collectors;


public class ResearcherDecorator implements Researcher{
    private CanBeResearcher researcher;
    private Vector<ResearchProject> projects;
    private Vector<ResearchPaper> papers;
    
    private ResearcherDecorator(CanBeResearcher researcher) {
        this.researcher = researcher;
    }
    /**
     * Make the researcher and initialize projects and papers
     * @param researcher
     * @return decorator
     */
    public static Researcher makeResearcher(CanBeResearcher researcher) {
        ResearcherDecorator decorator = new ResearcherDecorator(researcher);
        decorator.projects = new Vector<>(); // Инициализация вектора проектов
        decorator.papers = new Vector<>(); //Инициализация вектора ресерч-пейперов
        return decorator;
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
    /**
     * Method to calculate the H-Index
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
        for(int i = sortedCounts.size() - 1; i>=0; i++){
            int cnt = sortedCounts.size()-i;
            if(sortedCountsArray[i] >= cnt){
                hIndex = cnt;
            }else{
                break;
            }
        }
        return hIndex;
    }
   
    @Override
    public void printPapers() {
        Collections.sort(papers, new DateComparatorPaper());
        papers.stream().forEach(c -> System.out.println(c));
    }
    @Override
    public void addPaper(ResearchPaper researchPaper) {
        papers.add(researchPaper);
    }
    @Override
    public void addProject(ResearchProject researchProject){
        projects.add(researchProject);
    }
    @Override
    public void printProjects(){
        projects.stream().forEach(c -> System.out.println(c));
    }

    @Override
    public String toString() {
        return "ResearcherDecorator{" +
                "researcher=" + researcher +
                ", projects=" + projects +
                ", papers=" + papers +
                '}';
    }
    /**
     * Menu for researcher decorator ,the same as the {@link BaseResearcher}
     * @throws IOException
     */
    public void run() throws IOException {
        try {
            menu: while(true) {
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
     * Method to save the changes 
     * @throws IOException
     */
    private void save() throws IOException {
        Data.write();
    }
    /**
     * Method to exit menu
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

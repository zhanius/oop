package main2;

import java.util.Vector;

public class ResearchProject {
	/**
	 * Research project has title researchers and research papers vectors
	 */
    public String title;
    public Vector<ResearchPaper> researchPapers = new Vector<>();
    public Vector<Researcher> researchers = new Vector<>();
    /**
     * Constructor for research project
     * @param title
     */
    public ResearchProject(String title){
        this.title = title;
    }
    /**
     * Add member to the project
     * @param researcher
     */
    public void addMember(Researcher researcher){
        researchers.add(researcher);
    }
   /**
    * Add paper to the project
    * @param researchPaper
    */
    public void addPaper(ResearchPaper researchPaper){
        researchPapers.add(researchPaper);
    }
    /**
     * Display all information about project
     * @return title
     * @return researchPapers
     * @return researchers
     */
    @Override
    public String toString() {
        return "ResearchProject{" +
                "title='" + title + '\'' +
                ", researchPapers=" + researchPapers +
                ", researchers=" + researchers +
                '}';
    }
}

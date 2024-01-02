package main2;

public interface Researcher {
    void printPapers();
    int calcHindex() throws HindexLimitException;
    void addPaper(ResearchPaper researchPaper) throws UserIsNotResearcherException;
    void addProject(ResearchProject researchProject);
    void printProjects();

}

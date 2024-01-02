package main2;
import java.time.LocalDate;
import java.util.*;
public class ResearchPaper {
    private Map<String,Integer> citationsBib = new HashMap<>();
    private Map<String,Integer> citationsPlain = new HashMap<>();
    private String title;
    private Researcher author;
    private int pages;
    private LocalDate publDate;
    public ResearchPaper(){}
    /**
     * Constructor for research paper
     * @param title
     * @param author
     * @param pages
     * @param publDate
     */
    public ResearchPaper(String title, Researcher author, int pages, LocalDate publDate){
        this.citationsBib = new HashMap<>();
        this.citationsPlain = new HashMap<>();
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.publDate = publDate;
    }
    //methods
    /**
     * Get citations of paper in bib or plain format
     * @param f
     */
    public void getCitations(Format f){
        if(f == Format.BIB_TEXT){
            citationsBib.keySet().forEach(key -> System.out.println(key));
        }
        if(f == Format.PLAIN_TEXT){
            citationsPlain.keySet().forEach(key -> System.out.println(key));
        }
    }

    // equals and hashcod
    /**
     * Method for comparing papers by title
     * @return true if titles of papers are equal
     * @return false if titles are not equal or compared object is not paper
     */
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        ResearchPaper p = (ResearchPaper)o;
        return this.getTitle().equals(p.getTitle());
    }
    @Override
    public int hashCode(){
        return Objects.hash(citationsBib,citationsPlain,title,author,pages,publDate);
    }

    //setters, getters, toString()
    /**
     * Add citations to the paper in bib format
     * @param s
     * @param i
     */
    public void addCitationBib(String s,int i){
        citationsBib.put(s,i);
    }
    /**
     * Add citations to the paper in plain format
     * @param s
     * @param i
     */
    public void addCitationPlain(String s,int i){
        citationsPlain.put(s,i);
    }
    /**
     * Get the title of paper
     * @return title
     */
    public String getTitle() {return title;}
    /**
     * Set the title of the paper
     * @param title
     */
    public void setTitle(String title) {this.title = title;}
    /**
     * Get publishing date of the paper
     * @return publDate
     */
    public LocalDate getPublDate() {
        return publDate;
    }
    /**
     * Set the publishing date of the paper
     * @param publDate
     */
    public void setPublDate(LocalDate publDate) {
        this.publDate = publDate;
    }
    /**
     * Get pages of the paper
     * @return pages
     */
    public int getPages() {
        return pages;
    }
    /**
     * Set the pages of the paper
     * @param pages
     */
    public void setPages(int pages) {
        this.pages = pages;
    }
    /**
     * Set citations of the paper of plain format
     * @param citationsPlain
     */
    public void setCitationsPlain(Map<String, Integer> citationsPlain) {
        this.citationsPlain = citationsPlain;
    }
    /**
     * Get author of the paper
     * @return author
     */
    public Researcher getAuthor() {
        return author;
    }
    /**
     * Set the author of the paper
     */
    public void setAuthor(Researcher author) {
        this.author = author;
    }
    /**
     * Set citations of the paper in bib format
     * @param citationsBib
     */
    public void setCitationsBib(Map<String, Integer> citationsBib) {
        this.citationsBib = citationsBib;
    }
    /**
     * Get citations of paper in bib format
     * @return citationsBib
     */
    public Map<String,Integer> getCitationsBib(){
        return this.citationsBib;
    }
    /**
     * Get citations of paper in plain format
     * @return citationsPlain
     */
    public Map<String,Integer> getCitationsPlain(){
        return this.citationsPlain;
    }
    /**
     * Display title, author and publishing date of paper
     * @return getTitle
     * @return getAuthor
     * @return getPublDate
     */
    @Override
    public String toString() {
        return this.getTitle() + ' ' + this.getAuthor() + ' ' + this.getPublDate();
    }


}

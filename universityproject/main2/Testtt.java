package main2;

import java.time.LocalDate;
import java.util.Date;

public class Testtt {
    public static void main(String[]args) throws Exception {
        Student s = new Student("User","User","22b",new UserPersonalInfo());

        Researcher decorator = ResearcherDecorator.makeResearcher(s);
        BaseResearcher baseResearcher = new BaseResearcher("Ayaulym Kuat", "1234","sdfgh",new UserPersonalInfo(),150000.0,8);
        ResearchPaper researchPaper = new ResearchPaper("Bullet train", baseResearcher, 125, LocalDate.now());
        researchPaper.addCitationPlain("ddfjkdsggieqkregndsvrndfndvkru",8);
        researchPaper.addCitationPlain("dhfsdfrteut84848", 10);
        researchPaper.addCitationPlain("dhffrteut84848", 97);
        researchPaper.addCitationPlain("dhffrteut8", 97);
        researchPaper.addCitationPlain("dhffrteu", 32);
        researchPaper.addCitationPlain("dhfft8", 21);

        baseResearcher.addPaper(researchPaper);
        System.out.println(baseResearcher.calcHindex());
        baseResearcher.printPapers();
    }
}

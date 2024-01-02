package main2;

import java.util.Comparator;

public class DateComparatorPaper implements Comparator<ResearchPaper> {
	/**
	 * Compare the publishing date of two Research Papers
	 * @param r1 
	 * @param r2
	 */
    @Override
    public int compare(ResearchPaper r1, ResearchPaper r2) { return r1.getPublDate().compareTo(r2.getPublDate()); }
}

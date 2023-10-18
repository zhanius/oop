package labwork2.task2;
import java.util.HashSet;

public class Testim {
    public static void main(String[]args){
        Science s = new Science("Physics","22-238");
        Science s1 = new Science("Chemistry", "22-234");
        Science s2 = new Science("Computer", "34-423");
        Science s3 = new Science("Chemistry", "22-234");
        HashSet<Book>hs = new HashSet<>();
        hs.add(s);
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        for(Book h : hs){
                System.out.println(h);
        }
    }
}

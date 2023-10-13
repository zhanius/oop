package prac3.prob2;

import java.util.Vector;

public class Testim {
    public static void main(String[]args){
        Student s = new Student("Zhansulu","Manhattan Avenue","is",2,123.2);
        Staff s1 = new Staff("Aizhan", "BLABLA1", "Ahmadeeva 112", 123.2);
        Vector<Person> p = new Vector<>();
        p.add(s);
        p.add(s1);
        System.out.println(s1);
        System.out.println(s);
    }
}

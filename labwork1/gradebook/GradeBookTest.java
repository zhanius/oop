package labwork1.gradebook;
import prac2.Student;

import java.util.Scanner;
import java.util.Vector;

public class GradeBookTest {
    public static void main(String[]args){
        Course course = new Course("CS550", "Object-Oriented Programming and Design",5, "PP2");

        Vector <Student> students = new Vector<>();

        students.add(new Student("Someoneoneone", 10, 47));
        students.add(new Student("Someoneone",23, 65));
        students.add(new Student("Someone", 79, 89));
        students.add(new Student("Kamazhay", 54, 100));
        students.add(new Student("Zhansulu",68,90));
        students.add(new Student("Gabdylgaziz", 67,100));


        GradeBook gradeBook = new GradeBook(course,students);
        System.out.println(gradeBook.displayMessage());
        gradeBook.setStudents();
        System.out.println(gradeBook.displayReport());
    }
}

package labwork1.gradebook;
import java.util.Scanner;
import java.util.Vector;
import prac2.Student;

public class GradeBook {
    public Course course;
    public Vector <Student> students;


    public GradeBook(Course course, Vector students){
        this.course = course;
        this.students = students;
    }
    public String displayMessage(){
        return "Welcome to the grade book for " +  course.name + " " + course.description + "!\n";
    }
    public String displayReport() {
        double sum = 0;
        int lowGrade = Integer.MAX_VALUE;
        int highGrade = Integer.MIN_VALUE;
        String studHigh = "";
        String studLow = "";
        int idHigh = 0, idLow = 0;
        for (Student i : students) {
            sum += i.grade;
            if (i.grade <= lowGrade) {
                lowGrade = i.grade;
                studLow = i.name;
                idLow = i.id;
            } else if (i.grade >= highGrade) {
                highGrade = i.grade;
                studHigh = i.name;
                idHigh = i.id;
            }
        }
        StringBuilder ret = new StringBuilder();
        ret.append("Class average is " + String.valueOf(sum / students.size()) + ". Lowest grade is " + String.valueOf(lowGrade) + " (" + String.valueOf(studLow) + ",id: " + String.valueOf(idLow) + ").\n");
        ret.append("Highest grade is " + String.valueOf(highGrade) + " (" + studHigh + ',' + "id: " + String.valueOf(idHigh) + ')' + "\n" + "\n");
        ret.append("Grades distribution:\n\n");


            for (int j = 0; j <= 100; j += 10) {
                int cnt = 0;
                for (Student student : students) {
                    if (j <= student.grade && student.grade <= j + 9) {
                        cnt++;
                    }
                }
                String barChart = "*".repeat(cnt);
                if(j == 100){
                    ret.append(String.valueOf(j+": "));
                    ret.append(barChart + "\n");
                } else{
                    ret.append(String.valueOf(j + "-" + (j + 9) + ": "));
                    ret.append(barChart + "\n");
                }
                cnt = 0;
                String barchart = "";
        }
        return ret.toString();
    }

    public void setStudents(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please, input grades for students: " + "\n");
        for (Student i : students){
            System.out.print(i.name + ": ");
            int grade = s.nextInt();
            i.grade = grade;
        }
        System.out.println();
    }

}

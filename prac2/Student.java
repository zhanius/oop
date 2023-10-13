package prac2;

public class Student{
    public String name;
    public int id;
    public int grade;
    public Student(String name, int id,int grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
    public void setGrade(){
        this.grade = grade;
    }
    public int getGrade(int grade){
        return this.grade;
    }
}

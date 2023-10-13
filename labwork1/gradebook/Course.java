package labwork1.gradebook;
import java.util.Vector;
public class Course {
    public String name;
    public String description;
    public int credits;
    public Vector <String> prerequisites;
    public Course(String name, String description, int credits, String... prerequisites){
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.prerequisites = new Vector<String>();
    }
    public void setName(){
        this.name = name;
    }
    public void setDescription(){
        this.description = description;
    }
    public void setCredits(){
        this.credits = credits;
    }
    public void setPrerequisites(String... prerequisites) {
        for (String p : prerequisites) {
            this.prerequisites.add(p);
        }
    }

}

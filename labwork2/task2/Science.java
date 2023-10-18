package labwork2.task2;
public class Science extends Book {
    public Science() {
        super();
    }
    public Science(String name, String color) {
        super(name, color);
    }
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Science c = (Science) o;
        return c.name==this.name;
    }
    public String toString(){
        return super.toString();
    }
}

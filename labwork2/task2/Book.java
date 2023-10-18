package labwork2.task2;
import java.util.Objects;

public abstract class Book {
    String name;
    String code;
    public Book(){
    }
    public Book(String name, String code){
        this.name=name;
        this.code=code;
    }
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        Book p = (Book)o;
        return p.code==this.code && this.name.equals(p.name);
    }
    @Override
    public int hashCode(){
        return Objects.hash(name,code);
    }
    public String toString(){
        return "The Book name is %s its code %s".formatted(name,code);
    }
}

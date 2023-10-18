package labwork2.task1.sec;
public abstract class LibraryItem{
    protected String title;
    protected String author;
    protected int pubYear;
    public LibraryItem(){
    }
    public LibraryItem(String title,String author, int pubYear){
        this.author=author;
        this.pubYear=pubYear;
        this.title=title;
    }
    abstract String getType();
    protected String getTitle(){
        return this.title;
    }
    protected String getAuthor(){
        return this.author;
    }
    protected int getPubYear(){
        return this.pubYear;
    }
    public String toString(){
        return "Author of %s with title %s is %s. Published year is %d.".formatted(getType(), getTitle(), getAuthor(), getPubYear());
    }
}

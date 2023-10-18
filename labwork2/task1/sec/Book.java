package labwork2.task1.sec;

public class Book extends LibraryItem{
    int numberOfPages;
    String isbn;
    String placeOfPubl;
    public Book(){
        super();
    }
    public Book(String title, String author, int pubYear, int numberOfPages, String placeOfPubl, String isbn){
        super(title, author, pubYear);
        this.numberOfPages = numberOfPages;
        this.placeOfPubl = placeOfPubl;
        this.isbn = isbn;
    }
    @Override
    String getType(){
        return "Book";
    }
    public String toString(){
        return super.toString() + "\nPublished place is %s. The book contains %s pages.".formatted(placeOfPubl,numberOfPages);
    }
}

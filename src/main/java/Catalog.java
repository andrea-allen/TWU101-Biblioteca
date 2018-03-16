import java.io.PrintStream;
import java.util.ArrayList;

public class Catalog {

    private ArrayList<Book> books;

    public Catalog(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

}

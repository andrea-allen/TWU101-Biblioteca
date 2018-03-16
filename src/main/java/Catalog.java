import java.io.PrintStream;
import java.util.ArrayList;

public class Catalog {

    private ArrayList<Book> books;
    private PrintStream printStream;

    public Catalog(ArrayList<Book> books, PrintStream printStream) {
        this.books = books;
        this.printStream = printStream;
    }

    public void listBooks() {
        String bookList = "";
        for (Book book : books) {
            bookList += book.info() + "\n";
        }
        printStream.println(bookList);
    }
}

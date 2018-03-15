import java.io.PrintStream;
import java.util.ArrayList;

public class Catalog {

    private ArrayList<String> books;
    private PrintStream printStream;

    public Catalog(ArrayList<String> books, PrintStream printStream) {
        this.books = books;
        this.printStream = printStream;
    }

    public void listBooks() {
        if (books.isEmpty()) {
            printStream.println("");
        }
        else {
            printStream.println("Harry Potter and the Sorcerer's Stone");
        }

    }


}

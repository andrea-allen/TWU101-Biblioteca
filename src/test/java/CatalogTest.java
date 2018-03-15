import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CatalogTest {

    private Catalog catalog;
    private PrintStream printStream;
    private ArrayList<String> books;

    @Test
    public void shouldPrintNoBooksWhenCatalogIsEmpty(){
        printStream = mock(PrintStream.class);
        books = new ArrayList<>();
        catalog = new Catalog(books, printStream);
        catalog.listBooks();
        verify(printStream).println("");
    }

    @Test
    public void shouldPrintBookWhenCatalogHasOneBook() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<>();
        String book1 = "Harry Potter and the Sorcerer's Stone";
        books.add(book1);
        catalog = new Catalog(books, printStream);
        catalog.listBooks();
        verify(printStream).println("Harry Potter and the Sorcerer's Stone");
    }
}

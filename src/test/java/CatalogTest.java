import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CatalogTest {

    private Catalog catalog;
    private PrintStream printStream;
    private ArrayList<String> books;

    @Before
    public void SetUp() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<>();
        catalog = new Catalog(books, printStream);
    }


    @Test
    public void shouldPrintNoBooksWhenCatalogIsEmpty(){
        catalog = new Catalog(books, printStream);
        catalog.listBooks();
        verify(printStream).println("");
    }

    @Test
    public void shouldPrintBookWhenCatalogHasOneBook() {
        String book1 = "Harry Potter and the Sorcerer's Stone";
        books.add(book1);
        catalog.listBooks();
        verify(printStream).println("Harry Potter and the Sorcerer's Stone\n");
    }

    @Test
    public void shouldPrintBothBooksWhenCatalogHasTwoBooks() {
        String book1 = "Life of Pi";
        String book2 = "The Goose Girl";
        books.add(book1);
        books.add(book2);
        catalog.listBooks();
        verify(printStream).println("Life of Pi\nThe Goose Girl\n");
    }
}

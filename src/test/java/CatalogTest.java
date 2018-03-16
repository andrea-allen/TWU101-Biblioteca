import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CatalogTest {

    private Catalog catalog;
    private PrintStream printStream;
    private ArrayList<Book> books;

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
        Book book1 = new Book("Harry Potter and the Sorcerer's Stone", "JK Rowling", "1990");
        books.add(book1);
        catalog.listBooks();
        verify(printStream).println("Harry Potter and the Sorcerer's Stone : JK Rowling : 1990\n");
    }

    @Test
    public void shouldPrintBothBooksWhenCatalogHasTwoBooks() {
        Book book1 = new Book("Life of Pi", "Yan Martel", "2005");
        Book book2 = new Book("The Goose Girl", "Fancy Author", "3050");
        books.add(book1);
        books.add(book2);
        catalog.listBooks();
        verify(printStream).println("Life of Pi : Yan Martel : 2005\nThe Goose Girl : Fancy Author : 3050\n");
    }
}

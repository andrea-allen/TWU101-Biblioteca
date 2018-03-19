
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class CatalogTest {

    private Catalog catalog;
    private Book catcher_in_the_rye;
    private ArrayList<Book> books;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        catcher_in_the_rye = new Book("Catcher In The Rye", "JD Salinger", "1960");
        books.add(catcher_in_the_rye);
        catalog = new Catalog(books);
    }

    @Test
    public void checkoutBookShouldPutBookInCheckedOutBooksList() throws Exception {
        catalog.checkoutBook(catcher_in_the_rye.getTitle());
        assertTrue(catalog.getCheckedOutBooks().contains(catcher_in_the_rye));
    }

    @Test
    public void checkedOutBookShouldNotBeInAvailableBooks() {
        catalog.checkoutBook(catcher_in_the_rye.getTitle());
        assertTrue(!catalog.getAvailableBooks().contains(catcher_in_the_rye));
    }

}
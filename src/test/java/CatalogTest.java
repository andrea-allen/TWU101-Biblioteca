
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
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

    @Test
    public void checkoutBookShouldReturnFalseIfBookIsNotAvailable() {
        boolean result = catalog.checkoutBook("Some Other Book");
        assertFalse(result);

    }

    @Test
    public void checkoutBookShouldReturnTrueIfBookIsAvailable() {
        boolean result = catalog.checkoutBook(catcher_in_the_rye.getTitle());
        assertTrue(result);

    }

    @Test
    public void returnBookShouldPutBookInAvailableBookList() {
        catalog.checkoutBook(catcher_in_the_rye.getTitle());
        catalog.returnBook(catcher_in_the_rye.getTitle());
        assertTrue(catalog.getAvailableBooks().contains(catcher_in_the_rye));
    }

    @Test
    public void returnedBookShouldNotBeInCheckedOutBooks() {
        catalog.checkoutBook(catcher_in_the_rye.getTitle());
        catalog.returnBook(catcher_in_the_rye.getTitle());
        assertTrue(!catalog.getCheckedOutBooks().contains(catcher_in_the_rye));
    }


    @Test
    public void returnBookShouldReturnFalseIfBookIsNotCheckedOut() {
        boolean result = catalog.returnBook(catcher_in_the_rye.getTitle());
        assertFalse(result);

    }

    @Test
    public void returnBookShouldReturnTrueIfBookIsCheckedOut() {
        catalog.checkoutBook(catcher_in_the_rye.getTitle());
        boolean result = catalog.returnBook(catcher_in_the_rye.getTitle());
        assertTrue(result);

    }
}
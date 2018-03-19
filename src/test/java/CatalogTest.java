
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CatalogTest {

    private Catalog catalog;
    private Book catcher_in_the_rye;
    private Movie call_me_by_your_name;
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        catcher_in_the_rye = new Book("Catcher In The Rye", "JD Salinger", "1960");
        books.add(catcher_in_the_rye);
        movies = new ArrayList<>();
        call_me_by_your_name = new Movie("Call Me By Your Name", "Luca Guadagnino", "2017", "8.1");
        movies.add(call_me_by_your_name);
        catalog = new Catalog(books, movies);
    }

    @Test
    public void checkoutBookShouldPutBookInCheckedOutBooksList() {
        catalog.checkoutBook(catcher_in_the_rye.getTitle());
        assertTrue(catalog.getCheckedOutBooks().contains(catcher_in_the_rye));
    }

    @Test
    public void checkoutMovieShouldPutMovieInCheckedOutMoviesList() {
        catalog.checkoutMovie(call_me_by_your_name.getTitle());
        assertTrue(catalog.getCheckedOutMovies().contains(call_me_by_your_name));
    }

    @Test
    public void checkedOutBookShouldNotBeInAvailableBooks() {
        catalog.checkoutBook(catcher_in_the_rye.getTitle());
        assertTrue(!catalog.getAvailableBooks().contains(catcher_in_the_rye));
    }

    @Test
    public void checkedOutMovieShouldNotBeInAvailableMovies() {
        catalog.checkoutMovie(call_me_by_your_name.getTitle());
        assertTrue(!catalog.getAvailableMovies().contains(call_me_by_your_name));
    }

    @Test
    public void checkoutBookShouldReturnFalseIfBookIsNotAvailable() {
        boolean result = catalog.checkoutBook("Some Other Book");
        assertFalse(result);
    }

    @Test
    public void checkoutMovieShouldReturnFalseIfMovieIsNotAvailable() {
        boolean result = catalog.checkoutMovie("Some Other Movie");
        assertFalse(result);
    }

    @Test
    public void checkoutBookShouldReturnTrueIfBookIsAvailable() {
        boolean result = catalog.checkoutBook(catcher_in_the_rye.getTitle());
        assertTrue(result);
    }

    @Test
    public void checkoutMovieShouldReturnTrueIfMovieIsAvailable() {
        boolean result = catalog.checkoutMovie(call_me_by_your_name.getTitle());
        assertTrue(result);
    }

    @Test
    public void returnBookShouldPutBookInAvailableBookList() {
        catalog.checkoutBook(catcher_in_the_rye.getTitle());
        catalog.returnBook(catcher_in_the_rye.getTitle());
        assertTrue(catalog.getAvailableBooks().contains(catcher_in_the_rye));
    }

    @Test
    public void returnMovieShouldPutMovieInAvailableMovieList() {
        catalog.checkoutMovie(call_me_by_your_name.getTitle());
        catalog.returnMovie(call_me_by_your_name.getTitle());
        assertTrue(catalog.getAvailableMovies().contains(call_me_by_your_name));
    }

    @Test
    public void returnedBookShouldNotBeInCheckedOutBooks() {
        catalog.checkoutBook(catcher_in_the_rye.getTitle());
        catalog.returnBook(catcher_in_the_rye.getTitle());
        assertTrue(!catalog.getCheckedOutBooks().contains(catcher_in_the_rye));
    }

    @Test
    public void returnedMovieShouldNotBeInCheckedOutMovies() {
        catalog.checkoutMovie(call_me_by_your_name.getTitle());
        catalog.returnMovie(call_me_by_your_name.getTitle());
        assertTrue(!catalog.getCheckedOutMovies().contains(call_me_by_your_name));
    }

    @Test
    public void returnBookShouldReturnFalseIfBookIsNotCheckedOut() {
        boolean result = catalog.returnBook(catcher_in_the_rye.getTitle());
        assertFalse(result);
    }

    @Test
    public void returnMovieShouldReturnFalseIfMovieIsNotCheckedOut() {
        boolean result = catalog.returnMovie(call_me_by_your_name.getTitle());
        assertFalse(result);
    }

    @Test
    public void returnBookShouldReturnTrueIfBookIsCheckedOut() {
        catalog.checkoutBook(catcher_in_the_rye.getTitle());
        boolean result = catalog.returnBook(catcher_in_the_rye.getTitle());
        assertTrue(result);
    }

    @Test
    public void returnMovieShouldReturnTrueIfMovieIsCheckedOut() {
        catalog.checkoutMovie(call_me_by_your_name.getTitle());
        boolean result = catalog.returnMovie(call_me_by_your_name.getTitle());
        assertTrue(result);
    }

    @Test
    public void getAvailableMoviesShouldReturnAvailableMovies() {
        ArrayList<Movie> availableMovies = catalog.getAvailableMovies();
        assertEquals(availableMovies, movies);
    }
}
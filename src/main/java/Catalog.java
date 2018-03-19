import java.util.ArrayList;

public class Catalog {

    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks = new ArrayList<>();

    private ArrayList<Movie> availableMovies;
    private ArrayList<Movie> checkedOutMovies = new ArrayList<>();

    public Catalog(ArrayList<Book> books, ArrayList<Movie> movies) {

        availableBooks = books;
        availableMovies = movies;
    }

    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public ArrayList<Movie> getAvailableMovies() { return availableMovies; }

    public ArrayList<Movie> getCheckedOutMovies() { return checkedOutMovies; }

    public boolean checkoutBook(String bookTitle) {
        Book bookToCheckout = findBookByTitle(bookTitle, availableBooks);

        if (bookToCheckout != null) {
            availableBooks.remove(bookToCheckout);
            checkedOutBooks.add(bookToCheckout);
            return true;
        }
        return false;
    }

    public boolean checkoutMovie(String movieTitle) {
        Movie movieToCheckout = findMovieByTitle(movieTitle, availableMovies);

        if (movieToCheckout != null) {
            availableMovies.remove(movieToCheckout);
            checkedOutMovies.add(movieToCheckout);
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookTitle) {
        Book bookToReturn = findBookByTitle(bookTitle, checkedOutBooks);
        if (bookToReturn != null) {
            availableBooks.add(bookToReturn);
            checkedOutBooks.remove(bookToReturn);
            return true;
        }
        return false;
    }

    public boolean returnMovie(String movieTitle) {
        Movie movieToReturn = findMovieByTitle(movieTitle, checkedOutMovies);
        if (movieToReturn != null) {
            availableMovies.add(movieToReturn);
            checkedOutMovies.remove(movieToReturn);
            return true;
        }
        return false;
    }

    private Book findBookByTitle(String bookTitle, ArrayList<Book> bookList) {
        for (Book book: bookList) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    private Movie findMovieByTitle(String movieTitle, ArrayList<Movie> moviesList) {
        for (Movie movie : moviesList) {
            if (movie.getTitle().equals(movieTitle)) {
                return movie;
            }
        }
        return null;
    }
}

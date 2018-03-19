import java.util.ArrayList;

public class Catalog {

    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks = new ArrayList<>();

    private ArrayList<Movie> availableMovies;

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

    public boolean checkoutBook(String bookTitle) {
        Book bookToCheckout = findBookByTitle(bookTitle, availableBooks);

        if (bookToCheckout != null) {
            availableBooks.remove(bookToCheckout);
            checkedOutBooks.add(bookToCheckout);
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

    private Book findBookByTitle(String bookTitle, ArrayList<Book> bookList) {
        for (Book book: bookList) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }
}

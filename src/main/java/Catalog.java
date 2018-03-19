import java.util.ArrayList;

public class Catalog {

    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks = new ArrayList<>();

    public Catalog(ArrayList<Book> books) {
        availableBooks = books;
    }

    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }

    public boolean checkoutBook(String bookTitle) {
        Book bookToRemove = findBookByTitle(bookTitle);

        if (bookToRemove != null) {
            availableBooks.remove(bookToRemove);
            checkedOutBooks.add(bookToRemove);
            return true;
        }
        return false;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    private Book findBookByTitle(String bookTitle) {
        for (Book book: availableBooks) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

}

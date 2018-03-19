import java.io.BufferedReader;
import java.io.IOException;

public class Biblioteca {

    private Catalog catalog;
    private Menu menu;
    private Printer printer;
    private BufferedReader reader;

    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca!";
    private static final String INVALID_OPTION_MESSAGE = "You selected an invalid option.";
    private static final String GOODBYE_MESSAGE = "Thank you for using Biblioteca. Goodbye!";
    private static final String CHECKOUT_BOOK_PROMPT = "Which book would you like to check out?";
    private static final String CHECKOUT_BOOK_SUCCESS_MESSAGE = "Thank you! Enjoy your book.";
    private static final String CHECKOUT_BOOK_FAILURE_MESSAGE = "This book is not available.";
    private static final String RETURN_BOOK_PROMPT = "Which book would you like to return?";
    private static final String RETURN_BOOK_SUCCESS_MESSAGE = "Thank you for returning the book.";
    private static final String RETURN_BOOK_FAILURE_MESSAGE = "That is not a valid book to return.";
    private static final String CHECKOUT_MOVIE_PROMPT = "Which movie would you like to check out?";
    private static final String CHECKOUT_MOVIE_SUCCESS_MESSAGE = "Thank you! Enjoy your movie.";
    private static final String CHECKOUT_MOVIE_FAILURE_MESSAGE = "This movie is not available.";
    private static final String RETURN_MOVIE_PROMPT = "Which movie would you like to return?";
    private static final String RETURN_MOVIE_SUCCESS_MESSAGE = "Thank you for returning the movie.";
    private static final String RETURN_MOVIE_FAILURE_MESSAGE = "That is not a valid movie to return.";

    public Biblioteca(Catalog catalog, Menu menu, Printer printer, BufferedReader reader){
        this.catalog = catalog;
        this.menu = menu;
        this.printer = printer;
        this.reader = reader;
    }

    public void start() {
        showWelcomeMessage();
        runMenuLoop();
    }

    private void showWelcomeMessage() {
        printer.print(WELCOME_MESSAGE);
    }

    private void runMenuLoop() {
        boolean quit = false;
        while (!quit) {
            showMenu();
            quit = handleUserInput();
        }
    }

    protected void showMenu() {
        printer.print(menu.options());
    }

    protected boolean handleUserInput() {
        String menuOption = getUserInput();
        if (menuOption.equals("1")) {
            listBooks();
        } else if (menuOption.equals("2")) {
            listMovies();
        } else if (menuOption.equals("3")) {
            checkOutBook();
        } else if (menuOption.equals("4")) {
            returnBook();
        } else if (menuOption.equals("5")) {
            checkOutMovie();
        } else if (menuOption.equals("6")) {
            returnMovie();
        } else if (menuOption.equals("0")) {
            displayGoodbyeMessage();
            return true;
        } else {
            displayInvalidOptionMessage();
        }
        return false;
    }

    private void checkOutBook() {
        printer.print(CHECKOUT_BOOK_PROMPT);
        String bookTitle = getUserInput();
        if (catalog.checkoutBook(bookTitle)) {
            printer.print(CHECKOUT_BOOK_SUCCESS_MESSAGE);
        } else {
            printer.print(CHECKOUT_BOOK_FAILURE_MESSAGE);
        };

    }

    private void checkOutMovie() {
        printer.print(CHECKOUT_MOVIE_PROMPT);
        String movieTitle = getUserInput();
        if (catalog.checkoutMovie(movieTitle)) {
            printer.print(CHECKOUT_MOVIE_SUCCESS_MESSAGE);
        } else {
            printer.print(CHECKOUT_MOVIE_FAILURE_MESSAGE);
        }
    }

    private void returnBook() {
        printer.print(RETURN_BOOK_PROMPT);
        String bookTitle = getUserInput();
        if (catalog.returnBook(bookTitle)) {
            printer.print(RETURN_BOOK_SUCCESS_MESSAGE);
        } else {
            printer.print(RETURN_BOOK_FAILURE_MESSAGE);
        }
    }

    private void returnMovie() {
        printer.print(RETURN_MOVIE_PROMPT);
        String movieTitle = getUserInput();
        if (catalog.returnMovie(movieTitle)) {
            printer.print(RETURN_MOVIE_SUCCESS_MESSAGE);
        } else {
            printer.print(RETURN_MOVIE_FAILURE_MESSAGE);
        }
    }

    private String getUserInput() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    private void displayGoodbyeMessage() {
        printer.print(GOODBYE_MESSAGE);
    }

    private void displayInvalidOptionMessage() {
        printer.print(INVALID_OPTION_MESSAGE);
    }

    private void listBooks() {
        printer.printBooks(catalog.getAvailableBooks());
    }

    private void listMovies() {  printer.printMovies(catalog.getAvailableMovies()); }


}

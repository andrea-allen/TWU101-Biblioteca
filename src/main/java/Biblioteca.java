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
        String menuOption = getMenuOptionFromUser();
        if (menuOption.equals("1")) {
            listBooks();
        } else if (menuOption.equals("2")) {
            checkOutBook();
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
        try {
            String bookTitle = reader.readLine();
            catalog.checkoutBook(bookTitle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getMenuOptionFromUser() {
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


}

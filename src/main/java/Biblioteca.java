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

    public Biblioteca(Catalog catalog, Menu menu, Printer printer, BufferedReader reader){
        this.catalog = catalog;
        this.menu = menu;
        this.printer = printer;
        this.reader = reader;
    }

    public void start() {
        printer.print(WELCOME_MESSAGE);
        runMenuLoop();
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
        String menuOption = null;
        try {
            menuOption = reader.readLine();
        } catch (IOException e) {
            displayInvalidOptionMessage();
            return false;
        }

        if (menuOption.equals("1")) {
            listBooks();
        } else if (menuOption.equals("0")) {
            displayGoodbyeMessage();
            return true;
        } else {
            displayInvalidOptionMessage();
        }
        return false;
    }

    private void displayGoodbyeMessage() {
        printer.print(GOODBYE_MESSAGE);
    }

    private void displayInvalidOptionMessage() {
        printer.print(INVALID_OPTION_MESSAGE);
    }

    private void listBooks() {
        printer.printBooks(catalog.getBooks());
    }
}

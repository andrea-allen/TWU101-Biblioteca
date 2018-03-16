import java.io.PrintStream;

public class Biblioteca {

    private Catalog catalog;
    private PrintStream printStream;
    private Menu menu;
    private Printer printer;

    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca!";

    public Biblioteca(Catalog catalog, Menu menu, PrintStream printStream, Printer printer){
        this.catalog = catalog;
        this.printStream = printStream;
        this.menu = menu;
        this.printer = printer;
    }

    public void start() {
        printer.print(WELCOME_MESSAGE);
        showMenu();
        catalog.listBooks();
    }

    public void showMenu() {
        String menuOptions = menu.options();
        printStream.println(menuOptions);
    }
}

import java.io.PrintStream;

public class Biblioteca {

    private WelcomeGreeter welcomeGreeter;
    private Catalog catalog;
    private PrintStream printStream;
    private Menu menu;

    public Biblioteca(WelcomeGreeter welcomeGreeter, Catalog catalog, Menu menu, PrintStream printStream){
        this.catalog = catalog;
        this.welcomeGreeter = welcomeGreeter;
        this.printStream = printStream;
        this.menu = menu;
    }

    public void start() {
        welcomeGreeter.printGreeting();
        showMenu();
        catalog.listBooks();

    }

    public void showMenu() {
        String menuOptions = menu.options();
        printStream.println(menuOptions);
    }
}

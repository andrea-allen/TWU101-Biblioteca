import java.io.BufferedReader;
import java.io.IOException;

public class Biblioteca {

    private Catalog catalog;
    private Menu menu;
    private Printer printer;
    private BufferedReader reader;

    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca!";

    public Biblioteca(Catalog catalog, Menu menu, Printer printer, BufferedReader reader){
        this.catalog = catalog;
        this.menu = menu;
        this.printer = printer;
        this.reader = reader;
    }

    public void start() {
        printer.print(WELCOME_MESSAGE);
        showMenu();
        try {
            handleMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void listBooks() {
        printer.printBooks(catalog.getBooks());
    }

    public void showMenu() {
        printer.print(menu.options());
    }

    public void handleMenu() throws IOException {
        String menuOption = reader.readLine();
        if (menuOption.equals("1")) {
            listBooks();
        }
    }
}

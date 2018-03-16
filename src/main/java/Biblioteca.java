public class Biblioteca {

    private Catalog catalog;
    private Menu menu;
    private Printer printer;

    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca!";

    public Biblioteca(Catalog catalog, Menu menu, Printer printer){
        this.catalog = catalog;
        this.menu = menu;
        this.printer = printer;
    }

    public void start() {
        printer.print(WELCOME_MESSAGE);
        showMenu();
        listBooks();
    }

    protected void listBooks() {
        printer.printBooks(catalog.getBooks());
    }

    public void showMenu() {
        printer.print(menu.options());
    }
}

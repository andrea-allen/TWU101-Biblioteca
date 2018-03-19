import java.util.ArrayList;

public class Menu {

    private ArrayList<String> menu;
    private static final String MENU_TITLE = "Select a menu option:";
    private static final String QUIT = "0: Quit";
    private static final String LIST_BOOKS = "1: List books";
    private static final String CHECKOUT_BOOK = "2: Checkout book";

    public Menu() {
        menu = new ArrayList<>();
        menu.add(MENU_TITLE);
        menu.add(QUIT);
        menu.add(LIST_BOOKS);
        menu.add(CHECKOUT_BOOK);
    }

    public ArrayList<String> options() {
        return menu;
    }
}

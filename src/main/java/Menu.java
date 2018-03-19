import java.util.ArrayList;

public class Menu {

    private ArrayList<String> menu;
    private static final String MENU_TITLE = "\nSelect a menu option:";
    private static final String QUIT = "0: Quit";
    private static final String LIST_BOOKS = "1: List books";
    private static final String LIST_MOVIES = "2: List movies";
    private static final String CHECKOUT_BOOK = "3: Checkout book";
    private static final String RETURN_BOOK = "4: Return book";
    private static final String CHECKOUT_MOVIE = "5: Checkout movie";

    public Menu() {
        menu = new ArrayList<>();
        menu.add(MENU_TITLE);
        menu.add(QUIT);
        menu.add(LIST_BOOKS);
        menu.add(LIST_MOVIES);
        menu.add(CHECKOUT_BOOK);
        menu.add(RETURN_BOOK);
        menu.add(CHECKOUT_MOVIE);
    }

    public ArrayList<String> options() {
        return menu;
    }
}

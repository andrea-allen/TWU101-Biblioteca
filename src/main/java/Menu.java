import java.util.ArrayList;

public class Menu {

    private ArrayList<String> menu;
    private static final String MENU_TITLE = "Menu Options";
    private static final String OPTION1 = "1: List Books";

    public Menu() {
        menu = new ArrayList<>();
        menu.add(MENU_TITLE);
        menu.add(OPTION1);
    }

    public ArrayList<String> options() {
        return menu;
    }
}

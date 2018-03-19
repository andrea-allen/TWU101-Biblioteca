import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void menuIncludesTitle(){
        Menu menu = new Menu();
        assertEquals("\nSelect a menu option:", menu.options().get(0));
    }

    @Test
    public void menuIncludesListBooksOption(){
        Menu menu = new Menu();
        assertEquals("1: List books", menu.options().get(2));
    }

    @Test
    public void menuIncludesListMoviesOption(){
        Menu menu = new Menu();
        assertEquals("2: List movies", menu.options().get(3));
    }

    @Test
    public void menuIncludesCheckoutBookOption(){
        Menu menu = new Menu();
        assertEquals("3: Checkout book", menu.options().get(4));
    }

    @Test
    public void menuIncludesReturnBookOption(){
        Menu menu = new Menu();
        assertEquals("4: Return book", menu.options().get(5));
    }

    @Test
    public void menuIncludesQuitOption(){
        Menu menu = new Menu();
        assertEquals("0: Quit", menu.options().get(1));
    }


}
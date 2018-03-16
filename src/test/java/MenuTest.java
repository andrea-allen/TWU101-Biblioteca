import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void menuIncludesTitle(){
        Menu menu = new Menu();
        assertEquals("Menu Options", menu.options().get(0));
    }

    @Test
    public void menuIncludesListBooksOption(){
        Menu menu = new Menu();
        assertEquals("1: List Books", menu.options().get(1));
    }


}
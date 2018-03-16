import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void testOptionsReturnsMenuOptions(){
        Menu menu = new Menu();
        assertEquals("Menu Options\n1: List Books", menu.options());
    }


}
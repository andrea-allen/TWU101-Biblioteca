import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {

    @Test
    public void testDisplayMenu() {
        PrintStream printStream = mock(PrintStream.class);
        WelcomeGreeter welcomeGreeter = new WelcomeGreeter(printStream);
        Catalog catalog = new Catalog(new ArrayList<>(), printStream);
        Menu menu = new Menu();

        Biblioteca biblioteca = new Biblioteca(welcomeGreeter, catalog, menu, printStream);
        biblioteca.showMenu();
        verify(printStream).println("Menu Options\n1: List Books");
    }


}
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {

    private PrintStream printStream;
    private Catalog catalog;
    private Menu menu;
    private Biblioteca biblioteca;
    private Printer printer;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        catalog = new Catalog(new ArrayList<>(), printStream);
        menu = new Menu();
        printer = mock(Printer.class);
        biblioteca = new Biblioteca(catalog, menu, printer);
    }

    @Test
    public void testDisplayMenu() {
        biblioteca.showMenu();
        verify(printer).print(new Menu().options());
    }

    @Test
    public void startShouldDisplayWelcomeMessage() {
        biblioteca.start();
        verify(printer).print("Welcome to Biblioteca!");
    }
}
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaTest {

    private PrintStream printStream;
    private Catalog catalog;
    private Menu menu;
    private Biblioteca biblioteca;
    private Printer printer;
    private ArrayList<Book> books;
    private BufferedReader reader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<>();
        catalog = new Catalog(books);
        menu = new Menu();
        printer = mock(Printer.class);
        reader  = mock(BufferedReader.class);
        biblioteca = new Biblioteca(catalog, menu, printer, reader);
    }

    @Test
    public void testDisplayMenu() {
        biblioteca.showMenu();
        verify(printer).print(new Menu().options());
    }

    @Test
    public void startShouldDisplayWelcomeMessage() throws IOException {
        when(reader.readLine()).thenReturn("1");
        biblioteca.start();
        verify(printer).print("Welcome to Biblioteca!");
    }

    @Test
    public void handleMenuShouldPrintBooksWhenUserSelectsOption1() throws IOException {
        when(reader.readLine()).thenReturn("1");
        biblioteca.handleMenu();
        verify(printer).printBooks(books);
    }

    @Test
    public void handleMenuNotifiesUserOnInvalidStringOption() throws IOException {
        when(reader.readLine()).thenReturn("2");
        biblioteca.handleMenu();
        verify(printer).print("You selected an invalid option.");
    }

    @Test
    public void handleMenuNotifiesUserOnUnsupportedOptionType() throws IOException {
        when(reader.readLine()).thenThrow(new IOException());
        biblioteca.handleMenu();
        verify(printer).print("You selected an invalid option.");
    }
}
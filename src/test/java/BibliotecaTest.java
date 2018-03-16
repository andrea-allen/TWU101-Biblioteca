import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private Catalog catalog;
    private Menu menu;
    private Biblioteca biblioteca;
    private Printer printer;
    private ArrayList<Book> books;
    private BufferedReader reader;


    @Before
    public void setUp() {
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
    public void handleMenuShouldPrintBooksWhenUserSelectsOption1() throws IOException {
        when(reader.readLine()).thenReturn("1");
        biblioteca.handleUserInput();
        verify(printer).printBooks(books);
    }

    @Test
    public void startShouldHandleRepeatingMenuWhenUserSelectsOption1Then0() throws IOException {
        Menu menu = new Menu();

        when(reader.readLine()).thenReturn("1").thenReturn("0");

        biblioteca.start();
        verify(printer).print("Welcome to Biblioteca!");

        verify(printer, times(2)).print(menu.options());
        verify(printer).printBooks(books);
        verify(printer).print("Thank you for using Biblioteca. Goodbye!");

    }

    @Test
    public void handleMenuNotifiesUserOnInvalidStringOption() throws IOException {
        when(reader.readLine()).thenReturn("2");
        biblioteca.handleUserInput();
        verify(printer).print("You selected an invalid option.");
    }

    @Test
    public void handleMenuNotifiesUserOnUnsupportedOptionType() throws IOException {
        when(reader.readLine()).thenThrow(new IOException());
        biblioteca.handleUserInput();
        verify(printer).print("You selected an invalid option.");
    }

    @Test
    public void handleMenuExitsWhenUserSelectsQuit() throws IOException {
        when(reader.readLine()).thenReturn("0");
        biblioteca.handleUserInput();
        verify(printer).print("Thank you for using Biblioteca. Goodbye!");
    }
}
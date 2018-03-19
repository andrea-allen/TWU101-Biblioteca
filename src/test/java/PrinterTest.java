import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PrinterTest {

    private PrintStream printStream;
    private Printer printer;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        printer = new Printer(printStream);
    }

    @Test
    public void printShouldPrintAString(){
        String string = "myString";
        printer.print(string);
        verify(printStream).println(string);
    }

    @Test
    public void printShouldPrintAnArrayOfStrings() {
        ArrayList<String> stringArray = new ArrayList<>();
        stringArray.add("Red");
        stringArray.add("Green");
        printer.print(stringArray);
        verify(printStream).println("Red");
        verify(printStream).println("Green");
    }

    @Test
    public void printShouldPrintAnArrayOfBooks() {
        ArrayList<Book> bookArray = new ArrayList<>();
        Book book1 = new Book("Deltora Quest", "Emily Rodda", "2000");
        Book book2 = new Book("Angela's Ashes", "Frank McCourt", "1998");
        bookArray.add(book1);
        bookArray.add(book2);
        printer.printBooks(bookArray);
        verify(printStream).println("Deltora Quest : Emily Rodda : 2000");
        verify(printStream).println("Angela's Ashes : Frank McCourt : 1998");
    }

    @Test
    public void printShouldPrintAnArrayOfMovies() {
        ArrayList<Movie> movieArray = new ArrayList<>();
        Movie movie1 = new Movie("Pan's Labyrinth", "Guillermo del Toro", "2006", "8.2");
        Movie movie2 = new Movie("The Great Gatsby", "Baz Luhrmann", "2013", "7.3");

        movieArray.add(movie1);
        movieArray.add(movie2);
        printer.printMovies(movieArray);
        verify(printStream).println("Pan's Labyrinth : Guillermo del Toro : 2006 : 8.2");
        verify(printStream).println("The Great Gatsby : Baz Luhrmann : 2013 : 7.3");
    }

}
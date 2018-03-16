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
    public void printShouldPrintAnArrayOfStringsWithLineBreaks() {
        ArrayList<String> stringArray = new ArrayList<>();
        stringArray.add("Red");
        stringArray.add("Green");
        printer.print(stringArray);
        verify(printStream).println("Red");
        verify(printStream).println("Green");
    }

}
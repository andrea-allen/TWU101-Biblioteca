import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PrinterTest {

    @Test
    public void printStringShouldPrintAString(){
        String string = "myString";
        PrintStream printStream = mock(PrintStream.class);
        Printer printer = new Printer(printStream);
        printer.print(string);
        verify(printStream).println(string);
        }


}
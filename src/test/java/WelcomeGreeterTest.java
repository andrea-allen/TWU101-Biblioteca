import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;


public class WelcomeGreeterTest {

    private PrintStream printStream;

    @Test
    public void shouldPrintWelcomeGreeting() {
        printStream = mock(PrintStream.class);
        WelcomeGreeter welcomeGreeter = new WelcomeGreeter(printStream);
        welcomeGreeter.printGreeting();
        verify(printStream).println("Welcome to Biblioteca!");
    }
}

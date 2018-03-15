import java.io.PrintStream;

public class WelcomeGreeter {
    private PrintStream printStream;

    public WelcomeGreeter(PrintStream printStream){
        this.printStream=printStream;
    }

    public void printGreeting() {
        printStream.println("Welcome to Biblioteca!");
    }
}

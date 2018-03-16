import java.io.PrintStream;
import java.util.ArrayList;

public class Printer {
    private PrintStream printStream;

    public Printer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void print(String string) {
        printStream.println(string);
    }

    public void print(ArrayList<String> stringArray) {
        for (String word : stringArray) {
            printStream.println(word);
        }
    }
}

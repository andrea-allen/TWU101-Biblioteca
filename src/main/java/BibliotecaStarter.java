import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaStarter {

    public static void main(String[] args) {

        PrintStream printStream = new PrintStream(System.out);
        WelcomeGreeter welcomeGreeter = new WelcomeGreeter(printStream);
        ArrayList<String> books = new ArrayList<>();
        books.add("Harry Potter");
        books.add("Life of Pi");
        books.add("Moby Dick");
        Catalog catalog = new Catalog(books, printStream);
        Biblioteca biblioteca = new Biblioteca(welcomeGreeter, catalog);
        biblioteca.start();

    }

}

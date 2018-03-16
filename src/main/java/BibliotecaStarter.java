import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaStarter {

    public static void main(String[] args) {

        PrintStream printStream = new PrintStream(System.out);
        WelcomeGreeter welcomeGreeter = new WelcomeGreeter(printStream);
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("Life of Pi", "Yan Martel", "2005");
        Book book2 = new Book("The Goose Girl", "Fancy Author", "3050");
        books.add(book1);
        books.add(book2);
        Catalog catalog = new Catalog(books, printStream);
        Biblioteca biblioteca = new Biblioteca(welcomeGreeter, catalog);
        biblioteca.start();

    }

}

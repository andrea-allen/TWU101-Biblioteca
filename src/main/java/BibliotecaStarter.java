import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaStarter {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        Book book1 = new Book("Life of Pi", "Yan Martel", "2005");
        Book book2 = new Book("The Goose Girl", "Fancy Author", "3050");
        books.add(book1);
        books.add(book2);

        Movie movie1 = new Movie("Good Will Hunting", "Gus Van Sant", "1997", "8.3");
        Movie movie2 = new Movie("Moana", "Ron Clements", "2016", "7.6");
        movies.add(movie1);
        movies.add(movie2);
        Catalog catalog = new Catalog(books, movies);

        Menu menu = new Menu();
        PrintStream printStream = new PrintStream(System.out);
        Printer printer = new Printer(printStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Biblioteca biblioteca = new Biblioteca(catalog, menu, printer, reader);
        biblioteca.start();

    }

}

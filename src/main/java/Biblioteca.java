public class Biblioteca {

    private WelcomeGreeter welcomeGreeter;
    private Catalog catalog;

    public Biblioteca(WelcomeGreeter welcomeGreeter, Catalog catalog){
        this.catalog = catalog;
        this.welcomeGreeter = welcomeGreeter;
    }

    public void start() {
        welcomeGreeter.printGreeting();
        catalog.listBooks();

    }
}

public class Book extends LibraryItem {


    public Book(String title, String creator, String year) {
        super(title, creator, year);
    }

    @Override
    public String info() {
        return title + " : " + creator + " : " + year;
    }
}

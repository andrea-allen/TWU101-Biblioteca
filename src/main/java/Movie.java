public class Movie extends LibraryItem {

    private String rating;

    public Movie(String title, String director, String year, String rating) {
        super(title, director, year);
        this.rating = rating;
    }

    @Override
    public String info() {
        return title + " : " + creator + " : " + year + " : " + rating;
    }
}

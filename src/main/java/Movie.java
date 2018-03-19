public class Movie {

    private String title;
    private String director;
    private String year;
    private String rating;

    public Movie(String title, String director, String year, String rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String info() {
        return title + " : " + director + " : " + year + " : " + rating;
    }
}

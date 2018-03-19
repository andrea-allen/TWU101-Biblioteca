public abstract class LibraryItem {

    protected String title;
    protected String creator;
    protected String year;

    public LibraryItem(String title, String creator, String year) {
        this.title = title;
        this.creator = creator;
        this.year = year;
    }

    public abstract String info();

    public String getTitle() {
        return title;
    }
}

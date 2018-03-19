import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MovieTest {

    @Test
    public void shouldDisplayMovieInfo() {
        Movie movie = new Movie("Harry Potter and the Goblet of Fire", "Mike Newell", "2005", "7.7");
        String info = movie.info();
        assertEquals("Harry Potter and the Goblet of Fire : Mike Newell : 2005 : 7.7", info);
    }

}
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class BookTest {

    @Test
    public void shouldDisplayBookInfo(){
        Book book = new Book("Harry Potter", "JK Rowling", "2000");
        String info = book.info();
        assertEquals("Harry Potter : JK Rowling : 2000", info);
        }

}

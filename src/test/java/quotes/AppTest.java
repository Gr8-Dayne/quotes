package quotes;


import org.junit.Test;
import static org.junit.Assert.assertNotNull;


public class AppTest {
    @Test public void testIfReturningAQuoteAndAuthor() {
        String expected = App.getAuthorQuote();
        assertNotNull(expected);
    }
}
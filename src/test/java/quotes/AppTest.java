package quotes;


import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.*;
import static quotes.App.*;


public class AppTest {

    @Test public void testIfReturningAQuoteAndAuthor() {
        String expected = App.getLocalAuthorQuote();
//        System.out.println(expected);
        assertNotNull(expected);
    }

    // Stretch Goal for sure
//    @Test public void testGetAllStarWarsAPIInfo() throws IOException {
//        String expected = getAllStarWarsAPIInfo();
//        System.out.println(expected);
//        assertNotNull(expected);
//    }

    @Test public void testGetQuoteFromStarWarsAPI() throws IOException {
        String expected = getQuoteFromStarWarsAPI();
//        System.out.println(getQuoteFromStarWarsAPI());
        assertNotNull(expected);
    }

    @Test public void testGetFormattedAPIQuote() {
        String expected = getFormattedAPIQuote();
//        System.out.println(getFormattedAPIQuote());
        assertNotNull(expected);
    }

}
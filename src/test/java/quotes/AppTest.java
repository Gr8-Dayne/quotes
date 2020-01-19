package quotes;


import org.junit.Test;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.Assert.*;
import static quotes.App.*;


import java.util.*;
import static quotes.Quote.*;


public class AppTest {

    @Test public void testIfReturningAQuoteAndAuthor() {
        String expected = App.getLocalAuthorQuote();
        System.out.println(expected);
        assertNotNull(expected);
    }

    @Test public void testGetAllStarWarsAPIInfo() throws IOException {
        String expected = getAllStarWarsAPIInfo();
        System.out.println(expected);
        assertNotNull(expected);
    }

    @Test public void testGetQuoteFromStarWarsAPI() throws IOException {
        String expected = getQuoteFromStarWarsAPI();
        System.out.println(getQuoteFromStarWarsAPI());
        assertNotNull(expected);
    }

    @Test public void testGetFormattedAPIQuote() {
        String expected = getFormattedAPIQuote();
        System.out.println(getFormattedAPIQuote());
        assertNotNull(expected);
    }

}
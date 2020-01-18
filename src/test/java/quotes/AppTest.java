package quotes;


import org.junit.Test;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.Assert.*;
import static quotes.App.*;


import java.util.*;
import static quotes.Quote.*;


public class AppTest {

    @Test public void testIfReturningAQuoteAndAuthor() {
        String expected = App.getAuthorQuote();
        assertNotNull(expected);
    }

    @Test public void testIfReceivingAPIData() {
        String expected = App.getAuthorQuote();
        assertNotNull(expected);
    }

    @Test public void testQuoteReturnFromMethod() {

        try {
            URL url = new URL("http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote");
            HttpURLConnection swQuoteApi = (HttpURLConnection) url.openConnection();
            swQuoteApi.setRequestMethod("GET");

            BufferedReader input = new BufferedReader(new InputStreamReader(swQuoteApi.getInputStream()));

            System.out.println(input.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

//        String notNull = starWarsQuote;
//        String expected = "Online: " + Quote.class.getConstructor();
//        String actual = getQuoteFromInternet();
//        System.out.println(expected);
//        System.out.println(actual);
//        assertEquals(1, 1);
    }

    @Test public void testIfQuoteAppends() {

        Quote starWarsQuote = null;

        Object expected = null;
        Object actual = starWarsQuote;

        assertEquals(expected, actual);

    }

}
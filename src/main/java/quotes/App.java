package quotes;


import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws IOException {
        System.out.println(getFormattedAPIQuote());
        // System.out.println(getAuthorQuote());
    }

    // Local storage potent quotables
    public static String getLocalAuthorQuote() {
        Gson gsonDerulo = new Gson();
        int randomNumber = (int) (Math.random() * (138 + 1));
        String result = "";
        String jsonPath = "src/main/resources/recentquotes.json";
        try {
            Scanner scanner = new Scanner(new File(jsonPath));
            String firstLine = "";
            while (scanner.hasNext()) {
                firstLine += scanner.nextLine();
            }
            Quote[] quoteArray = gsonDerulo.fromJson(firstLine, Quote[].class);
            result = String.format("Local: %s by %s.", quoteArray[randomNumber].text, quoteArray[randomNumber].author);
            // System.out.println("Quotes: " + quoteArray[randomNumber].text);
            // System.out.println("Author: " + quoteArray[randomNumber].author);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Download all Star Wars Quotes for offline use
    public static String getAllStarWarsAPIInfo() throws IOException {

        URL url = new URL("http://swquotesapi.digitaljedi.dk/api/SWQuote/");
        HttpURLConnection swQuoteApi = (HttpURLConnection) url.openConnection();
        swQuoteApi.setRequestMethod("GET");

        BufferedReader input = new BufferedReader(new InputStreamReader(swQuoteApi.getInputStream()));

        return input.readLine();

    }

    public static String getQuoteFromStarWarsAPI() throws IOException {

        URL url = new URL("http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote");
        HttpURLConnection swQuoteApi = (HttpURLConnection) url.openConnection();
        swQuoteApi.setRequestMethod("GET");

        BufferedReader input = new BufferedReader(new InputStreamReader(swQuoteApi.getInputStream()));

        return input.readLine();

    }

    public static String getFormattedAPIQuote() {
        try {

            Gson gsonDerulo = new Gson();

            String result = "";
            StringBuilder internetQuoteBuilder = new StringBuilder();
            
            

            String firstLine = getQuoteFromStarWarsAPI();
//            String secondLine = firstLine + 1;

//            System.out.println("Pre while loop");

//            while (firstLine != null) {
            internetQuoteBuilder.append(firstLine);
//                firstLine = getQuoteFromStarWarsAPI();
//            }

//            System.out.println("Post while loop");
            
            

            Quote quoteArray = gsonDerulo.fromJson(String.valueOf(internetQuoteBuilder), Quote.class);

            System.out.println(quoteArray.id);
            System.out.println(quoteArray.starWarsQuote);
            System.out.println(quoteArray.author);

            Quote starWarsQuote = new Quote(quoteArray.id, quoteArray.starWarsQuote, quoteArray.author);

            String quoteString = "ID: " + quoteArray.id + ", Quote: " + quoteArray.starWarsQuote;

            //  File creation
            //  File starWarsFile = new File("src/main/resources/starwarsquotes.json");

            // Add additional quotes to JSON file
            FileWriter insertToJSON;
            // BufferedFileWriter appendToFile;
            insertToJSON = new FileWriter("src/main/resources/starwarsquotes.json");
            // appendToFile = new BufferedFileWriter("src/main/resources/starwarsquotes.json");
            gsonDerulo.toJson(starWarsQuote, insertToJSON);
            insertToJSON.close();

            result = "Online: " + quoteString;

            return result;

        } catch (IOException e) {
            System.out.println("catch triggered!");
            e.printStackTrace();
            String result = "I find your lack of functionality disturbing. -This code's author";
            return result;
        }
    }

//    public static String getAQuote() throws IOException {
//        if {
//            getQuoteFromInternet();
//        } else {
//            getAuthorQuote();
//        }
//        return result;
//    }

}

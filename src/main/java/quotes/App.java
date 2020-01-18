package quotes;


import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws IOException {
        System.out.println(getQuoteFromInternet());
        // System.out.println(getAuthorQuote());
    }

    // Local storage potent quotables
    public static String getAuthorQuote() {
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

    // The following code block was inspired by the class demo on 1/17/2020
    public static String getQuoteFromInternet() {
        try {
            Gson gsonDerulo = new Gson();
            String result = "";
            URL url = new URL("http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote");
            HttpURLConnection swQuoteApi = (HttpURLConnection) url.openConnection();
            swQuoteApi.setRequestMethod("GET");

            BufferedReader input = new BufferedReader(new InputStreamReader(swQuoteApi.getInputStream()));
            StringBuilder internetQuoteBuilder = new StringBuilder();

            String firstLine = input.readLine();
            String secondLine = firstLine + 1;

            while (firstLine != null) {
                internetQuoteBuilder.append(firstLine);
                firstLine = input.readLine();
            }

            Quote quoteArray = gsonDerulo.fromJson(String.valueOf(internetQuoteBuilder), Quote.class);
            String quoteString = "ID: " + quoteArray.id + ", Quote: " + quoteArray.starWarsQuote;

            //  File creation
            //  File starWarsFile = new File("src/main/resources/starwarsquotes.json");

            // Add additional quotes to JSON file
            FileWriter insertToJSON;
            // BufferedFileWriter appendToFile;
            insertToJSON = new FileWriter("src/main/resources/starwarsquotes.json");
            // appendToFile = new BufferedFileWriter("src/main/resources/starwarsquotes.json");
            gsonDerulo.toJson(quoteString, insertToJSON);
            insertToJSON.close();

            result = "Online: " + quoteArray.starWarsQuote;

            System.out.println(internetQuoteBuilder);
            System.out.println(input.readLine());

            return result;

        } catch (IOException e) {
            e.printStackTrace();
            String result = "Hi";
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

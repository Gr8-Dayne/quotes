package quotes;


import com.google.gson.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class App {

    public static void main(String[] args) {

        // For online:
        System.out.println(getFormattedAPIQuote());

        // For offline:
        System.out.println(getLocalAuthorQuote());

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
            System.out.println("Error at 'getLocalAuthorQuote' method");
            e.printStackTrace();
        }
        return result;
    }

    // Download all Star Wars Quotes for offline use - Stretch Goal
//    public static String getAllStarWarsAPIInfo() throws IOException {
//
//        URL url = new URL("http://swquotesapi.digitaljedi.dk/api/SWQuote/");
//        HttpURLConnection swQuoteApi = (HttpURLConnection) url.openConnection();
//        swQuoteApi.setRequestMethod("GET");
//        BufferedReader input = new BufferedReader(new InputStreamReader(swQuoteApi.getInputStream()));
//
//        return input.readLine();
//    }

    public static String getQuoteFromStarWarsAPI() throws IOException {

        URL url = new URL("http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote");
        HttpURLConnection swQuoteApi = (HttpURLConnection) url.openConnection();
        swQuoteApi.setRequestMethod("GET");

        BufferedReader input = new BufferedReader(new InputStreamReader(swQuoteApi.getInputStream()));

        return input.readLine();

    }

    // Local storage Star Wars Quote
//    public static String getLocalStarWarsQuote() throws FileNotFoundException {
//
//        Gson gsonDerulo = new Gson();
//
//        int randomNumber = (int) (Math.random() * (138 + 1));
//
//        int quoteID = 8;
//        String result = "";
//        Scanner quoteFinder = new Scanner(new File("src/main/resources/starwarsquotes.json"));
//        String firstLine = "";
//        String secondLine = "";
//
//        int searchedID = quoteFinder.nextInt();
//        String searchedQuote = quoteFinder.nextLine();
//
//        System.out.println("searchedID = " + searchedID);
//        System.out.println("searchedQuote = " + searchedQuote);
//
//        while (quoteFinder.hasNext()) {
//            firstLine += quoteFinder.toString();
//            secondLine += quoteFinder.toString();
//        }
//
//        System.out.println(firstLine);
//        System.out.println(secondLine);
//
//        Quote[] quoteArray = gsonDerulo.fromJson(firstLine, Quote[].class);
//        result = String.format("Local: ID: %s Quote: %s.", quoteArray[quoteID].id, quoteArray[quoteID].starWarsQuote);
//        // System.out.println("Quotes: " + quoteArray[randomNumber].text);
//        // System.out.println("Author: " + quoteArray[randomNumber].author);
//
//        return result;
//    }

    // Append additional quotes to JSON file
    // credit: https://mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/
    public static void appendJSONFile(String stringToAdd) {

        File starWarsFile = new File("src/main/resources/starwarsquotes.json");

        try (FileWriter insertToJSON = new FileWriter(starWarsFile, true)) {
            try (BufferedWriter appendToFile = new BufferedWriter(insertToJSON)) {

                appendToFile.append(stringToAdd);

            }
        } catch (IOException e) {
            System.out.println("Error at 'appendJSONFile' method");
            e.printStackTrace();
        }
    }

    public static String getFormattedAPIQuote() {
        try {

            Gson gsonDerulo = new Gson();

            String result = "";
            StringBuilder internetQuoteBuilder = new StringBuilder();

            String firstLine = getQuoteFromStarWarsAPI();

            internetQuoteBuilder.append(firstLine);

            Quote quoteArray = gsonDerulo.fromJson(String.valueOf(internetQuoteBuilder), Quote.class);

            Quote swQuote = new Quote(quoteArray.id, quoteArray.starWarsQuote, quoteArray.author);

            // Create String for JSON-append method
            // Credit: https://www.tutorialspoint.com/java/lang/stringbuilder_append_string.htm
            StringBuilder swString = new StringBuilder();
            swString.append("\nID: ");
            swString.append(swQuote.id);
            swString.append("\nQuote: ");
            swString.append(swQuote.starWarsQuote);
            swString.append("\n");
            String swStringReady = swString.toString();
            appendJSONFile(swStringReady);

            // Produce String
            String quoteString = "ID: " + quoteArray.id + ", Quote: " + quoteArray.starWarsQuote;
            result = "Online: " + quoteString;
            return result;

        } catch (IOException e) {
            String errorResult = "\nI find your lack of functionality disturbing. -This code's author\n";
            System.out.println("\ncatch triggered!\n\nBe advised: you are offline.");
            return errorResult;
        }

    }

}

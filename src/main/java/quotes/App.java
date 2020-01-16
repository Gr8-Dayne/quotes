package quotes;


import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        getRandomQuote();
    }

    public static void getRandomQuote() {

        Gson gson = new Gson();

        int randomNumber = (int)(Math.random()*(138 + 1 ));
        String jsonPath = "src/main/resources/recentquotes.json";

        try {
            Scanner scanner = new Scanner(new File(jsonPath));
            String firstLine ="";
            while(scanner.hasNext()) {
                firstLine += scanner.nextLine();
            }

            Quote[] quoteArray = gson.fromJson(firstLine, Quote[].class);

            System.out.println("Quotes: " + quoteArray[randomNumber].text);
            System.out.println("Author: " + quoteArray[randomNumber].author);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }
    }
}
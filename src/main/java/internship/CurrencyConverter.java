package internship;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static Map<String, Double> exchangeRates;

    static {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USDToEUR", 0.89);
        exchangeRates.put("USDToGBP", 0.77);
        exchangeRates.put("USDToJPY", 138.97);
        exchangeRates.put("USDToINR", 82.08);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");
        System.out.println("Available currencies: EUR, GBP, JPY, INR");

        System.out.print("Enter the amount in USD: ");
        double amountUSD = scanner.nextDouble();

        System.out.print("Enter the target currency (e.g., EUR, GBP, JPY, INR): ");
        String targetCurrency = scanner.next().toUpperCase();

        double convertedAmount = convertCurrency(amountUSD, targetCurrency);

        if (convertedAmount == -1) {
            System.out.println("Invalid currency selection!");
        } else {
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println(amountUSD + " USD is equal to " + df.format(convertedAmount) + " " + targetCurrency);
        }

        scanner.close();
    }

    public static double convertCurrency(double amountUSD, String targetCurrency) {
        double rate = exchangeRates.getOrDefault("USDTo" + targetCurrency, -1.0);
        if (rate == -1) {
            return -1;
        }
        return amountUSD * rate;
    }
}

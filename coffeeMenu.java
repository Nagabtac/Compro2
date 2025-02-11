


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class coffeeMenu {

    // globa arrays and constants to make them available in any method (class-wide)
    private static String[] CoffeeMenu = {"Espresso", "Latte", "Cappuccino", "Mocha"};
    private static double[] CoffeePrices = {50.0, 70.0, 65.0, 80.0};
    private static final double VAT_RATE = 0.12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] orderCount = new int[CoffeeMenu.length];
        String receipt = "\n---- Coffee Order Receipt ----\n";
        double total = 0.0;

        while (true) {
            displayMenu();

            System.out.print("Choose your coffee (1-" + CoffeeMenu.length + ", or 0 to finish): ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    break;
                }
                if (choice < 1 || choice > CoffeeMenu.length) {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }

                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine()); // This is better to avoid discarding next line character
                if (quantity < 1) {
                    System.out.println("Quantity must be at least 1. Please try again.");
                    continue;
                }

                orderCount[choice - 1] += quantity;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        //Summarize the order
        for(int i = 0; i < CoffeeMenu.length; i++) {
            if(orderCount[i] > 0) {
                double itemTotal = CoffeePrices[i] * orderCount[i];
                total += itemTotal;
                receipt += String.format("%d x %s @ %.2f each = %.2f\n", orderCount[i], CoffeeMenu[i], CoffeePrices[i], itemTotal);
            }
        }

        double vat = total * VAT_RATE;
        double grandTotal = total + vat;

        receipt += "---------------------------\n";
        receipt += String.format("Subtotal: %.2f\n", total);
        receipt += String.format("VAT (12%%): %.2f\n", vat);
        receipt += String.format("Grand Total: %.2f\n", grandTotal);
        receipt += "---------------------------\n";

        System.out.println(receipt);

        saveReceiptToFile(receipt);
        scanner.close();
    }

    /**
     * Method to display the coffee menu to the user.
     */
    private static void displayMenu() {
        System.out.println("\n--- Coffee Menu ---");
        for (int i = 0; i < CoffeeMenu.length; i++) {
            System.out.println((i + 1) + ". " + CoffeeMenu[i] + " - " + CoffeePrices[i] + " PHP");
        }
        System.out.println("0. Finish Order");
    }

    /**
     * Method to save the receipt to a file
      * @param receipt The receipt to save
     */
    private static void saveReceiptToFile(String receipt) {
        File saveDir = new File("target/receipts");
        if(!saveDir.exists()) {
            saveDir.mkdirs();
        }
        File receiptFile = new File(saveDir, "CoffeeReceipt.txt");
        try (FileWriter writer = new FileWriter(receiptFile)) {
            writer.write(receipt);
            System.out.println("\nReceipt saved to CoffeeReceipt.txt");
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}

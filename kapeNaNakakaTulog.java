import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class kapeNaNakakaTulog {
    public static final  String coffeeMenu = String.format("""
        ---Coffee Menu---
       1. Espresso        - 50.0 PHP
       2. Latte           - 70.0 PHP
       3. Cappuccino      - 65.0 PHP
       4. Mocha           - 80.0 PHP
       0. Finish Order
       """);
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] order = new int[5];
        double[] quantity = new double[5];
        double subtotal = 0;  
        double vat = 0;  
        double grandTotal = 0; 

        loop: for (int i = 0; i < 5; i++) { 
            System.out.print(coffeeMenu);

            System.out.print("Choose Your Coffee (1-4) or 0 to finish: ");
            order[i] = input.nextInt();
            

            if (order[i] > 4 || order[i] < 0) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            //int selectedItem = order[i];

            if (order[i] == 0) {
                break loop; 
            }

            System.out.print("Enter Quantity: ");
            quantity[i] = input.nextDouble(); 

            switch (order[i]) {
                case 1:
                    subtotal += 50 * quantity[i];  
                    break;
                case 2:
                    subtotal += 70 * quantity[i];
                    break;
                case 3:
                    subtotal += 65 * quantity[i]; 
                    break;
                case 4:
                    subtotal += 80 * quantity[i]; 
                    break;
            }
        }


        vat = subtotal * 0.12;  
        grandTotal = subtotal + vat;  

        String receipt = String.format("""
             ---------------------
             Subtotal: %.2f
             VAT (12%%): %.2f
             Grand Total: %.2f
             ---------------------
        """, subtotal, vat, grandTotal);


        System.out.println(receipt);

        try (FileWriter writer = new FileWriter("CoffeeReceipt.txt")) {
            writer.write("how to print coffeeMenu");
            writer.write(receipt);
            writer.write("\nThis is a file writing example.");
            System.out.println("Data successfully written to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
        //use 2d array?!?


        input.close();
    }
    
}

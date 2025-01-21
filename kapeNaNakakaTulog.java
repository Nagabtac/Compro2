import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class kapeNaNakakaTulog {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        int i;
        loop: for( i = 0; i <=5; i++){
            String coffeeMenu = String.format("""
             ---Coffee Menu---
        1. Espresso        - 50.0 PHP
        2. Latte           - 70.0 PHP
        3. Cappuccino      - 65.0 PHP
        4. Mocha           - 80.0 PHP
        0. Finish Order
       
        """);
            System.out.print( "Choose Your Coffee (1-4) or 0 to finish): ");
            double order = input.nextDouble();
            if(order > 4 || order < 0){
                System.out.println("invalid choice. please try again");
                i--;
            }


            System.out.println("Enter Quantity: ");
            double quantity = input.nextDouble();
            
            switch (order){
                case 1:
                    break;
                    
                case 2:
                    break;
                    
                case 3:
                    break;
                    
                case 4:
                    break;
                    
                case 0:
                    break loop;
            }

        }
    /*String result = String.format("""

        """, );*/


    }
}

import java.util.Scanner;

public class coffeOrder {
    private static String[] CoffeeMenu = {"Espresso", "Latte"};
    public static String[] CoffeeType ={"Arabica","Robusta"};
    private static double[] CoffeePrices = {50.0, 70.0, 65.0, 80.0};
    private static String[] CoffeeSizes = {"Small","Medium","Large"};
    private static final double VAT_RATE = 0.12;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String order;

        order=getOrder("please order.(begging face)");
       

    }
    public static String getOrder(String order){
        return order;
    }
    
}

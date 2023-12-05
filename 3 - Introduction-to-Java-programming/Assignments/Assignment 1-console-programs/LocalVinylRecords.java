import java.util.Scanner;
import java.text.DecimalFormat; //https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/

public class LocalVinylRecords {
    public static Scanner scanner = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void main (String []args) {
        double tax = .14;
        System.out.println("Hipster's Local Vinyl records - Customer Order Details");
        System.out.println(" ");
        System.out.print("Enter the customer's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the distance in kilometers for delivery: ");
        double distance = scanner.nextDouble();
        System.out.print("Enter the cost of records purchased: ");
        double purchase = scanner.nextDouble();
        double travelCost = km_calculator(distance);
        double plusTax = tax_calculator(purchase, tax);
        double VinylCost = Vinyl_calculator(purchase, plusTax);
        double Total = Total(VinylCost, travelCost);
        System.out.println(" ");
        System.out.println("Purchase summary for " + name
        + "\nDelivery cost: $" +  df.format(travelCost)
        + "\nPurchase Cost: $" + df.format(VinylCost)
        + "\nTotal Cost: $" +  df.format(Total));
    }

        public static double km_calculator(double distance) {
            double travelCost = distance * 15;
            return travelCost;
        }
    
        public static double tax_calculator(double purchase, double tax) {
            double plusTax = purchase * tax;
            return plusTax;  
        }
        public static double Vinyl_calculator(double purchase, double plusTax){
            double Vinyltotal = purchase + plusTax;
            return Vinyltotal;
        }
        public static double Total(double VinylCost, double travelCost) {
            double total = VinylCost + travelCost;
            return total;
        }

}

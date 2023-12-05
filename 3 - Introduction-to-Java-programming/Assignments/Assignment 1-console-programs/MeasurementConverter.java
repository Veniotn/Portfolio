import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class MeasurementConverter {
    public static Scanner scanner = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("#");

    public static void main(String []args) {
        System.out.println("Imperial To Metric Conversion");
        System.out.println(" ");
        System.out.print("Enter the number of Tons: ");
        double tons = scanner.nextDouble();
        System.out.print("Enter the number of stone: " );
        double stone = scanner.nextDouble();
        System.out.print("Enter the number of pounds: ");
        double pounds = scanner.nextDouble();
        System.out.print("Enter the number of ounces: ");
        double ounces = scanner.nextDouble();
        double T1 = tonsConverter(tons);
        double T2 = stoneConverter(stone);
        double T3 = poundConverter(pounds);
        double sum1 = equation1(T1, T2, T3);
        double TotalOunces = TotalOunces(ounces, sum1);
        double TotalKilos = TotalKilos(TotalOunces);
        double MetricTons = MetricTons(TotalKilos);
        double totalKilosRounded = Math.round(TotalKilos);
        double totalGrams = totalGrams(TotalKilos, totalKilosRounded);
        double metricTonsRounded = Math.round(MetricTons);
        double totalKilos2 = MetricTons - metricTonsRounded;
        double totalKilosRounded2 = Math.round(totalKilos2 *10000)/10;
        double totalGramsRounded = Math.round(totalGrams *10000)/10.00;
        System.out.println(" ");
        System.out.printf("The metric weight is " +   df.format(metricTonsRounded) + " metric tons, " + df.format(totalKilosRounded2) + " kilos, and " + totalGramsRounded + " grams.");   
    }

    /*since starting i now realize that i dont need all of these functions and can just do most of what i want in the main section, figured i should finish the assignment in this same way but change going forward.
    also my camelCasing is not consistent but plan on fixing that for the future as well.*/
    
    public static double tonsConverter(double tons) {
        double result = 35840 * tons;
        return result;
    }

    public static double stoneConverter(double stone) {
        double result = 224 * stone;
        return result;
    }

    public static double poundConverter(double pounds){
        double result = 16 * pounds;
        return result;
    }

    public static double equation1(double T1, double T2,double T3){    //Takes all of the converted totals and adds together to be added to ounces
        double result = T1 + T2 + T3;
        return result;
    }
    
    public static double TotalOunces (double ounces, double sum1){
        double result = sum1 + ounces;
        return result; 
    }

    public static double TotalKilos(double TotalOunces) {
        double result = TotalOunces / 35.274;
        return result;
    }

    public static double MetricTons(double TotalKilos){
        double result = TotalKilos / 1000;
        return result;
    }

    public static double totalGrams(double TotalKilos, double totalKilosRounded){
        double result = TotalKilos - totalKilosRounded;
        return result;
    } 
}
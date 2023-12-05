import java.util.Scanner;
import java.text.DecimalFormat;

public class LoanCalculator {
    public static Scanner scanner = new Scanner(System.in);
    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String []args) {
        System.out.println("Weekly Loan Calculator");
        System.out.println("  ");
        System.out.print("Enter the amount of loan: ");
        double loanAmount = scanner.nextDouble();
        System.out.print("enter interest rate (%): ");
        double interestRate = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        double length = scanner.nextDouble();
        System.out.println(" ");
        double i = i(interestRate);
        double bracket = bracket(i);
        double power = power(length);
        double p1 = exponents(bracket, power); //second half of the denominator equation//
        double denominator = denominator(p1);
        double fraction = fraction(i, denominator);
        double result = equation(fraction, loanAmount);
        System.out.println("Your weekly payment will be:  $" + df.format(result));


    }

    public static double i (double interestRate){
        double result = interestRate / 5200;
        return result;
    }

    public static double bracket(double i) {
        double result = 1 + i; 
        return result;
    }

    public static double power(double length){
        double result = -52 * length;
        return result;
    }

    public static double exponents(double bracket, double power){
        double result = Math.pow(bracket, power);
        return result;

    }
    public static double denominator(double p1) {
        double result = 1 - p1;
        return result;
    }

    public static double fraction(double i, double denominator){
        double result = i / denominator;
        return result;
    }
    public static double equation(double fraction, double loanAmount){
        double result = fraction * loanAmount;
        return result;
    }


}
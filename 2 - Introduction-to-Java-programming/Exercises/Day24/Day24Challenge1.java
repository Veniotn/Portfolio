import java.util.Scanner;

public class Day24Challenge1{

    public static Scanner scan = new Scanner(System.in);

    public static void main(String []args){
        System.out.println("Welcome to day25, enter your double!");
        double runningAmount = scan.nextDouble();
        double dimeCalc = runningAmount / .10;
        double nickelCalc = runningAmount / .05;
        System.out.println(dimeCalc + "dimes " + nickelCalc + " nickles");
    }
}
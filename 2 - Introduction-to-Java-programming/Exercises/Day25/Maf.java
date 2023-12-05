import java.util.Scanner;

public class Maf {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] operations = {"add", "subtract", "multiply", "divide"};
        System.out.print("\nYour options are: add, subtract, multiply, divide");
        System.out.print("\ntype in yor operation: ");
        String choice = scan.nextLine();

        System.out.print("please add your first operands: ");
        double opOne = scan.nextDouble();

        System.out.print("please add your second operands: ");
        double opTwo = scan.nextDouble();

        if (choice.equalsIgnoreCase("Add")) {
            double ans = opOne + opTwo;
            System.out.print("your answer is: " + ans);
        } else if (choice.equalsIgnoreCase("Substract")) {
            double ans = opOne - opTwo;
            System.out.print("your answer is: " + ans);
        } else if (choice.equalsIgnoreCase("Multiply")) {
            double ans = opOne * opTwo;
            System.out.print("your answer is: " + ans);
        } else if (choice.equalsIgnoreCase("Divide")) {
            double ans = opOne / opTwo;
            System.out.print("your answer is: " + ans);
        } else {
            System.out.print("please come back once you figure out what you want");
        }
    }
}
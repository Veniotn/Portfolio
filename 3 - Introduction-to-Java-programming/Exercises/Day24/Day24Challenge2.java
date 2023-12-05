import java.util.Scanner;
public class Day24Challenge2{
    public static Scanner scan = new Scanner(System.in);

    public static void main(String []args){
        System.out.print("What would you like to do? [add] [substract] [multiply] [divide] [exit]");

        while(true){
            String input = scan.nextString();
            if(input == "add"){
                addition();
            }
            if(input == "subtract"){
                subtraction();
            }
            if(input == "multiply"){
                multiplication();
            }
            if(input == "divide"){
                division();
            }
            if(input == "exit"){
                break;
            }
            else{
                System.out.print("incorrect input try again.");
            }
        }
    }

    public static double addition(double input){
        System.out.println("test");
    }

    public static double subtraction(double input){
        System.out.println("test");
    }

    public static double multiplication(double input){
        System.out.println("test");
    }

    public static double division(double input){
        System.out.println("test");
    }
}
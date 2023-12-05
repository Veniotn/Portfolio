import java.util.Scanner;

public class NickelsDimes {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        float input = scan.nextFloat();

        float nickel = (float)0.05;
        float dime = (float)0.10;

        float numNick = input/nickel;
        float dimeCon = numNick*(float)0.67;
        float con = dimeCon/2;

        System.out.println(con);
        System.out.println("num of nickels" + numNick);
        System.out.println("nickles left" + (numNick-dimeCon));
        System.out.println("num of dimes" + dimeCon);
    }
}
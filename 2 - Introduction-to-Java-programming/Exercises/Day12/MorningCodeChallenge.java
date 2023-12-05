import java.util.Scanner;

public class MorningCodeChallenge{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        
		System.out.println("Enter a 6 digit integer: ");
        int initialInt = input.nextInt();
        
		int ones = 0;
        int tens = 0;
        int hundreds = 0;
        int thousands = 0;
        int tenthousands = 0;
        
		int hundredthousands = 0;
        ones = (initialInt/1) % 10;
        tens = (initialInt/10) % 10;
        hundreds = (initialInt/100) % 10;
        thousands = (initialInt/1000) % 10;
        tenthousands = (initialInt / 10000) % 10;
        hundredthousands = (initialInt / 100000) %10;
        
		System.out.println("In the ones place is "+ones);
        System.out.println("In the tens place is "+tens);
        System.out.println("In the hundreds place is "+hundreds);
        System.out.println("In the thousands place is "+thousands);
        System.out.println("In the ten thousands place is "+tenthousands);
        System.out.println("In the hundred thousands place is "+hundredthousands);
        System.out.println("The initial integer was " +initialInt);
    }
}
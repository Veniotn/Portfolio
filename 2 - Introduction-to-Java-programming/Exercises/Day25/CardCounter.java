import java.util.Scanner;

public class CardCounter {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("these are your options: [A]subtract by one [D]add one [S] print the count [X]reset the count [W]do nothing");
        
        int card = 0;
        boolean quit = false;

        while (!quit) {
            String input = scan.nextLine();

            if (input.equalsIgnoreCase("A")) {
                card--;
            } else if (input.equalsIgnoreCase("D")) {
                card++;
            } else if (input.equalsIgnoreCase("S")) {
                System.out.println(card);
            } else if (input.equalsIgnoreCase("X")) {
                card = 0;
            } else if (input.equalsIgnoreCase("W")) {
                //nothing happens
            } else {
                break; //or set boolean to true
            }
        }
    }
}
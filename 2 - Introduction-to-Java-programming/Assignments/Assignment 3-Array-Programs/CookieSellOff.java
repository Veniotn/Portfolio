import java.util.Scanner;
import java.util.Arrays;
//ready for marking
public class CookieSellOff{
    public static Scanner scan = new Scanner(System.in);

    public static void main(String []args){
        System.out.println("");
        System.out.print("Enter the number of participants in the cookie sale: "); //setting the length of array that will store the names of participants/amount of boxes
        int length = scan.nextInt();
        System.out.println(" ");
        String[] names = new String[length];
        int[] boxes = new int[length];
        for(int i=0; i<length; i++){
            System.out.print("Enter the name of participant #" + (i+1) + ": ");
            names[i] = scan.next();
            System.out.println(" ");
            System.out.print("Enter the number of boxes of cookies sold by " + names[i] + ": ");
            boxes[i] = scan.nextInt();
            System.out.println(" "); 
        }
        for(int i=0; i<boxes.length; i++){
            for(int j=i; j<boxes.length; j++){
                if(boxes[i] > boxes[j]){
                    int temp = boxes[i];
                    boxes[i] = boxes[j];
                    boxes[j] = temp;
                    int temp2 = boxes[i];
                    boxes[i] = boxes[j];
                    boxes[j] = temp2;
                }
            }
        }
        double totalBoxes = sum(boxes);
        double average = totalBoxes / length;
        
        System.out.println("The average number of boxes sold was: " + average);
        System.out.println(" ");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Participant                      Prize won                                 |");
        System.out.println("----------------------------------------------------------------------------");
        for(int i =0; i<boxes.length; i++){
            if(i==0){
                System.out.println(names[i] + " " +  "                         - Trip to Yarmouth!");
            }
            else if(boxes[i] == 0){
                System.out.println(names[i] + " " +  "                            - ");
            }
            else if(boxes[i] >= average){
                System.out.println(names[i] + " " +  "                            - Super seller!");
            }
            else{
                System.out.println(names[i] + " " +  "                            - Leftover cookies");
            }
        }



    }

    public static double sum(int[] boxes){
        double sum = 0;
        int i;
        for(i=0; i<boxes.length; i++){
            sum += boxes[i];
        }
        return sum;
    }
}
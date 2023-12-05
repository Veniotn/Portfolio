import java.util.Arrays;  //https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html
import java.util.Scanner; //https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html

public class arraySorter{
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Enter your favorite numbers! ");
        String numbers = scan.nextLine();
        String[] numbersToSort = numbers.split(" "); /* https://stackoverflow.com/questions/23506429/how-to-read-multiple-integer-values-from-a-single-line-of-input-in-java */
    
        int[] stringToInt = new int[numbersToSort.length];
        for(int i=0; i<stringToInt.length; i++){
            stringToInt[i] = Integer.parseInt(numbersToSort[i]);   
        }

        for(int i=0; i<stringToInt.length; i++){
            for(int j=i; j<stringToInt.length; j++){
                if(stringToInt[i] > stringToInt[j]){
                    int temp = stringToInt[i];
                    stringToInt[i] = stringToInt[j];
                    stringToInt[j] = temp;
                }
            }
        }
        String arrayToPrint = "";
        for(int i=0; i<stringToInt.length; i++){
            arrayToPrint += stringToInt[i];
            arrayToPrint += " ";
        }

        System.out.println("Your sorted array: " + arrayToPrint);

        
    }
}
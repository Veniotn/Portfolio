import java.lang.Math;
import java.util.Scanner;

public class WhileLoopExample2 {
    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        int v1 = 0; 
        while (v1 != 5) {
            System.out.println("Give and input bw 1-10: ");
            v1 = input.nextInt();
        }
    }
}
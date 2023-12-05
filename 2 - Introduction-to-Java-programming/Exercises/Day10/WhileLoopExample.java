import java.lang.Math;
import java.util.Scanner;

public class WhileLoopExample {
    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        int v1 = 0; 
        while (v1 != 5) {
            System.out.println("v1 =" + v1++);
        }
    }
}
import java.util.Scanner;


public class ExploringForLoops {
    public static Scanner scan = new Scanner(System.in);
public static void main(String []args) {
    
    int iteration = 0;
    String input = "";

for(int i=3; i>0; i--) {
System.out.println("Hello #" + i);
iteration = i;
System.out.println("Enter word #" + i + ": ");
input += scan.nextLine() + " " ;
    
}
    System.out.println(iteration);
    System.out.println(input);
    }
}



// What happens if we want to fill up some variables?
// Can we respond to input inline?
// How can we manipulate the counter?
// Can we go backwards?
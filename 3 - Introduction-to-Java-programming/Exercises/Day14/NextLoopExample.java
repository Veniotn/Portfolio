import java.util.Scanner;

public class NextLoopExample {
	public static void main(String []args) {
		// Code snippet using scanner
		Scanner terminal = new Scanner(System.in);
		
		// What happens if I call this and pass a String?
		//float f = terminal.nextFloat();

		// How does this fix it.
		while(!terminal.hasNextFloat()) {
			System.out.print("Give me a float:");
			terminal.next();
		}
		float f = terminal.nextFloat();
		System.out.print("Float is: " + f);
		//f = terminal.nextFloat();
	}
}

import java.util.Scanner;

public class IffyTheGame {
	public static void main(String []args) {
		// Setup to read terminal input
		Scanner scanner = new Scanner(System.in);
		
		// Get the users name, then we can use it...
		System.out.print("Welcome to Iffy's Adventure. We welcome all adventurers. What is your name? ");
		String name = scanner.nextLine();
		
		//This is the two steps to prompt that will let you read input:
		System.out.print("Hello " + name + " There are three paths you can choose, which will you take: [1, 2, or 3]: ");
		int answer = scanner.nextInt(); // Only accepting an int
		
		if (answer == 1) {
			System.out.println("Welcome to the Jungle " + name + " - we've got fun and games!");
			
			System.out.print("What game would you like to play; we have Monopoly[1], Catan[2], and Wingspan[3]? ");
			answer = scanner.nextInt(); // the answer variable will now be overwritten with the new selection
			
			// Now we have some secondary logic
			if (answer == 1) {
				System.out.println("Monopoly");
			} else if (answer == 2) {
				System.out.println("Catan");
			} else if (answer == 3) {
				System.out.println("Wingspan");
			} else {
				System.out.println("Could I just use else instead of checking for option 3?");
			}
			
		} else if (answer == 2) {
			System.out.println("Welcome to New York; It's been waitin' for you");
			// New york mission
		} else if (answer == 3) {
			System.out.println("Welcome my sun, Welcome to the machine.");
			// What is going to happen to that star?
		} else {
			System.out.println("Don't be a jerk - pick one of the options we gave you!");
			// Or secret mission...?
		}
	}
}

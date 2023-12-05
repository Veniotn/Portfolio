import java.util.Scanner;

public class UserInput {
	public static void main(String []args) {
		Scanner scanner1 = new Scanner(System.in);

		
		System.out.println("bababooey? Enter integer");
		int i = scanner1.nextInt();
		for(int j = 0; j < i; j++){
			System.out.println("bababooey");
		}
	}
}

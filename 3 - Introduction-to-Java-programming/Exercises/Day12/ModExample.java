import java.util.Scanner;

public class ModExample {
	public static void main(String []args) {
		Scanner scan = new Scanner(System.in);
	
		System.out.println("Enter a 6 digit number");
		int initial = scan.nextInt();
	
		int input = 0; 
		int onesPlace = input%10;
	
		input = input/10;
		int tensPlace = input%10;
	
		input = input/10;
		int hundredsPlace = input%10;
	
		input = input/10;
		int thouPlace = input%10;
	
		input = input/10;
		int tenThouPlace = input%10;
	
		input = input/10;
		int hundThouPlace = input%10;

	}
}
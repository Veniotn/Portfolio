public class IfExamples {
	public static void main(String[] args) {
		int x = 2;
		// Version one: Matthew's favorite Java if statement
		if (1==1) {
			System.out.println("V1 Works");
		}
		
		//Version two: Let's hang out in C#
		if (1==1) 
		{
			System.out.println("V2 Works");
		}
		
		//Version three: I never do this, but I see the appeal
		if (1==1) {System.out.println("V3 Works");}
		
		//Version four: I hate this so much, but it is allowed:
		if (1==1) System.out.println("V4 Works");
		
		// This was invented by practicioners of dark magic
		if (x==1) 
			System.out.println("V5 Works");
			System.out.println("V5 Works 2");
		
	}
}
		
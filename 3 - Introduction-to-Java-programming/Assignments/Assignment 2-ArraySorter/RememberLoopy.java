public class RememberLoopy {
	public static void main (String[] args) {
		/**
		* In this program swap for loops for while loops 
		* if constructs for case statements and the reverse.
		* 
		* Aside: I was looking for a repetitive song for this 
		* assignment, and choose this 90's elctronica hit.
		* In looking up the lyrics it saw the sample was by 
		* Marlena Shaw who is excellent.
		*
		**/
		System.out.println("Blue Boy - Remember Me\n\n");

		/* original loop
		boolean done = false;
		int counter = 0;
		while (!done) {
			int chorusOrVerse = counter%2;
			switch (chorusOrVerse) {
				case 0:
					verse();
					break;
				case 1:
					chorus();
					break;
			}
			counter = counter + 1;
			
			switch (counter) {
				case 7:
					done = true;
					break;
				default:
					System.out.println("");	
			}
			counter = counter + 1;
		}
		*/
		boolean done = false;
		for(int counter = 0; !done; counter++){
			int chorusOrVerse = counter%2;
			system.out.print(chorusOrVerse);
			if(chorusOrVerse == 0){
				verse();
			}
			else if(chorusOrVerse == 1){
				chorus();
			}
			if(counter == 7){
				done = true;
			}
			else{
				System.out.println("");
			}
		}
		
	}	
	/*original loop
	public static void verse() {
		for (int i=0; i<8; i++) {
			if (i%2 == 0) {
				System.out.println("  Remember me?");
			} else {
				System.out.println("\tI'm the one who had your babies, I."); 
			}
		}
	}
	*/
	public static void verse(){
		int i = 0;
		while(i<8){
			switch(i % 2){
				case 0:
				System.out.println(" Remember me?");
				break;
			default:
				System.out.println("\tI'm the one who had your babies, I.");
				break;
			}
			i = i + 1;
		}
}
	/*
	public static void chorus() {
		// This is not accurate... but works for our purposes:
		for (int i=0; i<4; i++) {
			for (int j=0; j<3; j++) {
				if (j==0) {
					System.out.print("  Dingdiggidiggiding,");
				} else if (j==1) {
					System.out.print(" dingdingding,");
				} else {
					System.out.println(" diggiding");
				}
			}
		}
	}
	*/

	public static void chorus(){
		int i = 0;
		while(i<4){
			int j = 0;
			while(j<3){
				switch(j){
				case 0:
					System.out.print(" Dingdiggidiggiding,");
					break;
				case 1:
					System.out.print(" dingdingding,");
					break;
				default:
					System.out.println(" diggiding");
					break;
				}
				j = j + 1;
			}
			i = i + 1;
		}
	}
}
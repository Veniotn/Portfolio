public class ScopeExamples {   
    /* 
	* There are some interesting properties we can set on 
	* class variables, including protected, private, and public.
	* The default is available everywhere in the class.
	*/
	int classVariable = 1; 
	
	
	public static void main(String []args){
		// The below will be available everywhere in this method
		int varAvailableEverywhereInMethod = 2;
		
		if (varAvailableEverywhereInMethod == 2) {
			//Following will only be available in the if block
			int availableInIfBlock = 3;
		} else {
			// availableInIfBlock is no longer in scope
			int availableInElseBlock = 4;
		}
		
		for (int i=0; i<3; i++) {
			// the index i defined in the for loop is available in the loop
			for (int j=0; j<3; j++) {
				// Here I define j as i is already in scope - I need a new variables
			}
			// j is no longer available
		}
		// i is no longer available
		
		//Note - I could now reuse i!
		for (int i=0; i<5; i++) {
			// and j, which does not even need to match type
			String j = "See!";
		}
	}
}	
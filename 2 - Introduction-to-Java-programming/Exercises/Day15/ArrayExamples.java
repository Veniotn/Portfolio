public class ArrayExamples {
	public static void main(String[] args) {
		
		int[] myArray = new int[10]; // why the new keyword for a primitive?
		
		for (int i=0; i<myArray.length; i++) {
			myArray[i] = i*5;
		}
		
		for (int i=0; i<myArray.length; i++) {
			System.out.println("The value at position " + i + " is " + myArray[i]);
		}
		
		double d = 1.1;
		float f =  d;
		System.out.println(f);
		
	}
}

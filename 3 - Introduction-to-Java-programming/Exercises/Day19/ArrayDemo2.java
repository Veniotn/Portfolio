import java.util.Arrays;

class ArrayDemo2 {

    public static int multiplyValues(int a, int b){
        return a*b;
    }
    public static void main(String[] args) {
        // There are so many (like three at least) ways to initialize arrays - this is one:
		// {} can be used to enclose comma-sperated entries into the list.
        String[] anArray = new String[] {"PROG1700", "Really", "Whips", "The", "Llama's"};

        Double anArray2 = new Double (4.5, 4.7, 6.4);

        Int anArray3 = new Int(4,7,1,3,8);
						
		//Printing arrays is annoying - as you have discovered. 
		System.out.println(anArray2);
		
		// When you get to OOP and learn about how we override these methods you will learn that:
		// 1. When we call print on an object the .toString() methods is invoked.
		// 2. You generally will override this method.
		// 3. When you don't it invokes the default behaviour: <Classname>@<HashCode>
		
		// What is that DRY concept I keep talking about?
		System.out.println(Arrays.toString(anArray));
        
	}
}
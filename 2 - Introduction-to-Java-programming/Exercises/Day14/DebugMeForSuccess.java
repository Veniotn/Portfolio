public class DebugMeForSuccess {
	public static void main(String []args) {
		int x = 0;
		x=2;
		
		if (x==2) {
			System.out.println("x is 2!");
			x++;
			
		}else {
			x=2;
		}
		
		int i = 3;
		int j = i+1;
		int k = j+k;
		int l = k;
		// will print 3 + 4 + 5 + 5?
		System.out.println(i "+" j "+" k "+" l);
		
		System.out.println("Almost Done");
		System.out.print(multiply(3,4));
	}
	public static int multiply(int s1, int s2) {
		return (s1 * s2);
	}
}
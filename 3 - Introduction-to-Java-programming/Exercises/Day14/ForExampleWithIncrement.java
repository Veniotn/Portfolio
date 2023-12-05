public class ForExampleWithIncrement {
	public static void main(String []args) {
	
		for (int i=0; i<5; i++) {
			System.out.println(i);
		}
		
		for (int i=0; i<5; ++i) {
			System.out.println(i);
		}
		
		int i=1;
		int j=i++;
		System.out.println(i + " " + j);
		i=1;
		j=++i;
		System.out.println(i + " " + j);
	}
}
		
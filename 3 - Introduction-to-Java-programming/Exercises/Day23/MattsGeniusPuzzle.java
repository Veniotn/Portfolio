import java.text.DecimalFormat;

public class MattsGeniusPuzzle {
	public static void main (String[] args) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
		
		//Defining first to see if there is a cost savings
		long endTime;
		long duration;
		long startTime;
		
		noShortCuts(); // I was seeing serious overhead for the first method call, cannot reproduce. Discuss in class.
		// Lets run each 100 times to get an average.
		startTime = System.nanoTime();
		for (int i=0; i<100; i++) {
			noShortCuts();
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime);  
		System.out.println("NoShortCuts took " + decimalFormat.format(duration) + "ns");
		
		nothinFancy();
		startTime = System.nanoTime();
		for (int i=0; i<100; i++) {
			nothinFancy();
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime);  
		System.out.println("NothinFancy took " + decimalFormat.format(duration) + "ns");
		
		doesOrderMatter();
		startTime = System.nanoTime();
		for (int i=0; i<100; i++) {
			doesOrderMatter();
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime);  
		System.out.println("DoesOrderMatter took " + decimalFormat.format(duration) + "ns");
		
		canWeOptmize();
		startTime = System.nanoTime();
		for (int i=0; i<100; i++) {
			canWeOptmize();
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime);  
		System.out.println("CanWeOptmize took " + decimalFormat.format(duration) + "ns");
	}
	
	public static int nothinFancy() {
		// Stright up check everything every time.
		for (int abcde=10000; abcde<99999; abcde++) {
			int e = abcde%10;
			int d = (abcde/10)%10;
			int c = (abcde/100)%10;
			int b = (abcde/1000)%10;
			int a = abcde/10000;
			if (a!=b && a!=c && a!=d && a!=e && b!=c && b!=d && b!=e &&c!=d && c!=e && d!=e && (abcde*a==e*111111)) {
				//System.out.println(abcde + " x " + a + " = " + e*111111);
				return 1;
			}
		}
		return 0;
	}
	
	public static int doesOrderMatter() {
		// Allow the abcde*a check first as it excludes most other checking... could add up to savings.
		for (int abcde=10000; abcde<99999; abcde++) {
			int e = abcde%10;
			int d = (abcde/10)%10;
			int c = (abcde/100)%10;
			int b = (abcde/1000)%10;
			int a = abcde/10000;
			if ((abcde*a==e*111111) && a!=b && a!=c && a!=d && a!=e && b!=c && b!=d && b!=e &&c!=d && c!=e && d!=e) {
				//System.out.println(abcde + " x " + a + " = " + e*111111);
				return 1;
			}
		}
		return 0;
	}
	
	public static int noShortCuts() {
		// Example with only using & (no shortcuts)
		for (int abcde=10000; abcde<99999; abcde++) {
			int e = abcde%10;
			int d = (abcde/10)%10;
			int c = (abcde/100)%10;
			int b = (abcde/1000)%10;
			int a = abcde/10000;
			if (a!=b & a!=c & a!=d & a!=e & b!=c & b!=d & b!=e & c!=d & c!=e & d!=e & (abcde*a==e*111111)) {
				//System.out.println(abcde + " x " + a + " = " + e*111111);
				return 1;
			}
		}
		return 0;
	}
	
	public static int canWeOptmize() {
		// Can we get slightly better performance by only calculating a and e initially?
		for (int abcde=10000; abcde<98765; abcde++) {
			int e = abcde%10;
			int a = abcde/10000;
			if (abcde*a == e*111111) {
				int d = (abcde/10)%10;
				int c = (abcde/100)%10;
				int b = (abcde/1000)%10;
				if (a!=b && a!=c && a!=d && a!=e && b!=c && b!=d && b!=e &&c!=d && c!=e && d!=e) {
					//System.out.println(abcde + " x " + a + " = " + e*111111);
					return 1;
				}
			}
		}
		return 0;
	}
}
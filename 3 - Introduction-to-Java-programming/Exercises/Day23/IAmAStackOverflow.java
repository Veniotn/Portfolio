public class IAmAStackOverflow {
	public static void main (String[] args) {
		long x = Long.MAX_VALUE;
		doSomething(x);
	}
	
	public static void doSomething(long x) {
		doSomething(x);
	}
}
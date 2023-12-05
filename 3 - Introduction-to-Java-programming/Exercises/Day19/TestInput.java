public class TestInput {
	public static void main (String[] args) {
		boolean isHelpFlag = false;
		
		for(String s : args) {
			if(s.charAt(0) == '-') {
				System.out.println("Test");
			}
			if(s.equals("-help")) {
				isHelpFlag=true;
			}
			
			System.out.println(s);
			
			
		}
		System.out.println(isHelpFlag);
	}
}
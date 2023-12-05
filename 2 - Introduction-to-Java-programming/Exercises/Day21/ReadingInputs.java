public class ReadingInputs {
	public static void main (String[] args) {
		boolean encrypt = false;
		boolean decrypt = false;
		int secretNumber = 13;
		
		if (args.length < 2 || args.length > 6) {
			System.out.println("Too many or too few arguments");
			System.exit(0);
		}
		
		if (!(args[0].equalsIgnoreCase("encrypt") 
					|| args[0].equalsIgnoreCase("decrypt"))) {
			System.out.println("Encrypt or Decrypt not selected");
			System.exit(0);
		} else if (args[0].equals("encrypt")) {
			encrypt = true;
			
		} else {
			decrypt = true;
		}
		
		secretNumber = parseSecretNumber(args);
		System.out.println("Secret number is: " + secretNumber);
		
		int minWordLength = parseMinWordLength(args);
		System.out.println("Min word length is: " + minWordLength);
	}
	
	public static int parseSecretNumber(String[] args) {
		int secretNumber = parseNumber(args, "-secretNumber");
		if (secretNumber == 0) {
			System.out.println("No secret number provided or 0 provided, setting to 13");
			secretNumber = 13;
		}
		secretNumber = secretNumber % 26;
		if (secretNumber == 0) {
			System.out.println("-secretNumber resulted in no encryption");
			System.exit(0);
		}
		return secretNumber;
	}
	
	public static int parseMinWordLength(String[] args) {
		int minWordLength = parseNumber(args, "-minWordLength");
		
		if (minWordLength < 0) {
			System.out.println("-minWordLength must be greater than zero");
			System.exit(0);
		}
		
		return minWordLength;		
	}
		
	
	public static int parseNumber(String[] args, String toCheck) {
		int result = 0;// the number to return if not found, but valid
		for (int i=0; i<args.length; i++) {
			if (args[i].equalsIgnoreCase(toCheck)) { 
				if (args.length > (i+1) && isInt(args[i+1])) {
					result = Integer.parseInt(args[i+1]);
				} else {
					System.out.println("Found "+ toCheck +" but no Integer");
					System.exit(0);
				}
			} 
		}
		return result;
	}
	
	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
}
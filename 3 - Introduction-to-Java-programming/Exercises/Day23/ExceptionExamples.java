public class ExceptionExamples {
	public static void main (String[] args) {
		int year = 1970;
		try {
			String s = getTheBestSongEver(year);
			System.out.println("The best song ever is: " + s);
		} catch (SongDoesNotExistException e) {
			System.out.println("An Exception was thrown: " + e.getMessage());
			
		} finally {
			// Can use this to do important things if there is an 
			// Exception or not...
			System.out.println("Finally");
		}
	}
	
	public static String getTheBestSongEver(int year) throws SongDoesNotExistException {
		if (year >= 1967) {
			return "All Along The Watchtower"; 
			// Does One Direction get an honourable mention?
		} else {
			throw new SongDoesNotExistException("There is no best song ever");
		}
	}
}

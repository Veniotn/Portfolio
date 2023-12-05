public class Recursion{

    public static void main(String[] args){
        int number = 5;
        int result = 1;
		/*for(int i=number; i>=1; i--){
			result = result*i;		
		}
		*/
		int result2 = runItBack(number);
		System.out.print("your numbers are: " + result2);
    }
	
	public static int runItBack(int number){
		if(number !=1){
			return number*runItBack(number - 1);
		}
		else{
			return 1;
		}
		
	}
}
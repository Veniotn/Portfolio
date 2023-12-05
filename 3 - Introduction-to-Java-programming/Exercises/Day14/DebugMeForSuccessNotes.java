public class DebugMeForSuccess {
	public static void main(String ()args) {//[] instead of ()
		int x = 0;
		
		if (x=2) {//need ==
			System.out.println("x is 2!)";//quotaiton outside of bracket
			x++;
			break;//remove
		}
		
		else {//should be on the same line as } (end of if statement)
			return 2;//x=2;
		}
		
		int i = 3;
		int j = i+1;
		int k = i++;//this line will print 4 >> j+1
		int l = ++i;//this line gives 4 >> l=k
		// will print 3 + 4 + 5 + 5?
		System.out.println(i + " " + j + " " + k " " + l); //missing + after k.. prints 4.4.4.4. >> "+" instead of +""+
		
		system.out.print1n("Almost Done");//System.. not system.. L instead of 1 for println
		system.out.print(Multiply(3,4));//System.. not system. multiply, not Multiply
	}
	public static void Multiply(String s1, String s2) {//void returns nothing. void=>int. String should be int
		return (s1 x s2);//cannot multiply strings, * instead of x
	}
}
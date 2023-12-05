public class MultiStageIf {
public static void main(String []args) {
double test = 10; // Try out different values

if (test > 2 && test < 3) {
System.out.println("Test is bigger than 2");

} else if (test > 5 && test < 6) {
System.out.println("Test is bigger than 5");
} else if (test > 8 || test < 9) {
System.out.println("Test is bigger than 8");
} else {
System.out.println("Test is equal to, or smaller than 2");
}
}
}
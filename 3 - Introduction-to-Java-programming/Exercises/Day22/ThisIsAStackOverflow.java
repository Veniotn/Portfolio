public class ThisIsAStackOverflow{

    public static void main(String[] args){
        double i = Double.MAX_VALUE;
        doTheThing(i);

    }

    public static void doTheThing(double i){
        doTheThing(i);
    }
}
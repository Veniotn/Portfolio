import java.util.Scanner;
public class Day24Challenge3{
    public static Scanner scan = new Scanner(System.in);

    public static void main(String []args){
        int start = 0;
        boolean true = true;
        while(true){
            int start = 0;
            String push = scan.nextString();
            int current;
            if(push.equals("A")){
                start - 1;
                return current;
            }
            if(push.equals("W")){
                System.out.print("continue");
            }
            if(push.equals("D")){
                start + 1;
                return current;
            }
            if(push.equals("S")){
                System.out.print("current count: " + current);
            }
            if(push.equals("X")){
                return start;
            }
            else{
                System.out.print("incorrect input try again");
            }
        }
    }
}
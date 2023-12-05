import java.util.Scanner;
import java.util.Arrays;
//ready for marking

public class MessageRedaction{

    public static Scanner scan = new Scanner(System.in);

    public static void main(String []args){
        while(true){
            System.out.println("");
            System.out.print("Type a phrase (or quit to exit program): ");
            String phrase = scan.nextLine();

            if(phrase.equalsIgnoreCase("quit")){
                System.exit(0); /*https://stackoverflow.com/questions/22452930/terminating-a-java-program*/
            }
            else{ 
                String redaction = originalMessage(phrase);
                int sum = redactAmount(redaction);
                System.out.println("Numbers of letters redacted: " + sum);
                System.out.println("Redacted phrase: " + redaction);
            }

        }
     
        
    }
    
    public static String originalMessage(String phrase){
        System.out.print("Type a comma-seperated list of letters to redact: ");
        String[] lettersToRedact = scan.nextLine().split(",");
        for(int i=0; i<lettersToRedact.length; i++){
            phrase = phrase.replaceAll("(?i)" + lettersToRedact[i], "_"); //(?i) used to ignore uppercasing https://stackoverflow.com/questions/15145659/what-do-i-and-i-in-regex-mean      
        } 

        return phrase;
        
    }

    public static int redactAmount(String redaction){
        int sum = 0;
        for(int i=0; i<redaction.length(); i++){ //adding +1 to sum every time we see '_' to figure out the amount of redacted letters
            if(redaction.charAt(i) == '_'){
                sum++;
            }
        }
        return sum;
    }
}
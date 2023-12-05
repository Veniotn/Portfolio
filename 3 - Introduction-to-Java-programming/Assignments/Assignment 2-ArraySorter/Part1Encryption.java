import java.util.Arrays; /* https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html */


public class Part1Encryption{
        public static int startOfUpperCase = 65;
        public static int endOfUpperCase = 91;
        public static int startOfLowerCase = 97;
        public static int endOfLowerCase = 123;
        public static int key = 13;
        public static int minWordSize = 4;
        public static boolean minInput = false;
        public static boolean encrypt = false;
        public static boolean decrypt = false;
        public static boolean inputError = false;
        public static boolean keyCheck = false; /*checking to see if secret key is set*/
        public static void main(String[] args){

         if(args[0].equalsIgnoreCase("encrypt")){
            encrypt = true;
        }
        else if(args[0].equalsIgnoreCase("decrypt")){
            decrypt = true;
        }
        else{
            System.out.println(" ");
            System.out.print("ERROR:invalid input. HOW TO USE: java Part1ClassName encrypt/decrypt -minWordLength() \"word(s) to encrypt[EACH WORD MUST BE AT LEAST 4 LETTERS LONG]\"");
            System.out.println(" ");
        }
        for(int i=0; i<args.length; i++){
            if(args[i].equalsIgnoreCase("-minWordLength")){
                minInput = true;
                minWordSize = Integer.parseInt(args[i+1]);
            }
            else if(args[i].equalsIgnoreCase("-secretNumber")){
                key = Integer.parseInt(args[i+1])%26;
            }
        }
       

        String originalString = args[args.length-1];
        String outputString = "";
        if(minInput==true){
            String toParse = args[args.length-1];
            String[] toParseArray = toParse.split(" ");
            for(String splitString:toParseArray){
                if(splitString.length() > minWordSize){
                    if(encrypt==true){
                        outputString += encrypt(splitString.toCharArray());
                    }
                    else if(decrypt == true){
                        outputString += decrypt(splitString.toCharArray());
                    }
                }
                else{
                    outputString += splitString;
                }
                outputString += " ";
            }
        }

        if(encrypt==true){
            String encryptResult = "";
            if(outputString.isEmpty()){ /* https://www.javatpoint.com/java-string-isempty */
                encryptResult = encrypt(args[args.length-1].toCharArray());
            }
            else{
                encryptResult = outputString;
            }
            if(originalString.equals(encryptResult.trim())){/* https://www.geeksforgeeks.org/java-string-trim-method-example/ */
                System.out.println("secretNumber results in movement by 0 places");
            }
            System.out.println("Your encrypted data is: " + encryptResult);
        }
        

         
        else if(decrypt==true){
            String decryptResult = "";
            if(outputString.isEmpty()){
                decryptResult = decrypt(args[args.length-1].toCharArray());
            }
            else{
                decryptResult = outputString;
            }
            if(originalString.equals(decryptResult.trim())){
                System.out.println("secretNumber results in movement by 0 places");
            }
            
            System.out.println("Your decrypted data is: " + decryptResult);

        }

    }



        public static String encrypt(char[]input){
            char[] chars = input;

        for(char i=0; i< chars.length; i++){
            char temp = chars[i];
            int asciiTemp = (int)temp;
            if(asciiTemp >= startOfUpperCase && asciiTemp <= endOfUpperCase){
                asciiTemp -= startOfUpperCase;
                int wrapper = (asciiTemp + key) % ((endOfUpperCase - startOfUpperCase));
                    asciiTemp = wrapper + startOfUpperCase;
            
            }
            else if(asciiTemp >= startOfLowerCase && asciiTemp <= endOfLowerCase){
                asciiTemp -= startOfLowerCase;
                int wrapper = (asciiTemp + key) % ((endOfLowerCase - startOfLowerCase));
                    asciiTemp = wrapper + startOfLowerCase;
                }
            chars[i] = (char) asciiTemp;
            
        }

        return new String(chars);
    }

    public static String decrypt(char[]input){
            char[] chars = input;

            for(char i=0; i< chars.length; i++){
                char temp = chars[i];
                int asciiTemp = (int)temp;
                if(asciiTemp >= startOfUpperCase && asciiTemp <= endOfUpperCase){
                    asciiTemp -= startOfUpperCase;
                    int wrapper = (asciiTemp - key) % ((endOfUpperCase - startOfUpperCase));
                    asciiTemp = wrapper + startOfUpperCase;
                    if(wrapper<0){
                    asciiTemp = endOfUpperCase + wrapper;
                    }
                
                }
                else if(asciiTemp >= startOfLowerCase && asciiTemp <= endOfLowerCase){
                    asciiTemp -= startOfLowerCase;
                    int wrapper = (asciiTemp - key) % ((endOfLowerCase - startOfLowerCase));
                        asciiTemp = wrapper + startOfLowerCase;
                        if(wrapper<0){
                            asciiTemp = endOfLowerCase + wrapper;
                        }
            }
        chars[i] = (char) asciiTemp;
          
            }
            return new String(chars);
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FilePlayground{
    public static void main(String []args) throws FileNotFoundException, IOException {

        File myFile = new File("HelloProg.txt");

        Scanner scan = new Scanner(myFile);
        System.out.println("Enter a string");
        String str = "abcde";

        FileWriter write = new FileWriter("file name.txt");

        while(scan.hasNext()){
            String currentLine = scan.nextLine();
            System.out.println(currentLine);
        }

        for(int i=0; i<str.length(); i++){
            write.write(str.charAt(i));
        }
        System.out.println("Successfully written");

        write.close();
    } 
}
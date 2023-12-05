import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class FilePlayground2{
    public static void main(String []args) throws FileNotFoundException, IOException{
        File myFile = new File();

        try{
            Scanner myScanner = new Scanner(myFile);

            while(myScanner.hasNext()){
                String currentLine = myScanner.nextLine();
                System.out.println(currentLine);
            }

            FileWriter wr = new FileWriter("testout.txt");
            wr.write("Testing a write");

            wr.close();
        }
    }
}
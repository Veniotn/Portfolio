import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
//ready for marking
public class WhatAWonderfulWorld{

    public static Scanner scan = new Scanner(System.in);

    public static void main(String []args){

        try{    //reading in the input file and setting up the path to write to
            File inputFile = new File("part_1_input_v0_01.txt");
            FileWriter writer = new FileWriter("what_a_wonderful_world.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            ArrayList<String> input = new ArrayList<String>();
            String line;
            while((line = reader.readLine()) !=null){ //adding the input file contents into an arrayList
                input.add(line);
            }
            //generating a random number no bigger than the size of the arraylist to omit a line(found an edge case where it would pick the last line so put -1 to the max size to prevent that)
            int number = new Random().nextInt(input.size()-1);
            for(int i=0; i<input.size(); i++){
                input.set(i, (i+1) + ") " + input.get(i) +"\n"); //numbering each line
                //making changes to lines according to the conditions they hit
                if(input.get(i).contains("wonderful world")){
                   String inputToChange = input.get(i).replaceAll("wonderful world", "wonderful world!"); 
                   input.set(i, inputToChange);
                }
                if(input.get(i).length()<40){
                    input.set(i, input.get(i).toUpperCase());
                }
                if(i == number){
                    input.set(i, "\n");
                }
                writer.write(input.get(i)); 
            }
            //closing reader and writer to prevent memory leaks
            reader.close();
            writer.close();
            System.out.println("File saved Successfully");
            //catching exceptions
        }catch(IOException e){
            System.out.println("IOexception Error.");
        }catch(NoSuchElementException e){
            System.out.println("No line found.");
        }
        
    }
}
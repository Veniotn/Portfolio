package com.example.quizbuilder;

import android.os.Looper;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Util {


    public static void fillArrays(InputStream inputStream, ArrayList<String> definitions, ArrayList<String> terms, HashMap<String,String> answers, int totalQuestions){
        // There will always be a 1:1 ratio for questions to answers,
        // so we will always be using index 0 and 1 of the split array that holds our
        // definition and corresponding answer.
        final int DEFINITION_INDEX = 0;
        final int TERM_INDEX = 1;

        //Reader variables
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            System.out.println("File is open!");
            String currentLine;

            while ((currentLine = reader.readLine()) != null){

                //split current line into two based on $ sign
                String[] splitLine = currentLine.split("\\$");
                //add the definition and term to their respected lists.
                definitions.add(splitLine[DEFINITION_INDEX]);
                terms.add(splitLine[TERM_INDEX]);
                //Add them to the hashmap as a key value pair
                answers.put(splitLine[DEFINITION_INDEX], splitLine[TERM_INDEX]);
                //update the question counter
                totalQuestions++;
            }

            //Close the file.
            inputStream.close();
        }catch (IOException e){
            Log.e("Util", "Error occurred: " + e.getMessage());
        }
    }


    public static void fillRemainingAnswers(Button button1, Button button2, Button button3, ArrayList<String> terms, String answer, Random random)
    {
        //Constant representing the amount of terms needed, since we have 3 buttons we only need
        // three unique terms.
        final int TERMS_NEEDED = 3, TOTAL_TERM_INDEXES = 9;

        int termsUsed = 0;

        //this list will hold unique terms that arent the answer
        ArrayList<String> filteredTerms = new ArrayList<>();

        while (termsUsed < TERMS_NEEDED){

            //Choose a random term
            String term = terms.get(random.nextInt(TOTAL_TERM_INDEXES));

            //If the current term isn't the answer, and the term isn't already in the filtered term
            // list add it to the filtered list.
            if (!term.equals(answer) && !filteredTerms.contains(term)){
                filteredTerms.add(term);
                termsUsed++;
            }
        }

        //Make an list of our buttons
        Button[] buttons = {button1, button2, button3};

        //Fill the buttons with the 3 terms we chose.
        for (int currentTerm = 0; currentTerm < buttons.length; currentTerm++){
            buttons[currentTerm].setText(filteredTerms.get(currentTerm));
        }

    }












}

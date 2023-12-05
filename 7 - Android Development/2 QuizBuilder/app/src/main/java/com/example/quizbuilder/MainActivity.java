package com.example.quizbuilder;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    //UI
    Button   startButton;
    EditText nameEditText;
    TextView welcomeTextView;
    Intent   startQuiz;


    //Quiz Lists
    ArrayList<String>      definitions    = new ArrayList<>();
    ArrayList<String>      terms          = new ArrayList<>();
    HashMap<String,String> correctAnswers = new HashMap  <>();

    //I/O stream to access the raw folder.
    InputStream inputStream;

    //User variables.
    int totalQuestions =0;//checks the input file, the more lines the more questions
    String name;


    //On create.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding functionality to our UI.
        //buttons
        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(buttonClicked);

        //text fields
        welcomeTextView = findViewById(R.id.welcomeView);
        nameEditText = findViewById(R.id.enterNameEditText);

        //Intent to move to quiz screen.
        startQuiz = new Intent(getApplicationContext(), QuizScreen.class);

        //Begin data filling process.
        //Reading in our file.
        inputStream = getResources().openRawResource(R.raw.quiz);

        //Fill the definition and term arrays and the hashmap of answers.
        Util.fillArrays(inputStream, definitions, terms, correctAnswers, totalQuestions);


        //Now that we have our data we can add it to the quiz screen so it is ready as soon as the
        //user presses the start button.
        startQuiz.putExtra("KEY_DEFINITIONS", definitions);
        startQuiz.putExtra("KEY_TERMS", terms);
        startQuiz.putExtra("KEY_ANSWERS",correctAnswers);
    }//End on create


    public View.OnClickListener buttonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            name = nameEditText.getText().toString();
            //if user filled in the name box it will pick their name, if not it will default to
            // "Student".
            startQuiz.putExtra("name", name.equals("") ?
                                                            getString(R.string.nameDefault) : name);

            totalQuestions = definitions.size();
            startQuiz.putExtra("totalQuestions", totalQuestions);
            startActivity(startQuiz);
        }
    };



}
package com.example.quizbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity {

    //Ui stuff for this activity
    Button retryButton, mainMenuButton;
    TextView finalScoreView, resultTextView;
    Intent mainMenu, startQuiz, resultScreen;

    //Variables from the last activity
    int score, totalQuestions;
    String name;

    //Variables for this activity

    double gradePercentage = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        //Other activities
        mainMenu  = new Intent(getApplicationContext(), MainActivity.class);
        startQuiz = new Intent(getApplicationContext(), QuizScreen.class);
        resultScreen = getIntent();


        //Buttons
        retryButton = findViewById(R.id.retryQuizButton);
        retryButton.setOnClickListener(buttonClicked);
        mainMenuButton = findViewById(R.id.mainMenuButton);
        mainMenuButton.setOnClickListener(buttonClicked);


        //TextViews
        finalScoreView = findViewById(R.id.finalScoreView);
        resultTextView = findViewById(R.id.resultTextView);


        //Get data from previous screen
        name  = resultScreen.getExtras().getString("name");
        score = resultScreen.getExtras().getInt("score");
        totalQuestions = resultScreen.getExtras().getInt("totalQuestions");


        //get users percentage grade
        gradePercentage = calculateGrade();

        //Display the users name and their score
        finalScoreView.setText(name + getString(R.string.nameEndText) + " "
                                    + getString(R.string.scoreText)  + score
                                    + getString(R.string.slashSymbolText) + totalQuestions + "\n"
                                    + gradePercentage + getString(R.string.percentSymbol));


        displayResultMessage();
    }


    public View.OnClickListener buttonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.retryQuizButton:
                    startActivity(startQuiz);
                    break;
                case R.id.mainMenuButton:
                    startActivity(mainMenu);
                    break;
                default:
                    break;

            }
        }
    };


    private void displayResultMessage(){
        final String letterString = "Letter grade: ";

        //Display a message depending on their score
        if(gradePercentage >=95){
            resultTextView.setText(letterString + "A+");
        }
        else if (gradePercentage >= 90){
            resultTextView.setText(letterString + "A");
        }
        else if (gradePercentage >= 80){
            resultTextView.setText(letterString + "B");
        }
        else if(gradePercentage >= 60) {
            resultTextView.setText(letterString + "C");
        }
        else{
            resultTextView.setText(letterString + "D");
        }

    }

    private double calculateGrade(){
        //constant to calculate grade percentage
        final int PERCENTAGE = 100;


        return ((double) score / (double) totalQuestions) * PERCENTAGE;
    }



}
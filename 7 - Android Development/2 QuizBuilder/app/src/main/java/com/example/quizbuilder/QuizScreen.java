package com.example.quizbuilder;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;


public class QuizScreen extends AppCompatActivity {

    //UI
    private Button nextQuestionButton, answerButton1, answerButton2, answerButton3, answerButton4,
                                                                                    backButton;

    private TextView definitionView, scoreView,nameView;

    private Intent mainMenu, startQuiz, resultScreen;
    //Quiz stuff
    //Lists
    private ArrayList<String> definitions, terms;
    private HashMap<String,String> correctAnswers;

    //Quiz variables
    private String name,correctAnswer;

    private final int CHOICES = 4;
    private int currentGuess = 0, score=0, totalQuestions = 0;
    private Random random = new Random();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);

        //UI setup
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(buttonClicked);

        definitionView = findViewById(R.id.definitionTextView);

        answerButton1 = findViewById(R.id.answerButton1);
        answerButton1.setOnClickListener(buttonClicked);

        answerButton2 = findViewById(R.id.answerButton2);
        answerButton2.setOnClickListener(buttonClicked);

        answerButton3 = findViewById(R.id.answerButton3);
        answerButton3.setOnClickListener(buttonClicked);

        answerButton4 = findViewById(R.id.answerButton4);
        answerButton4.setOnClickListener(buttonClicked);


        scoreView = findViewById(R.id.scoreTextView);
        nameView  = findViewById(R.id.nameView);


        mainMenu     = new Intent(getApplicationContext(), MainActivity.class);
        resultScreen = new Intent(getApplicationContext(), ResultScreen.class);
        startQuiz    = getIntent();

        //StartQuiz addons
        name = startQuiz.getExtras().getString("name");
        totalQuestions = startQuiz.getExtras().getInt("totalQuestions");

        //Quiz lists
        definitions    = startQuiz.getExtras().getStringArrayList("KEY_DEFINITIONS");
        terms          = startQuiz.getExtras().getStringArrayList("KEY_TERMS");
        correctAnswers = (HashMap<String, String>)startQuiz.getSerializableExtra("KEY_ANSWERS");

        //Display users name and the scoreboard
        nameView.setText(name + getString(R.string.nameEndText));
        scoreView.setText(getString(R.string.scoreText) + score + getString(R.string.slashSymbolText) + totalQuestions);

        //Reset counters
        currentGuess = 0;
        //Shuffle the definitions for a random run every time
        Collections.shuffle(definitions);


        //Start the quiz
        askQuestion();
    }//end on create

    //Quiz button listener
    public View.OnClickListener buttonClicked = new View.OnClickListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.backButton:
                    startActivity(mainMenu);
                    break;
                case R.id.answerButton1:
                    checkAnswer(answerButton1.getText().toString(), correctAnswer);
                    break;
                case R.id.answerButton2:
                    checkAnswer(answerButton2.getText().toString(), correctAnswer);
                    break;
                case R.id.answerButton3:
                    checkAnswer(answerButton3.getText().toString(), correctAnswer);
                    break;
                case R.id.answerButton4:
                    checkAnswer(answerButton4.getText().toString(), correctAnswer);
                default:
                    break;
            }

        }
    };//End buttonClicked


    private void askQuestion(){
        //Shuffle the terms
        Collections.shuffle(terms);

        //Get the current definition and answer
        String currentDefinition = definitions.get(currentGuess);
        correctAnswer = correctAnswers.get(currentDefinition);

        //Display the definition
        definitionView.setText(currentDefinition);


        //Figure out which button will hold the answer and then place it
        int answerIndex = random.nextInt(CHOICES) + 1;

        switch (answerIndex){
            case 1:
                answerButton1.setText(correctAnswer);
                Util.fillRemainingAnswers(answerButton2, answerButton3, answerButton4, terms, correctAnswer, random);
                break;
            case 2:
                answerButton2.setText(correctAnswer);
                Util.fillRemainingAnswers(answerButton1, answerButton3, answerButton4, terms, correctAnswer, random);
                break;
            case 3:
                answerButton3.setText(correctAnswer);
                Util.fillRemainingAnswers(answerButton2, answerButton1, answerButton4, terms, correctAnswer, random);
                break;
            case 4:
                answerButton4.setText(correctAnswer);
                Util.fillRemainingAnswers(answerButton1, answerButton2, answerButton3, terms, correctAnswer, random);
            default:
                break;
        }

        //Increment the guess count
        currentGuess++;

    }//End askQuestion


    @SuppressLint("SetTextI18n")
    private void checkAnswer(String answer, String correctAnswer){
        boolean userCorrect = answer.equals(correctAnswer);
        score = userCorrect ? score+1 : score;

        scoreView.setText(getString(R.string.scoreText) + score + getString(R.string.slashSymbolText)
                                                        + totalQuestions);
        displayResult(definitionView, userCorrect);
    }

    private void displayResult(TextView view, boolean userCorrect){
        final String CORRECT_ANSWER = getString(R.string.CORRECT_ANSWER), INCORRECT_ANSWER = getString(R.string.INCORRECT_ANSWER);

        view.setText(userCorrect ? CORRECT_ANSWER : INCORRECT_ANSWER);

        //Delay the screen, and continue the process.
        screenDelay();
    }

    private void screenDelay(){

        //Ui buffer lets the ui update before the thread stops, and pause time is how long
        //the app will pause for.
        final int UI_BUFFER = 50, PAUSE_TIME = 700;


        //Allow the ui to update, freeze the program to avoid issues, and continue the quiz.
        new Handler(Looper.getMainLooper()).postDelayed(() -> {try {
            Thread.sleep(PAUSE_TIME);
            checkGameState();
        }catch (InterruptedException e){
            e.printStackTrace();
        }},UI_BUFFER);

    }

    private void checkGameState(){
        if (currentGuess >= totalQuestions){
            resultScreen.putExtra("name", name);
            resultScreen.putExtra("score", score);
            resultScreen.putExtra("totalQuestions", totalQuestions);
            startActivity(resultScreen);
        }
        else {
            askQuestion();
        }
    }

}
package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Controller

public class MainActivity extends AppCompatActivity {
    //Buttons
    Button zeroButton,  oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton,
           eightButton, nineButton, addButton, subButton,  multiButton, divButton,equalsButton,
           clearButton, delButton, negateButton, deciButton;

    //Views to hold digits or error messages
    TextView upperNumView, lowerNumView;

    //only operation needed for this program, if we wanted to add a history function,
    //we would just make an arraylist of operation objects and call them onto another view.
    Operation mainOperation = new Operation();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Number buttons
        zeroButton = findViewById(R.id.zeroButton);
        zeroButton.setOnClickListener(buttonClicked);
        oneButton = findViewById(R.id.oneButton);
        oneButton.setOnClickListener(buttonClicked);
        twoButton = findViewById(R.id.twoButton);
        twoButton.setOnClickListener(buttonClicked);
        threeButton = findViewById(R.id.threeButton);
        threeButton.setOnClickListener(buttonClicked);
        fourButton = findViewById(R.id.fourButton);
        fourButton.setOnClickListener(buttonClicked);
        fiveButton = findViewById(R.id.fiveButton);
        fiveButton.setOnClickListener(buttonClicked);
        sixButton = findViewById(R.id.sixButton);
        sixButton.setOnClickListener(buttonClicked);
        sevenButton = findViewById(R.id.sevenButton);
        sevenButton.setOnClickListener(buttonClicked);
        eightButton = findViewById(R.id.eightButton);
        eightButton.setOnClickListener(buttonClicked);
        nineButton = findViewById(R.id.nineButton);
        nineButton.setOnClickListener(buttonClicked);

        //operation buttons
        addButton = findViewById(R.id.plusButton);
        addButton.setOnClickListener(buttonClicked);
        subButton = findViewById(R.id.subtractButton);
        subButton.setOnClickListener(buttonClicked);
        multiButton = findViewById(R.id.multiplyButton);
        multiButton.setOnClickListener(buttonClicked);
        divButton = findViewById(R.id.divideButton);
        divButton.setOnClickListener(buttonClicked);

        //Utility buttons
        equalsButton = findViewById(R.id.equalsButton);
        equalsButton.setOnClickListener(buttonClicked);
        negateButton = findViewById(R.id.negateButton);
        negateButton.setOnClickListener(buttonClicked);
        deciButton = findViewById(R.id.decimalButton);
        deciButton.setOnClickListener(buttonClicked);
        delButton = findViewById(R.id.deleteButton);
        delButton.setOnClickListener(buttonClicked);
        clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(buttonClicked);


        //Views
        upperNumView = findViewById(R.id.upperNumView);
        lowerNumView = findViewById(R.id.lowerNumView);

    }//end onCreate

    public View.OnClickListener buttonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //If the current equation has either a left or right number skip this step.
            //gets rid of the zero when you input your first digit.
            if (mainOperation.isFirstNum()){
                lowerNumView.setText("");
                mainOperation.setFirstNum(false);
            }

            switch (v.getId()) {
                case R.id.zeroButton:
                     Util.append("0", lowerNumView);
                     break;
                case R.id.oneButton:
                     Util.append("1", lowerNumView);
                     break;
                case R.id.twoButton:
                     Util.append("2", lowerNumView);
                     break;
                case R.id.threeButton:
                     Util.append("3", lowerNumView);
                     break;
                case R.id.fourButton:
                     Util.append("4", lowerNumView);
                     break;
                case R.id.fiveButton:
                     Util.append("5", lowerNumView);
                     break;
                case R.id.sixButton:
                     Util.append("6", lowerNumView);
                     break;
                case R.id.sevenButton:
                     Util.append("7", lowerNumView);
                     break;
                case R.id.eightButton:
                     Util.append("8", lowerNumView);
                     break;
                case R.id.nineButton:
                     Util.append("9", lowerNumView);
                     break;
                case R.id.plusButton:
                     mainOperation.operatorStage(Operation.Operator.ADDITION, upperNumView, lowerNumView);
                     break;
                case R.id.subtractButton:
                     mainOperation.operatorStage(Operation.Operator.SUBTRACTION, upperNumView, lowerNumView);
                     break;
                case R.id.multiplyButton:
                     mainOperation.operatorStage(Operation.Operator.MULTIPLICATION, upperNumView, lowerNumView);
                     break;
                case R.id.divideButton:
                     mainOperation.operatorStage(Operation.Operator.DIVISION, upperNumView, lowerNumView);
                     break;
                case R.id.equalsButton:
                     mainOperation.equalsButton(lowerNumView, upperNumView);
                     break;
                case R.id.clearButton:
                     Util.clearButton(lowerNumView, upperNumView);
                     mainOperation.clear();
                     break;
                case R.id.deleteButton:
                     lowerNumView.setText(Util.deleteNum(lowerNumView.getText().toString()));
                     break;
                case R.id.negateButton:
                     mainOperation.negate(lowerNumView);
                     break;
                case R.id.decimalButton:
                     Util.decimal(lowerNumView);
                     break;
                default:
                     break;
            }

            //Gets the current state of the program and sets the properties of the equation.
            Util.currentState(mainOperation, lowerNumView, upperNumView);
        }
    };
}
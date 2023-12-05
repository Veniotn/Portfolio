package com.example.calculator;

import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//View

//Anything that primarily interacts with the view is implemented here.
public class Util {

    public static void append(String input, TextView view){
        //https://stackoverflow.com/questions/2811031/decimal-or-numeric-values-in-regular-expression-validation
        Pattern numMask = Pattern.compile("^[0-9]\\d*(\\.\\d+)?$");
        Matcher numMatcher = numMask.matcher(input);

        if (numMatcher.find()){
            view.append(input);
        }
    }

    public static void currentState(Operation operation, TextView lowerView, TextView upperView){
        double currentStateNum;//Only a double to save on code
        final int MAXDIGITS = 19;

        //grabs a snapshot of the lower view
        String currentState = lowerView.getText().toString();

        //If the digit count is over the limit, deletes the last digit from the view and takes
        //a new snapshot.
        if (currentState.length() > MAXDIGITS){
            lowerView.setText(Util.deleteNum(currentState));
            currentState = lowerView.getText().toString();
        }

        //turns the string from the view to a number
        currentStateNum = Util.toDouble(currentState);

        if (operation.getOperator() != Operation.Operator.NULL && operation.getLeftNum() != 0){
            operation.setRightNum(currentStateNum);
        }
        else {
            operation.setLeftNum(currentStateNum);
        }
    }


    public static String leftUpperState(Operation operation, Operation.Operator operator){
        switch (operator){
            case ADDITION:
                return operation.getLeftNum() + " + ";
            case SUBTRACTION:
                return operation.getLeftNum()  + " - ";
            case DIVISION:
                return operation.getLeftNum()  + " / ";
            case MULTIPLICATION:
                return operation.getLeftNum() + " x ";
            default:
                return "";
        }
    }

    public static String rightUpperState(Operation.Operator operator, double leftNum, double rightNum){ //upper state when pressing equals
        String leftString, rightString;
        leftString = toString(leftNum);
        rightString = toString(rightNum);
        switch (operator) {
            case ADDITION:
                return  leftString + " + " + rightString + " = ";
            case SUBTRACTION:
                return  leftString + " - " + rightString + " = ";
            case DIVISION:
                return  leftString + " / " + rightString + " = ";
            case MULTIPLICATION:
                return  leftString + " x " + rightString + " = ";
            default:
                return "Cannot generate upper state";
        }
    }



    public static double toDouble(String currentState){
        try {
            return Double.parseDouble(currentState);
        }catch (Exception e){
            return 0;
        }
    }


    public static String toString(Double input){
        try {
            return Double.toString(input);
        }catch (Exception e){
            return "Error converting to string.";
        }
    }

    public static void clearButton(TextView lowerView, TextView upperView){
        lowerView.setText("0");
        upperView.setText("");
    }



    public static String deleteNum(String display){          //https://stackoverflow.com/questions/45554762/trying-to-clear-one-character-from-textview
        try {
            if (display!= ""){
                return display.substring(0, display.length() - 1);
            }
        }catch (StringIndexOutOfBoundsException e){
            return "0";
        }
        return "0";
    }

    public static void decimal(TextView view){
        //If there isnt another . on the calculator view add one
        if (!view.getText().toString().contains(".")){
            view.append(".");
        }
    }
}

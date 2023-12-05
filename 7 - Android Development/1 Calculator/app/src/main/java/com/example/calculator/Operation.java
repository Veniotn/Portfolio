package com.example.calculator;

import android.view.View;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Model

//Anything that primarily interacts with the operation properties is implemented here.

public class Operation {

    private double leftNum;
    private double rightNum;
    private double result;
    private boolean isFirstNum;
    private boolean hasOperator;
    private boolean nan;
    private Operator operator;


    enum Operator{
        ADDITION,
        SUBTRACTION,
        DIVISION,
        MULTIPLICATION,
        NULL
    }

    public Operation(){
        this.leftNum =  0;
        this.rightNum = 0;
        this.result = 0;
        this.setOperator(Operator.NULL);//The default operator
        this.isFirstNum = true;
        this.hasOperator = false;
        this.nan = false;
    }//end constructor



    public void equate(TextView lowerView, TextView upperView){
        switch (this.operator){
            case ADDITION:
                this.result = (this.getLeftNum() + this.getRightNum());
                break;
            case SUBTRACTION:
                this.result =  (this.getLeftNum() - this.getRightNum());
                break;
            case DIVISION:
                if (this.getLeftNum() == 0 || this.getRightNum() == 0){ //checking for division by 0
                    nan = true;
                    lowerView.setText("NaN");
                    break;
                }
                this.result = (this.getLeftNum()/this.getRightNum());
                break;
            case MULTIPLICATION:
                this.result =  (this.getLeftNum() * this.getRightNum());
                break;
            default:
                this.result =  this.getLeftNum();
                break;
        }

        if (!nan){//If no errors detected, print result to screen
            lowerView.setText(Util.toString(this.getResult()));
            upperView.setText(Util.rightUpperState(this.getOperator(),this.getLeftNum(),
                                                                      this.getRightNum()));
        }
    }

    public void  operatorStage(Operator operator, TextView upperNumView, TextView lowerNumView){
        //If theres already an operator selected do a rolling calculation and set the result to
        //be the new left number
        if (this.getOperator() != Operator.NULL){
            this.equate(lowerNumView, upperNumView);
            this.setLeftNum(this.getResult());
        }
        //set the new operator
        this.setOperator(operator);
        this.setFirstNum(true);
        upperNumView.setText(Util.leftUpperState(this, operator));

    }

    public void clear(){
        this.leftNum = 0;
        this.rightNum =0;
        this.setOperator(Operator.NULL);
        this.setFirstNum(true);
        this.nan = false;
    }

    public void negate(TextView view){
        //if an operator has been selected negate the right number, else negate the left number.
        if (this.getOperator() != Operation.Operator.NULL){
            this.setRightNum(this.getRightNum() * -1);
            view.setText(Util.toString(this.getRightNum()));
        }
        else {
            this.setLeftNum(this.getLeftNum() * -1);
            view.setText(Util.toString(this.getLeftNum()));
        }

    }

    public void equalsButton(TextView lowerView, TextView upperView){
        //if no operator has been selected yet do nothing.
        if (this.getOperator() != Operator.NULL){
            //set the result of the equate function to the result property of the object
            this.equate(lowerView, upperView);
            this.clear();
        }
    }



    //Getters and setters
    public double getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(double leftNum) {
        this.leftNum = leftNum;
    }

    public double getRightNum() {
        return rightNum;
    }

    public void setRightNum(double rightNum) {
        this.rightNum = rightNum;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public boolean isHasOperator() {
        return hasOperator;
    }

    public void setHasOperator(boolean hasOperator) {
        this.hasOperator = hasOperator;
    }

    public boolean isFirstNum() {
        return isFirstNum;
    }

    public void setFirstNum(boolean firstNum) {
        isFirstNum = firstNum;
    }

}

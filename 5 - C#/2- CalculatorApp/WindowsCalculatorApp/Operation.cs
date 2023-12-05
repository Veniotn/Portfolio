using System;
using System.Reflection.Emit;
using Label = System.Windows.Forms.Label;

namespace CalculatorApp
{
    public class Operation
    {
        private decimal leftNum;
        private decimal rightNum;
        private decimal result;
        private char currentOperator;


        public decimal LeftNum
        {
            get => leftNum;
            set => leftNum = value;
        }

        public decimal RightNum
        {
            get => rightNum;
            set => rightNum = value;
        }

        public decimal Result
        {
            get => result;
            set => result = value;
        }
        

        public char CurrentOperator
        {
            get => currentOperator;
            set => currentOperator = value;
        }

        public void clearOperation(Label label)
        {
            leftNum = 0;
            rightNum = 0;
            currentOperator = '\0';
            label.Text = "";
        }

        public void clearCurrentNum(Label label)
        {
            //if the operator has been pressed, clear the right number, if it hasn't, clear the left
            if (currentOperator != '\0')
            {
                rightNum = 0;
            }
            else {
                leftNum = 0;
            }

            //Clear the UI
            label.Text = "";
        }
        
        public void negate(Label label)
        {
            //if an operator has been selected negate the right number, else negate the left number.
            if (this.currentOperator != '\0'){
                rightNum = (rightNum * -1);
                label.Text = (rightNum.ToString());
            }
            else {
                leftNum = (leftNum * -1);
                label.Text = (leftNum.ToString());
            }

        }

        public void operatorPressed(Label label, char symbolPressed)
        {
            currentOperator = symbolPressed;
            label.Text = "";
        }

        public void decimalPressed(Label label)
        {
            if (!label.Text.Contains("."))
            {
                label.Text += '.';
            }
        }

        public void currentState(Label resultLabel)
        {
            const string NULL = "\0";
            decimal currentNum = resultLabel.Text == NULL ? 0 : Convert.ToDecimal(resultLabel.Text);

            if (currentOperator == '\0')
            {
                leftNum = currentNum;
            }
            else
            {
                rightNum = currentNum;
            }
        }

        
        public void digitPressed(Label resultLabel, char digitPressed)
        {
            const int MAX_DIGITS = 22;

            if (resultLabel.Text == "0")
            {
                resultLabel.Text = "";
            }
            
            resultLabel.Text += digitPressed;

            if (resultLabel.Text.Length > MAX_DIGITS)
            {
                deleteNum(resultLabel);
            }
            
            currentState(resultLabel);
        }
        
        
        public void deleteNum(Label label)
        {
            const int MIN_SIZE = 1;
            label.Text = label.Text.Length > MIN_SIZE && label.Text != "0" ? label.Text.Remove(label.Text.Length - 1) : "0";
        }


        public void equate(Label label)
        {
            switch (currentOperator)
            {
                case '+':
                    result = leftNum + rightNum;
                    break;
                case '-':
                    result = leftNum - rightNum;
                    break;
                case '/':
                    result = leftNum / rightNum;
                    break;
                case '*':
                    result = leftNum * rightNum;
                    break;
                default:
                    result = 0;
                    break;
            }

            
            //display result to user
            label.Text = result.ToString();
            leftNum = result;
        }
    }
}
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CalculatorApp
{
    public partial class Form1 : Form
    {
        Operation operation = new Operation();
        public Form1()
        {
            InitializeComponent();
        }
        
        //Number button click events
        private void zeroButton_Click(object sender, EventArgs e)
        {
            operation.digitPressed(resultLabel, '0');
        }

        private void oneButton_Click(object sender, EventArgs e)
        {
            operation.digitPressed(resultLabel, '1');
        }

        private void twoButton_Click(object sender, EventArgs e)
        {
            operation.digitPressed(resultLabel, '2');
        }

        private void threeButton_Click(object sender, EventArgs e)
        {
            operation.digitPressed(resultLabel, '3');
        }

        private void fourButton_Click(object sender, EventArgs e)
        {
            operation.digitPressed(resultLabel, '4');
        }

        private void fiveButton_Click(object sender, EventArgs e)
        {
            operation.digitPressed(resultLabel, '5');
        }

        private void sixButton_Click(object sender, EventArgs e)
        {
            operation.digitPressed(resultLabel, '6');
        }

        private void sevenButton_Click(object sender, EventArgs e)
        {
            operation.digitPressed(resultLabel, '7');
        }

        private void eightButton_Click(object sender, EventArgs e)
        {
            operation.digitPressed(resultLabel, '8');
        }

        private void nineButton_Click(object sender, EventArgs e)
        {
            operation.digitPressed(resultLabel, '9');
        }
        
        //Functional button events
        private void negateButton_Click(object sender, EventArgs e)
        {
            operation.negate(resultLabel);
        }

        private void decimalButton_Click(object sender, EventArgs e)
        {
            operation.decimalPressed(resultLabel);
        }

        private void additionButton_Click(object sender, EventArgs e)
        {
            operation.operatorPressed(resultLabel, '+');
        }

        private void subtractionButton_Click(object sender, EventArgs e)
        {
            operation.operatorPressed(resultLabel, '-');
        }

        private void multiplyButton_Click(object sender, EventArgs e)
        {
            operation.operatorPressed(resultLabel, '*');
        }

        private void divisionButton_Click(object sender, EventArgs e)
        {
            operation.operatorPressed(resultLabel, '/');
        }
        
        private void equalsButton_Click(object sender, EventArgs e)
        {
            operation.equate(resultLabel);
        }

        private void clearButton_Click(object sender, EventArgs e)
        {
            operation.clearOperation(resultLabel);
        }

        private void clearCurrentButton_Click(object sender, EventArgs e)
        {
            operation.clearCurrentNum(resultLabel);
        }

        private void backspaceButton_Click(object sender, EventArgs e)
        {
            operation.deleteNum(resultLabel);
            operation.currentState(resultLabel);
        }

        
    }
}
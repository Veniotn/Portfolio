//
// Created by nick on 3/24/2023.
//
#include "../inc/RationalNumber.h"

RationalNumber::RationalNumber(string input)
{
    if (regex_match(input,wholeNumberRegex))
    {
        //convert the string to an integer and set it to the numerator, no need to try catch
        // because we know the input is valid.
        this->numerator = stoi(input);
        //if a whole number is passed the fraction will always be x/1 so set the denominator to 1.
        this->denominator = 1;
    } else if (regex_match(input, fractionRegex))
    {
        //since we know the input is correct we can use a string stream and break each character into
        // the objects properties.
        stringstream stringStream(input);
        char slash;
        stringStream >> this->numerator >> slash >> this->denominator;
    }
};

RationalNumber::RationalNumber(int wholeNumber)
{
    numerator = wholeNumber;
    denominator = 1;
}

void RationalNumber::simplifyFraction()
{

    //get the greatest common denominator, then divide both the numerator and operator by it.
    int greatestDenominator = gcd(this->numerator, this->denominator);
    numerator   = numerator   / greatestDenominator;
    denominator = denominator / greatestDenominator;


    //if either numerator or denominator are negative, negate them.
    if (numerator < 0 || denominator < 0)
    {
        numerator   = numerator   < 0 ? (numerator   * -1) : numerator;
        denominator = denominator < 0 ? (denominator * -1) : denominator;
    }

}



//Math operators
RationalNumber RationalNumber::operator+(const RationalNumber &rightNumber)
{
    int numeratorVar, denominatorVar;
    cout << "+ operator firing." << endl;
    //Uses the object that called the methods properties and the other RA.
    numeratorVar = (this->numerator    * rightNumber.denominator) + (rightNumber.numerator * this->denominator);
    denominatorVar = this->denominator * rightNumber.denominator;



    return {numeratorVar, denominatorVar};
}

RationalNumber RationalNumber::operator-(const RationalNumber &rightNumber)
{
    int numeratorVar, denominatorVar;
    cout << "- operator firing." << endl;
    //same steps as + operator, just subtraction
    numeratorVar = (this->numerator    * rightNumber.denominator) - (rightNumber.numerator * this->denominator);
    denominatorVar = this->denominator * rightNumber.denominator;


    //Return new Rational number
    return {numeratorVar, denominatorVar};
}


RationalNumber RationalNumber::operator*(const RationalNumber& rightNumber)
{
    int numeratorVar, denominatorVar;
    cout << "* operator firing" << endl;
    //multiply the numerator of this fraction with the numerator of the right fraction,
    numeratorVar   = (this->numerator   * rightNumber.numerator);
    //multiply the denominator of this fraction with the denominator of the right fraction.
    denominatorVar = (this->denominator * rightNumber.denominator);


    //return the new rational number
    return {numeratorVar,denominatorVar};
}


RationalNumber RationalNumber::operator/(const RationalNumber &rightNumber)
{
    int numeratorVar, denominatorVar;
    cout << "/ operator method firing." << endl;

    //If any number in either rational number is zero, prompt the user about division by zero and set the result
    // to 0/0.
    if ((this->numerator == ZERO || rightNumber.numerator == ZERO) || (this->denominator == ZERO || rightNumber.denominator == ZERO))
    {
        cout << "ERROR: Division by zero." << endl;
        numeratorVar   = ZERO;
        denominatorVar = ZERO;
    } else
    {
        //to find the division multiply the numerator of the left number by the denominator of the right number, and the
        // denominator of the left number by the numerator of the right number.
        numeratorVar   =  this->numerator   * rightNumber.denominator;
        denominatorVar =  this->denominator * rightNumber.numerator;
    }

    //Return new rational number object.
    return {numeratorVar,denominatorVar};
}


RationalNumber RationalNumber::operator+=(const RationalNumber &rightNumber)
{
    cout << "+= operator firing" << endl;

    numerator    = (this->numerator * rightNumber.denominator) + (rightNumber.numerator * this->denominator);
    denominator *= rightNumber.denominator;

    return *this;
}

RationalNumber RationalNumber::operator=(const RationalNumber &rightNumber)
{
    cout << "= operator firing" << endl;

    numerator   = rightNumber.numerator;
    denominator = rightNumber.denominator;

    return *this;
}
//end math operators.

//boolean operators
bool RationalNumber::operator<(const RationalNumber &rightNumber)
{
    cout << "< operator firing" << endl;
    return (this->numerator * rightNumber.denominator) < (rightNumber.numerator * this->denominator);
}

bool RationalNumber::operator>(const RationalNumber &rightNumber)
{
    cout << "> operator firing" << endl;
    return (this->numerator * rightNumber.denominator) > (rightNumber.numerator * this->denominator);
}

bool RationalNumber::operator==(const RationalNumber &rightNumber)
{
    cout << "== operator firing" << endl;
    return (this->numerator * rightNumber.denominator) == (rightNumber.numerator * this->denominator);
}
//end boolean operators.

//output overload.
ostream& operator<<(std::ostream & output, RationalNumber& rationalNumber)
{

//    output << "<< overload firing " << endl;

    //check for negative numbers before simplifying and print it before the fraction.
    if (rationalNumber.numerator < 0 || rationalNumber.denominator < 0 )
    {
        output << "-";
    }

    //simply the fraction and add the result to the output stream object
    rationalNumber.simplifyFraction();
    output << rationalNumber.numerator << "/" << rationalNumber.denominator;


    //return the stream object to be executed by cout in main.
    return output;
}

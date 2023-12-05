
//
// Created by nick on 3/24/2023.
//

#ifndef INC_2___RATIONALS_RATIONALNUMBER_H
#define INC_2___RATIONALS_RATIONALNUMBER_H
#include "util.h"

class RationalNumber {

private:
    int numerator, denominator;

public:

    //constructors
    RationalNumber():numerator(0), denominator(1){}
    RationalNumber(int numerator, int denominator): numerator(numerator), denominator(denominator){}
    RationalNumber(int wholeNumber);
    RationalNumber(string stringInput);


    //overloaded basic math operators
    RationalNumber  operator + (const RationalNumber& rightNumber);
    RationalNumber  operator - (const RationalNumber& rightNumber);
    RationalNumber  operator * (const RationalNumber& rightNumber);
    RationalNumber  operator / (const RationalNumber& rightNumber);
    RationalNumber  operator += (const RationalNumber& rightNumber);
    RationalNumber  operator =  (const RationalNumber& rightNumber);

    //overloaded boolean operators
    bool operator >  (const RationalNumber& rightNumber);
    bool operator <  (const RationalNumber& rightNumber);
    bool operator == (const RationalNumber& rightNumber);

    //overloaded print operator
    friend ostream& operator << (ostream & output, RationalNumber& rationalNumber);


    //methods
    void simplifyFraction();


    //getters and setters
    int getNumerator()
    {
        return numerator;
    }

    void setNumerator(int numerator) {
        RationalNumber::numerator = numerator;
    }

    int getDenominator()
    {
        return denominator;
    }

    void setDenominator(int denominator) {
        RationalNumber::denominator = denominator;
    }

};


#endif //INC_2___RATIONALS_RATIONALNUMBER_H

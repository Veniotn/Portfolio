//
// Created by nick on 3/26/2023.
//

#ifndef INC_2___RATIONALS_UTIL_H
#define INC_2___RATIONALS_UTIL_H
#include <iostream>
#include <string>
#include <regex>
#include <numeric>
using namespace std;

//global regex
extern regex wholeNumberRegex, fractionRegex;
extern const int ZERO;

class Util {
public:
    //prompts for valid input.
    static string getInput();
};

#endif //INC_2___RATIONALS_UTIL_H

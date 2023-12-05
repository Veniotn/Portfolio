//
// Created by nick on 3/26/2023.
//

#include "../inc/util.h"
regex wholeNumberRegex("^-?[1-9]\\d*$"), fractionRegex("((-?\\d+)/(-?\\d+))");
const int ZERO  = 0;

string Util::getInput()
{
    string input;

    //prompt for input and validate it against the regex.
    cout << "Input a rational number (1/2) or a whole number (1-Infinity): ";

    while(true) {
        getline(cin, input);

        if (regex_match(input, fractionRegex) || regex_match(input, wholeNumberRegex))
        {
            //if it matches either valid regex prompt the user and return it as a string.
            cout << "Successful input." << endl;
            return input;
        }

        //if there's no match the input is invalid, prompt and restart the process.
        cout << "Invalid input. No decimals, spaces or special characters other than \"/\" allowed. \n\nInput again: ";

    }
}

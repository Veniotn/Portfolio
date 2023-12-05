//
// Created by nick on 2/28/2023.
//

#include "util.h"

string Util::toLower(string input)
{
    char letter;
    for (int letterIndex = 0; letterIndex < input.length(); letterIndex++)
    {
        //take each letter of the input string and use it against the library function toLower.
        letter = input[letterIndex];
        input[letterIndex] = tolower(letter);
    }

    //return lower cased string
    return input;
}


string  Util::getStringInput(string prompt)
{
    string response;
    cout << prompt;
    cin >> response;

    return response;
}


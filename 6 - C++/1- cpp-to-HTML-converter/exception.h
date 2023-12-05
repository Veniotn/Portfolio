//
// Created by nick on 2/3/2023.
//

#ifndef MAIN_CPP_EXCEPTION_H
#define MAIN_CPP_EXCEPTION_H
#include <iostream>
#include <fstream>
#include <string>
#include <regex>

using namespace std;

struct MyCustomException : public exception
{
    const string what()
    {
        return "File name is invalid. Make sure you are inputting a valid windows file format.";
    }
};

#endif //MAIN_CPP_EXCEPTION_H

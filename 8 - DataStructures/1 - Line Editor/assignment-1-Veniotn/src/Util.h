//author: Nick Veniot

#ifndef ASSIGNMENT1_UTIL_H
#define ASSIGNMENT1_UTIL_H
#include <iostream>
#include <regex>
#include "LinkedList.h"



class Util {


public:

    //main function
    static void line_editor(LinkedList& list);


    //util functions
    static int convert_num(char input);
    static void display_line(LinkedList& list);
    static void get_commands(std::vector<char>& commands, std::string& input, LinkedList& list);
    static std::string get_line_input(int line_num);
    static void insert_vs_add(LinkedList& list, std::string& data);
    static void scan_input(std::string& input, std::vector<char>& commands);
    static bool validate_name(std::string& file_name);
};

#endif //ASSIGNMENT1_UTIL_H

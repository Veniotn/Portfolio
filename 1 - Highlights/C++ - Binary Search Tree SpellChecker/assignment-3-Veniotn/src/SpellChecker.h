//
// Created by nick on 11/16/2023.
//

#ifndef ASSIGNMENT_3_SPELLCHECKER_H
#define ASSIGNMENT_3_SPELLCHECKER_H

#include "SearchTree.h"
#include <regex>
#include <sstream>
#include <fstream>

class SpellChecker {

private:
    //file name pattern
    const std::regex FILE_NAME_REGEX = std::regex(R"(^(?:.*[\\/:])?[^\\/:*?"<>|]+\.txt$)");
    //bst that holds the dictionary
    SearchTree dictionary_tree;

    //removes all special characters from a word before it gets checked for spelling errors
    void clean_word(std::string &word);

    //confirms that the current string is a word and not blank space
    bool is_word(char &first_letter);

public:
    //getter for our dictionary tree
    SearchTree &get_tree();

    //confirms a valid txt file is being passed
    bool validate_file_name(std::string &file_name);

    //validates the file and calls on validate file name method
    bool validate_file(std::ifstream &file, std::string file_name);

    //main spell checking method ran on our misspelled input file
    void spell_check(std::istream &input_file);

};

#endif //ASSIGNMENT_3_SPELLCHECKER_H

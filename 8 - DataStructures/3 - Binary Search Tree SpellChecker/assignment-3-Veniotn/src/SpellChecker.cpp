//
// Created by nick on 11/16/2023.
//

#include "SpellChecker.h"

using namespace std;


SearchTree &SpellChecker::get_tree() {
    return dictionary_tree;
}

void SpellChecker::spell_check(istream &input_file) {
    //search through the file and check every word
    string text_line, word;
    int misspelled_count = 0;

    //print header message to console
    cout << "\nMisspelled words: " << endl;

    while (!input_file.eof()) {
        //grab the current line
        getline(input_file, text_line);

        //use string stream to grab one word at a time from the current line
        istringstream iss(text_line);

        //grab one word from the line at a time
        while (iss >> word) {
            //get rid of special characters around the word
            clean_word(word);

            //if the word cannot be found, and it's not a number, print it to the console
            //and increment the misspelled count
            if (!dictionary_tree.search(word) && is_word(word[0])) {
                cout << word << endl;
                misspelled_count++;
            }
        }
    }
    //tell the user how many words are incorrect
    cout << "\nTotal number of misspelled words: " << misspelled_count << endl;
}


//removes special characters from a word
void SpellChecker::clean_word(string &word) {
    string cleaned;
    //iterate through each character in the word
    for (char character: word) {
        //if the char is a valid letter add it to the temp string
        if (isalpha(character)) {
            //lower case every letter
            character = tolower(character);
            cleaned += character;
        }
    }
    //if the string isn't null "return" our cleaned word
    if (cleaned != "\0") {
        word = cleaned;
    }
}

bool SpellChecker::is_word(char &first_letter) {
    //if the first letter of any given string isn't a letter it's either a digit or special character
    return isalpha(first_letter);
}

bool SpellChecker::validate_file_name(string &file_name) {
    //validate file name against the regex pattern
    return regex_match(file_name, FILE_NAME_REGEX);
}


bool SpellChecker::validate_file(std::ifstream &file, std::string file_name) {
    //if the name is invalid or the file fails to open, prompt the user and return false
    if (!validate_file_name(file_name) || file.fail()) {
        cout << "Error opening: " << file_name << " ! .txt files only." << endl;
        return false;
    }
    return true;
}

#include <iostream>
#include "SpellChecker.h"

using namespace std;

int main(int argc, char **argv) {

    //check for correct number of arguments
    if (argc != 4) {
        cout << "Error: wrong number of parameters" << endl;
        return -1;
    }

    //holds our dictionary and misspelled files
    ifstream input_file;
    //holds our printed balanced tree
    ofstream output_file;
    //holds our search tree and spellchecking methods
    SpellChecker spell_checker;

    //open the dictionary file
    input_file.open(argv[1]);
    //validate the file before continuing
    if (!spell_checker.validate_file(input_file, argv[1])) { return -1; }

    //create our search tree and fill it with the dictionary file
    input_file >> spell_checker.get_tree();
    input_file.close();

    //open the misspelled file
    input_file.open(argv[2]);
    //validate the file before continuing
    if (!spell_checker.validate_file(input_file, argv[2])) { return -1; }

    //spellcheck the file
    spell_checker.spell_check(input_file);
    input_file.close();

    //create output file in the desired location, no need to validate file type
    output_file.open(argv[3]);
    if (!output_file.fail()) {
        //print our balanced tree to the output file
        output_file << spell_checker.get_tree();
        output_file.close();
    }
    return 0;
}

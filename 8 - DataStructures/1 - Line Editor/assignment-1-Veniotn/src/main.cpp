#include <iostream>
#include "LinkedList.h"
#include "Util.h"

//author: Nick Veniot
using  std::cout;
using  std::endl;
using  std::string;

int main(int argc, char* argv[]) {

    //check for the right number of commands
    if (argc != 2)
    {
        cout << "Make sure to include your file name e.g: ./assignment1 test.txt" << endl;
        return -1;
    }

    //grab the filename and make sure it's in a valid format, if its valid begin filling the list
    string file_name = argv[1];
    bool valid_arguments = Util::validate_name(file_name);
    LinkedList main_list;

    if (valid_arguments)
    {
         LinkedList::create_list(file_name, main_list);
    } else
    {
        cout << "Invalid file format. Example file format: file_name.txt" << endl;
        return -1;
    }

    //enter the line editor
    Util::line_editor(main_list);

    //once user has exited the line editor, write the list to a file and exit
    LinkedList::save(file_name, main_list);

    return 0;
}

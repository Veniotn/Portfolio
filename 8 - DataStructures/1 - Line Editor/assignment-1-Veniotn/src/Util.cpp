//author: Nick Veniot

#include "Util.h"
using  std::cin;
using  std::cout;
using  std::endl;
using  std::regex_match;
using  std::regex;
using  std::string;

//main function
void   Util::line_editor(LinkedList &list)
{
    string            input;
    std::vector<char> commands;

    //display the current list if there is any
    cout << list;
    bool exit = false;
    do
    {

        //display the current line and prompt for input
        Util::get_commands(commands, input, list);




        //check if the input was a command or just text input
        if (commands.size() > 3 || commands.size() < 1)
        {
            insert_vs_add(list, input);
        } else
        {
            //check first command parameter and proceed to corresponding process
            switch (tolower(commands[0]))
            {
                case 'i':
                    list.insert_process(commands, input);
                    list.set_insert_mode(true);
                    break;
                case 'd':
                    list.remove_process(commands);
                    list.set_insert_mode(false);
                    break;
                case 'l':
                    list.display_process(commands);
                    list.set_insert_mode(false);
                    break;
                case 'e':
                    exit = true;
                    break;
                default:
                    insert_vs_add(list, input);
                    break;
            }
        }
    } while (!exit);
}


//util functions
int    Util::convert_num(char input)
{
    return isdigit(input) ? input - '0' : -1;
}

void   Util::display_line(LinkedList& list)
{
    cout << list.get_current_num() << ">";
}

void   Util::get_commands(std::vector<char>& commands, string& input, LinkedList& list)
{

    //prompt for input, then scan the string to create the commands vector
    commands.clear();

    cout << list.get_current_num() << ">";
    std::getline(cin, input);
    cin.clear();

    scan_input(input, commands);
}

string Util::get_line_input(int line_num)
{
    string input;

    cout << line_num << ">";
    std::getline(cin, input);


    return input;
}

void   Util::insert_vs_add(LinkedList& list, string& data)
{
    //if we're in insert mode, insert, else add to the end of the list.
    if (list.get_insert_mode())
    {
        list.insert(list.get_current_num(), data);
    } else
    {
        list.add(data);
    }
}

void   Util::scan_input(string& input, std::vector<char>& commands)
{
    //ignores whitespace and adds every character of the input to the commands vector
    for (char character : input)
    {
        if (std::isalnum(character))
        {
            commands.push_back(character);
        }
    }

}

bool   Util::validate_name(string& file_name)
{
    regex   regex_mask("[^/]*\\.txt$");
    return  regex_match(file_name, regex_mask);
}

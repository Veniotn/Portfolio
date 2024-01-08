//author: Nick Veniot

#include "LinkedList.h"
#include "Util.h"
using  std::cout;
using  std::endl;
using  std::string;


//operational methods
void LinkedList::add(std::string& data)
{
    //create node, add the data and give it an address
    auto node  = new Node();
    node->data = data;


    //if the list is empty, place the new node at the start
    if (starting_address == nullptr)
    {
        starting_address  = node;
        node->line_number = starting_num;
        current_num++;
    } else
    {
        //find the end of the list and add the node
        auto current_node  = starting_address;
        auto previous_node = (Node *) nullptr;

        while (current_node != nullptr)
        {
            previous_node = current_node;
            current_node  = current_node->next_node;
        }
        previous_node->next_node = node;
        node->line_number        = current_num;
        current_num++;
    }
}

void LinkedList::create_list(string& file_name, LinkedList& list)
{

    //attempt to open file
    try
    {
        std::ifstream input_stream(file_name);

        if (!input_stream.fail())
        {
            //if file is found read in each line and add them to the list
            string in_line;
            while (!input_stream.eof())
            {
                getline(input_stream, in_line);
                list.add(in_line);
            }
        } else
        {
            //if no file is found, return an empty list
            cout << "New File!" << endl;
        }

        input_stream.close();
    }
    catch (std::ios_base::failure& failure)
    {
        cout << failure.what() << endl;
    }

}

void LinkedList::display_process(std::vector<char> commands)
{
    switch (commands.size())
    {
        case 1:
            //just print the full list
            cout << *this;
            break;
        case 2:
            //display specific line
            display(Util::convert_num(commands[1]));
            break;
        case 3:
            display(Util::convert_num(commands[1]), Util::convert_num(commands[2]));
            break;
        default:
            cout << endl << "Invalid number of commands" << endl;
            break;
    }
    //set current num to be one after the end of the list
    calibrate_list();
}

void LinkedList::display(int display_line)
{
    auto current_node = starting_address;

    if (line_exists(display_line))
    {
        //search for the specific line and output it
        while (current_node->line_number != display_line)
        {
            current_node = current_node->next_node;
        }

        cout << current_node->line_number << '>' << current_node->data << endl;
    }
}

void LinkedList::display(int start_num, int end_num)
{
    //display the nodes starting from start_num and ending on end_num
    auto current_node = starting_address;

    if (line_exists(start_num) && line_exists(end_num))
    {
        while (current_node->line_number != start_num)
        {
            current_node = current_node->next_node;
        }

        if (current_node != nullptr)
        {
            while (current_node != nullptr)
            {
                if (current_node->line_number > end_num)
                {
                    break;
                }
                cout << current_node->line_number << ">" << current_node->data << endl;
                current_node = current_node->next_node;
            }
        }
    }

}

void LinkedList::insert_process(std::vector<char> commands, string& input)
{
    //only enter insert mode if the commands are correct
    switch (commands.size())
    {
        case 1:
            //insert on current line
            insert();
            insert_mode = true;
            break;
        case 2:
            //insert of specific line
            insert(Util::convert_num(commands[1]), input);
            insert_mode = true;
            break;
        default:
            cout << "insert cannot be called on a range, must be called on individual line number" << endl;
            break;
    }
}

void LinkedList::insert(int insert_line, string& input)
{
    if (line_exists(insert_line))
    {
        //find the node we want to insert before
        auto node          = new Node;
        auto current_node  = starting_address;
        auto previous_node = null__node_ptr;

        while (current_node != nullptr)
        {
            if (current_node->line_number == insert_line)
            {
                break;
            }
            previous_node = current_node;
            current_node  = current_node->next_node;
        }


        //if we're in insert mode we will already have input
        if (!insert_mode)
        {
            input = Util::get_line_input(current_node->line_number);
        }


        //if we are inserting in the last node, just add it instead.
        if (current_node == nullptr)
        {
            add(input);
        } else
        {
            //insert at beginning of list
            if (previous_node == nullptr)
            {
                node->next_node   = current_node;
                node->data        = input;
                node->line_number = starting_num;
                current_node->line_number++;
                starting_address  = node;
            } else
            {
                //insert in the middle of the list
                previous_node->next_node  = node;
                node->next_node           = current_node;
                node->data                = input;
                node->line_number         = assign_num(node->data);
                current_node->line_number = node->line_number + 1;
            }

            //adjust the current line number to be one more than the last entered lines number
            current_num = node->line_number+1;
        }
    }
}

void LinkedList::insert()
{
    //base insert just acts like add with one extra step
    string input;
    Util::display_line(*this);
    std::getline(std::cin, input);
    this->add(input);
}

void LinkedList::remove_process(std::vector<char> commands)
{

    switch (commands.size())
    {
        case 1:
            //remove current line
            remove(this->size());
            break;
        case 2:
            //remove on specific line
            remove(Util::convert_num(commands[1]));
            break;
        case 3:
            //remove on range
            remove(Util::convert_num(commands[1]), Util::convert_num(commands[2]));
            break;
        default:
            cout << "only two commands max" << endl;
            break;
    }

    //adjust the line numbers of each node to reflect the removal
    calibrate_list();
}

void LinkedList::remove(int line_to_delete)
{
    auto current_node = starting_address;
    auto previous_node = null__node_ptr;

    if (line_exists(line_to_delete))
    {
        //find the line we want to delete
        while (current_node != nullptr)
        {
            if (current_node->line_number == line_to_delete)
            {
                break;
            }

            previous_node = current_node;
            current_node = current_node->next_node;
        }


        //if it exists delink its references from the list and delete the node.
        if (current_node != nullptr)
        {
            if (current_node == starting_address)
            {
                starting_address = current_node->next_node;
            }else
            {
                previous_node->next_node = current_node->next_node;
            }

            delete current_node;
            current_num--;
        }

    }



}

void LinkedList::remove(int delete_start, int delete_end)
{

    if (line_exists(delete_start) && line_exists(delete_end))
    {
        auto current_node = starting_address;
        auto previous_node = null__node_ptr;

        //if the user inputs 4 2 flip the start and end variables
        if (delete_start > delete_end)
        {
            int temp     = delete_start;
            delete_start = delete_end;
            delete_end   = temp;
        }

        //find the line to start the delete on
        while (current_node != nullptr)
        {
            if (current_node->line_number == delete_start)
            {
                break;
            }

            if (previous_node == null__node_ptr)
            {
                previous_node = current_node;
            }
            else
            {
                previous_node->next_node = current_node;
            }

            current_node = current_node->next_node;
        }

        if (current_node != nullptr)
        {
            //once the start is found, delete from that node to the ending node
            while (current_node != nullptr)
            {

                if (current_node->line_number > delete_end)
                {
                    break;
                }

                //grab the next node before we delete the current node
                auto next_node_var = current_node->next_node;

                if (current_node == starting_address)
                {
                    starting_address = next_node_var;
                    delete current_node;
                } else
                {
                    previous_node->next_node = current_node->next_node;
                    delete current_node;
                }

                current_num--;
                current_node = next_node_var;
            }
        }
    }

}

void LinkedList::save(string& file_name, LinkedList& list)
{
    try
    {
        //output_file will be written to, input is used to avoid duplicating the text file
        std::ofstream output_file(file_name);
        std::ifstream input_file(file_name);

        if (!output_file.fail())
        {
            string current_line;
            auto current_node = list.get_starting_address();
            char white_space  = '\n';

            while (current_node != nullptr)
            {
                //write the contents of the list to the file
                std::getline(input_file,  current_line);
                if (current_node->data != current_line)
                {
                    output_file << current_node->data;
                    if (current_node->next_node != nullptr)
                    {
                        output_file << white_space;
                    }
                }
                current_node = current_node->next_node;
            }
        } else
        {
            //if the file fails to open alert the user.
            cout << "Error writing to file: " << file_name << endl;
        }

        //close the files
        output_file.close();
        input_file.close();
    }
    catch(std::ios_base::failure& fail)
    {

        cout << "Error closing: " << file_name;
        cout << fail.what();
    }
}


//functional methods
int LinkedList::assign_num(string& data)
{
    auto current_node = starting_address;
    int counter = 0;

    while (current_node != nullptr)
    {
        counter++;
        if (current_node->data == data)
        {
            return counter;
        }

        current_node = current_node->next_node;
    }

    return -1;
}

void LinkedList::calibrate_list()
{
    int counter = 0;
    auto current_node = starting_address;

    //make sure each node has the correct line number and also adjust the next line number to display to the user
    while (current_node != nullptr)
    {
        counter++;
        current_node->line_number = counter;
        current_node = current_node->next_node;
    }

    current_num = (counter + 1);
}

bool LinkedList::line_exists(int line)
{
    //if the line is within the range of our list or if its insert mode and we're inserting on the current line, return true
    if ((line > 0 && line <= this->size()) || (insert_mode && line == current_num))
    {
        return true;
    }


    cout  << "Line: " << line << " doesn't exist" << endl << endl;
    return false;
}

int LinkedList::size()
{
    //increment counter for every node in the list.
    int counter = 0;
    auto current_node  = starting_address;

    while (current_node != nullptr)
    {
        counter++;
        current_node  = current_node->next_node;
    }

    return counter;
}


//operator and destructor
std::ostream& operator<<(std::ostream& output, LinkedList& list)
{

    auto current_node = list.starting_address;
    char line_marker = '>';

    //display every line of the list
    while (current_node != nullptr)
    {
        output << current_node->line_number << line_marker << current_node->data << endl;
        current_node = current_node->next_node;
    }

    list.current_num = list.size() + 1;

    cout << endl;
    return output;
}

LinkedList::~LinkedList()
{
    //loop from start-end of list, giving the address of the current node to temp, moving to the next node and deleting temp
    auto node = starting_address;

    while (node != nullptr)
    {
        auto temp = node;
        node = node->next_node;
        delete temp;
    }
}

//
// Created by nick on 9/19/2023.
//

#ifndef ASSIGNMENT1_LINKEDLIST_H
#define ASSIGNMENT1_LINKEDLIST_H
#include <iostream>
#include <fstream>
#include <vector>


class LinkedList {
private:
    struct Node {
        //give the node data and a link to the next node
        std::string data{"null"};
        int line_number {-1};
        Node *next_node{nullptr};
    };

    bool insert_mode = false;
    //will be given to the first node in the list
    Node *starting_address    = nullptr;
    Node *null__node_ptr      = nullptr;
    int  starting_num         = 1;
    int  current_num          = 1;

public:


    //getters / setters
    int get_current_num() const{return current_num;}
    void set_insert_mode(bool input){insert_mode = input;}
    bool get_insert_mode() const {return insert_mode;}
    Node* get_starting_address(){return starting_address;}


    //Operational methods
    void add(std::string& data);
    static void create_list(std::string& file_name, LinkedList &list);
    void display_process(std::vector<char> commands);
    void display(int display_line);
    void display(int display_start, int display_end);
    void insert_process(std::vector<char> commands, std::string& input);
    void insert();
    void insert(int insert_line, std::string& input);
    void remove_process(std::vector<char> commands);
    void remove(int line_to_delete);
    void remove(int delete_start, int delete_end);
    static void save(std::string& file_name, LinkedList& list);


    //functional methods
    int  assign_num(std::string& data);
    void calibrate_list();
    bool line_exists(int line);
    int  size();


    //operator and destructor
    virtual ~LinkedList();
    friend std::ostream &operator<<(std::ostream &output, LinkedList &list);
};


#endif //ASSIGNMENT1_LINKEDLIST_H

//
// Created by nick on 11/5/2023.
//

#ifndef ASSIGNMENT_3_SEARCHTREE_H
#define ASSIGNMENT_3_SEARCHTREE_H

#include <iostream>

//avl balancing methods and printing method found here:
//https://www.programiz.com/dsa/avl-tree

//individual search tree node
struct Node {
    std::string m_data{"/0"};
    Node *m_left{nullptr};
    Node *m_right{nullptr};
    int m_height{1};
};

class SearchTree {
private:

    //start of our search tree
    Node *m_root{nullptr};

    //recursive insert method that auto balances
    Node *insert(std::string word, Node *&node);

    //checks for inbalances and adjusts the tree accordingly
    Node *balance(Node *&node, std::string &word);

    //used to search through the list for a given word
    bool search(Node *&node, std::string word);

    // returns the height differences between each node
    int balance_factor(Node *node);

    //returns the nodes current height
    int height(Node *node);

    // updates the currents node height relative to its children
    void update_height(Node *node);

    //both of our rotation methods, called when tree isn't balanced
    Node *right_rotate(Node *node);

    Node *left_rotate(Node *node);

    //prints our tree to an output file
    std::ostream &print_tree(std::ostream &output, Node *root, std::string indent, bool last);

    //calls on the print tree method
    friend std::ostream &operator<<(std::ostream &output, SearchTree &tree);

    //used for importing our dictionary file
    friend void operator>>(std::istream &input, SearchTree &tree);


public:
    //both used in search tree object as an abstracted methods
    void insert(std::string word);

    bool search(std::string &word);
};


#endif //ASSIGNMENT_3_SEARCHTREE_H

//
// Created by nick on 11/5/2023.
//
#include "SearchTree.h"

using namespace std;

void SearchTree::insert(string word) {
    m_root = insert(word, m_root);
}

Node *SearchTree::insert(string word, Node *&node) {

    //if the current node reference is null, create a new node
    if (node == nullptr) {
        //end of our recursive function
        node = new Node();
        node->m_data = word;
        return node;
    } else if (word > node->m_data) {
        //insert to the right of the current node
        node->m_right = insert(word, node->m_right);
    } else if (word < node->m_data) {
        //insert to the left of the current node
        node->m_left = insert(word, node->m_left);
    } else {
        //duplicate word, disregard
        cout << "Word" << node->m_data << "already exists" << endl;
        return node;
    }

    update_height(node);

    //balance the tree
    return balance(node, word);


}


Node *SearchTree::balance(Node *&node, string &word) {

    //grab the balance factor
    int bf = balance_factor(node);
    //check for imbalances in the tree
    if (bf > 1) {
        //left imbalance
        if (word < node->m_left->m_data) {
            return right_rotate(node);
        } else {
            //left right imbalance
            node->m_left = left_rotate(node->m_left);
            return right_rotate(node);
        }
    }
    if (bf < -1) {
        //right imbalance
        if (word < node->m_right->m_data) {
            node->m_right = right_rotate(node->m_right);
            return left_rotate(node);
        } else {
            return left_rotate(node);
        }
    }

    return node;
}

Node *SearchTree::left_rotate(Node *node) {
    //grab the first right child, to be moved to where the selected node is now
    Node *y = node->m_right;
    //grab its left child
    Node *t2 = y->m_left;
    //move the original node underneath the y node
    y->m_left = node;
    //reattach the t2 underneath our moved node which is under the root to the left
    node->m_right = t2;
    //update the heights of the effected nodes
    update_height(node);
    update_height(y);
    //return the subtrees new root
    return y;
}


Node *SearchTree::right_rotate(Node *node) {
    //grab the left child of the node we want to rotate
    Node *x = node->m_left;
    //grab its child which will be reattached to our rotated node
    Node *t2 = x->m_right;
    //move the selected node underneath x
    x->m_right = node;
    //reattach t2 to be under our rotated node
    node->m_left = t2;
    //update the heights of the effected nodes
    update_height(node);
    update_height(x);
    //return the subtrees new root
    return x;
}


bool SearchTree::search(std::string &word) {
    //use the inner search method to attempt to find the selected word
    return search(m_root, word);
}

bool SearchTree::search(Node *&node, string word) {

    if (node == nullptr) {
        //end of tree with no word found, end of recursion
        return false;
    }

    if (word == node->m_data) {
        //word found in tree, end of recursion
        return true;
    } else if (word < node->m_data) {
        //if word is higher in the alphabet than the current node, check the nodes left child
        return search(node->m_left, word);
    } else {
        //if word is lower in the alphabet than the current node, check the nodes left child
        return search(node->m_right, word);
    }
}


int SearchTree::balance_factor(Node *node) {
    //if node exists, return the difference between its left and right children's heights
    if (node == nullptr) return 0;
    return height(node->m_left) - height(node->m_right);
}


void SearchTree::update_height(Node *node) {
    //set the new nodes m_height to 1 more than the highest child node
    if (node != nullptr) node->m_height = 1 + max(height(node->m_left), height(node->m_right));
}

int SearchTree::height(Node *node) {
    //if node is null return 0, else return its height
    return node == nullptr ? 0 : node->m_height;
}

ostream &SearchTree::print_tree(ostream &output, Node *root, string indent, bool last) {
    //recursive function to the end of the search tree, once it hits nullptr, recursion ends
    if (root != nullptr) {
        output << indent;
        if (last) {
            output << "R----";
            indent += "   ";
        } else {
            output << "L----";
            indent += "|  ";
        }
        output << root->m_data << root->m_height << endl;
        print_tree(output, root->m_left, indent, false);
        print_tree(output, root->m_right, indent, true);
    }

    return output;
}


void operator>>(std::istream &input, SearchTree &tree) {
    string word;
    //while the file is not empty, add each word to the dictionary tree
    while (!input.eof()) {
        getline(input, word);
        tree.insert(word);
    }
}


std::ostream &operator<<(std::ostream &output, SearchTree &tree) {
    //start the recursive print. returns the file output stream returned from the print method
    return tree.print_tree(output, tree.m_root, "", true);
}

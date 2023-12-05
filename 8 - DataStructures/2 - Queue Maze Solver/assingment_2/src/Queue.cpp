//
// Created by nick on 10/15/2023.
//

#include "Queue.h"


Queue::Queue(int y_position, int x_position) {
    //add the first node to the queue which will hold directions to the starting tile y=1, x=0.
    this->add_node(y_position, x_position);
}


void Queue::add_node(int y_position, int x_position) {
    //create new node and assign its position according to the target y and x.
    auto new_node = new PositionNode;
    new_node->m_y_position = y_position;
    new_node->m_x_position = x_position;

    //check if the queue is empty.
    if (first_node == nullptr) {
        this->first_node = new_node;
    } else {
        //if not, add to the end of the queue.
        if (this->last_node != nullptr) {
            this->last_node->next_node = new_node;
        }
    }

    //mark the newest node as the last node in the queue.
    this->last_node = new_node;
}


void Queue::pop() {

    //check to see if the queue is empty.
    if (first_node != nullptr) {
        //disconnect the node from the queue.
        auto node_to_delete = first_node;

        //check if this node is the only one in the queue.
        if (first_node == last_node) {
            last_node = nullptr;
        }

        //since we're deleting from the front of the queue, move the next node forward.
        first_node = node_to_delete->next_node;

        //delete the disconnected node from memory.
        delete node_to_delete;
    }
}

Queue::PositionNode Queue::peek() {
    //grab the reference to the first node of the queue.
    return *first_node;
}

bool Queue::is_empty() {
    //if the first node is null, return true.
    return first_node == nullptr;
}

void Queue::empty_queue() {
    //delete the first node in the queue until the queue is empty.
    while (!this->is_empty()) {
        this->pop();
    }
}

Queue::~Queue() {
    empty_queue();
}

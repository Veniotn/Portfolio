//
// Created by nick on 10/15/2023.
//

#ifndef ASSIGNMENT_2_QUEUE_H
#define ASSIGNMENT_2_QUEUE_H


class Queue {
    //Position nodes represent directions to maze tiles.
    struct PositionNode {
        int m_x_position{-1};
        int m_y_position{-1};
        PositionNode *next_node{nullptr};
    };

private:
    //first and last node in the queue.
    PositionNode *first_node{nullptr};
    PositionNode *last_node{nullptr};

    //deletes all the nodes from memory.
    void empty_queue();

public:
    //give queue our first direction node.
    Queue(int x_position, int y_position);

    //add directions to next tile to queue.
    void add_node(int y_position, int x_position);

    //if the queue is empty, we are out of tiles to search.
    bool is_empty();

    //delete the queue node after getting directions to next tile.
    void pop();

    //grabs the position node at the beginning of the queue.
    PositionNode peek();

    //destructor for our queue.
    virtual ~Queue();
};


#endif //ASSIGNMENT_2_QUEUE_H

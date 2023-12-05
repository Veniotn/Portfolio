//
// Created by nick on 10/11/2023.
//

#ifndef INC_2_MAZE_H
#define INC_2_MAZE_H
#include "Queue.h"
#include "FileOperator.h"

class Maze {
    //Tiles represent indexes in our maze array.
    struct Tile {
        int m_y_position{-1};
        int m_x_position{-1};
        char m_character{'\0'};
        bool m_visited{false};
        Tile *m_previous_tile{nullptr};
    };

private:

    //first tile the maze will start from will always be y=1 x=0.
    const int M_STARTING_Y_POSITION = 1;
    const int M_STARTING_X_POSITION = 0;

    //the last empty tile in the maze before the exit.
    const int M_MAZE_END_Y_POSITION = 49;
    const int M_MAZE_END_X_POSITION = 50;

    //empty space is for finding valid tiles when we search the maze and path marker is for when we mark the best path.
    const char M_EMPTY_SPACE = ' ';
    const char M_PATH_MARKER = '#';

    //if this is still false when the solve method ends, don't output the maze array.
    bool m_solution_found{false};

    //compiler needs to know the size of the array at runtime for all possible instances of the maze class,
    //so we make these static to guarantee they will never change.
    static const int M_ROWS = 51;
    static const int M_COLUMNS = 52;

    //array that holds all the maze tiles, the starting tile which will always be y=1 x=0 and the tile found before
    //the exit of the maze.
    Tile m_maze_array[M_ROWS][M_COLUMNS];
    Tile *m_starting_tile{nullptr};
    Tile *m_end_tile{nullptr};

    //holds input and output file.
    FileOperator *m_maze_file_operator{nullptr};

    //traverses through the maze finding every empty space until it reaches the end, then calls find_best_path.
    void solve();

    //checks if the current tile is inside the maze.
    bool is_inside_maze(int x, int y);

    //checks if the current tile is an empty space.
    bool is_valid_target(Tile *tile);

    //finds the quickest path through the maze.
    void find_best_path();

    //outputs the maze to the console and to the output file.
    friend std::ostream &operator<<(std::ostream &output, Maze &maze);

public:

    //Fills maze array using the contents of the input file.
    Maze(FileOperator &file_operator);

    bool get_solution_found();

    //Queue of nodes that hold directions to valid tiles.
    Queue m_position_nodes{M_STARTING_Y_POSITION, M_STARTING_X_POSITION};



};

#endif //INC_2_MAZE_H

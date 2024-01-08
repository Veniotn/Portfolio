//
// Created by nick on 10/11/2023.
//
#include "Maze.h"

using namespace std;

Maze::Maze(FileOperator &file_operator) {

    //file_operator will hold both the input maze file and the file to output the solution to.
    m_maze_file_operator = &file_operator;

    //if the file opens correctly, fill in maze array with file contents.
    if (m_maze_file_operator->get_in_file().is_open() && !m_maze_file_operator->get_in_file().fail()) {

        //character is the current character from the text file.
        char character;
        //Tiles represent indexes in the maze array.
        Tile *current_tile;

        //scan the text file and add every character into the maze array.
        for (int y_position = 0; y_position < M_ROWS; y_position++) {
            for (int x_position = 0; x_position < M_COLUMNS; x_position++) {
                //get character from file.
                m_maze_file_operator->get_in_file().get(character);
                //assign the current tile to wherever we are in the maze array.
                current_tile = &m_maze_array[y_position][x_position];
                //assign the properties of the current tile.
                current_tile->m_character = character;
                current_tile->m_x_position = x_position;
                current_tile->m_y_position = y_position;
                //clear the character variable.
                character = M_EMPTY_SPACE;
            }
        }
        //close the input file.
        m_maze_file_operator->get_in_file().close();
        //point the starting tile to the first empty index of our maze array which should always be y=1 x=0.
        m_starting_tile = &m_maze_array[M_STARTING_Y_POSITION][M_STARTING_X_POSITION];
        //attempt to solve maze
        solve();
    }
}


void Maze::solve() {

    //this method will search for every empty space available in the maze until it either hits the exit or runs out
    //of spaces to check, if it runs out of spaces to check before hitting the exit no solution has been found.
    int current_x, current_y, target_y, target_x;

    //while our queue has directional nodes
    while (!m_position_nodes.is_empty()) {

        //grab the node at the front of the queue then remove it from the queue.
        auto current_location = m_position_nodes.peek();
        m_position_nodes.pop();

        //get the current tiles x,y from the position node then grab the tile from the maze.
        current_x = current_location.m_x_position;
        current_y = current_location.m_y_position;
        Tile *current_tile = &m_maze_array[current_y][current_x];

        //check if we've reached the exit of the maze
        if (current_y == M_MAZE_END_Y_POSITION && current_x == M_MAZE_END_X_POSITION) {
            m_solution_found = true;
            //set the end tile to be whenever we are right now than find the most efficient path.
            m_end_tile = current_tile;
            find_best_path();
            return;
        }

        //search for valid locations around us
        //diagram:    y
        //           [-1]
        //      x[-1][0][1]
        //           [1]
        int x_directions[] = {1, -1, 0, 0};
        int y_directions[] = {0, 0, 1, -1};

        for (int current_direction = 0; current_direction < 4; current_direction++) {
            //grab the first tile in the direction we are searching.
            target_x = current_x + x_directions[current_direction];
            target_y = current_y + y_directions[current_direction];
            Tile *target_tile = &m_maze_array[target_y][target_x];

            //if the current tile is a valid space inside the maze and hasn't been visited yet,
            //add its location to the queue.
            if (is_valid_target(target_tile)) {
                //link the tile we started on to the tile we are moving toward.
                target_tile->m_visited = true;
                target_tile->m_previous_tile = current_tile;
                //add the directions to our target tile to our nodes queue.
                m_position_nodes.add_node(target_y, target_x);
            }
        }
    }
}

void Maze::find_best_path() {

    //grab the last tile
    auto current_tile = m_end_tile;
    cout << "\n\nSolution:" << endl;

    //traces the best path from the exit back to the entrance of the maze
    //starting from the end tile, it follows the path marked by previous tiles
    //to the entrance, marking each tile with the path marker character
    while (current_tile != nullptr) {
        current_tile->m_character = M_PATH_MARKER;
        //if we've returned to the beginning of the maze, break out of the loop.
        if (current_tile == m_starting_tile) {
            break;
        }
        current_tile = current_tile->m_previous_tile;
    }
}

bool Maze::is_inside_maze(int y, int x) {
    //if current y or x are outside the bounds of the array, ignore them.
    return (y > 0 && y < M_ROWS) && (x >= 0 && x < M_COLUMNS);
}

bool Maze::is_valid_target(Tile *tile) {
    //if the tile is a valid space inside the maze and hasn't been visited yet return true.
    return (tile->m_character == M_EMPTY_SPACE && !tile->m_visited) &&
           (is_inside_maze(tile->m_y_position, tile->m_x_position));
}

ostream &operator<<(ostream &output, Maze &maze) {
    //go through every maze array index and add its character to the output stream.
    for (int y_position = 0; y_position < Maze::M_ROWS; y_position++) {
        for (int x_position = 0; x_position < Maze::M_COLUMNS; x_position++) {
            output << maze.m_maze_array[y_position][x_position].m_character;
        }
    }

    return output;
}


bool Maze::get_solution_found() {
    return m_solution_found;
}

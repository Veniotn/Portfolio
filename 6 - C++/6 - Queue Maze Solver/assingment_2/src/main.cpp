#include <iostream>
#include "Maze.h"
using namespace std;

int main(int argc, char *argv[]) {
    //validate argument count.
    if (argc != 3) {
        cout << "Invalid argument count." << endl;
        return -1;
    }
    //attempt to create file operator with argv[1] and argv[2] which should hold our desired file names.
    FileOperator maze_file_operator(argv[1], argv[2]);

    //if the in file is null it means one of the two file names were invalid.
    if (!maze_file_operator.get_in_file().is_open()) {
        cout << "Invalid file name." << endl;
        return -1;
    }

    // create maze, and attempt to solve it.
    Maze main_maze(maze_file_operator);

    //if we go through every node before we find the exit, no solution has been found.
    if (!main_maze.get_solution_found()){
       cout << "No solution found or invalid maze file." << endl;
       return -1;
    }

    //if a solution was found, output the solution.
    cout << main_maze << endl;

    //save the solution to the output file.
    maze_file_operator.get_out_file() << main_maze;
    maze_file_operator.get_out_file().close();

    return 0;
}

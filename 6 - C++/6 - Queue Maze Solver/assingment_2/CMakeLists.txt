cmake_minimum_required(VERSION 3.17)
project(Assignment_2)

set(CMAKE_CXX_STANDARD 14)

set(CMAKE_CXX_FLAGS "-static")

add_executable(Assignment_2
        src/main.cpp
        src/Maze.cpp
        src/Queue.h
        src/Queue.cpp
        src/FileOperator.cpp)

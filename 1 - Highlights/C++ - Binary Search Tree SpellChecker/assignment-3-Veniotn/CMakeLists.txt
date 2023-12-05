cmake_minimum_required(VERSION 3.17)
project(Assignment_3)

set(CMAKE_CXX_STANDARD 14)

set(CMAKE_CXX_FLAGS "-static")

add_executable(Assignment_3
        src/main.cpp
        src/SearchTree.cpp
        src/SpellChecker.h
        src/SpellChecker.cpp)

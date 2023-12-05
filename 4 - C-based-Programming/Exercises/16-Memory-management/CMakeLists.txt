cmake_minimum_required(VERSION 3.21)
project(EX16 C)

set(CMAKE_C_STANDARD 17)

add_executable(EX16 src/main.c inc/arrayOps.h src/arrayOps.c)

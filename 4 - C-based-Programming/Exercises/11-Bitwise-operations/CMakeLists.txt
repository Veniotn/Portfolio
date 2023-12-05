cmake_minimum_required(VERSION 3.21)
project(EX11 C)

set(CMAKE_C_STANDARD 17)

add_executable(EX11 src/main.c inc/binOps.h src/binOps.c)

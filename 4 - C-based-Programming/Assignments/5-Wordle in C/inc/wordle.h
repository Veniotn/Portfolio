//
// Created by nick on 12/7/2022.
//
#ifndef ASSIGN5_WORDLE_H
#define ASSIGN5_WORDLE_H

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdbool.h>
//#include "../src/wordle.c"



void defaultState(char **pString, int guesses, int size);
int printCurrentState(char ** board, int guesses, int wordSize,char* word,int matches,int currentGuess);
char* guessToUpper(char* word, int wordSize);
void validGuess(char* guess,int wordSize);
void writeToFile(char** wordleTable, FILE* outputFile, int guesses, int wordSize,char* headerMessage);

#endif //ASSIGN5_WORDLE_H

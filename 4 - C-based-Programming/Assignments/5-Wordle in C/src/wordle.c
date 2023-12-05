//
// Created by nick on 12/7/2022.
//



#include "../inc/wordle.h"


void defaultState(char** board, int guesses, int wordSize)
{
    for (int row = 0; row < guesses; row++)
    {
        for (int currentLetter = 0; currentLetter < wordSize; currentLetter++)
        {
            board[row][currentLetter] = '-';  //fill the array with the base characters
        }
    }

    for (int i = 0; i < guesses; i++)
    {
        printf("\n");
        printf("\033[0m");
        for (int j = 0; j < wordSize; j++)
        {
            printf("%c ", board[i][j]);
        }
    }
}

void validGuess(char* guess, int wordSize)
{
    bool validGuess = false;
    int validChars;
    while (!validGuess)
    {
        validChars=0;
        printf("\n\nPlease enter a %d letter word:",wordSize);
        scanf(" %[^'\n']s",guess);

        for(int letter = 0; letter < wordSize; letter++)
        {
            if(isdigit(guess[letter]))
            {
                continue;   //if it's a digit or null do not add to validChars
            }
            else
            {
                validChars++;
            }
        }

        if(validChars == wordSize && strlen(guess) == wordSize)
        {
            validGuess = true;
        }
        else
        {
            printf("Sorry, but you can only enter %d-letter words.",wordSize);//if they enter too little or too many characters or invalid characters prompt and continue the while loop
        }
    }
}

char* guessToUpper(char* guess, int wordSize)
{
   for(int currentLetter = 0; currentLetter < wordSize; currentLetter++)
   {
       guess[currentLetter] = toupper(guess[currentLetter]);    //since we know its valid input before we pass it to this function we should be able to convert it to uppercase no problem.
   }

    return guess;
}

int printCurrentState(char ** board, int guesses, int wordSize,char* word,int matches, int currentGuess)
{
    matches=0;
    for (int row = 0; row < guesses; row++)
    {
        printf("\n");
        for (int currentLetter = 0; currentLetter < wordSize; currentLetter++)
        {
            if(board[row][currentLetter] == word[currentLetter] && board[row][currentLetter] != '-')    // if the current letter is in the right space it's not a - make it green and print the letter
            {
                if(row == currentGuess)
                {
                    matches++;
                }
                printf("\033[0;32m");   //green
                printf("%c ", board[row][currentLetter]);
                printf("\033[0m");      //reset back to grey.
            }
            else
            {
                //strchr looks to find if the word contains any letters from the guess
                if(board[row][currentLetter] != '-' && strchr(word, board[row][currentLetter]) != NULL)
                {
                    printf("\033[0;33m"); //make it yellow.
                    printf("%c ", board[row][currentLetter]);
                    printf("\033[0m");    //reset.
                }
                else
                {
                    printf("\033[0m");//reset
                    printf("%c ",board[row][currentLetter]);
                }
            }
        }
    }

    return matches;
}

void writeToFile(char** wordleTable,FILE* outputFile, int guesses, int wordSize, char* headerMessage)
{
    fputs(headerMessage,outputFile);
    for(int row = 0; row < guesses; row++)
    {
        putc('\n', outputFile);
        for (int currentLetter = 0; currentLetter < wordSize; currentLetter++)
        {
            putc(wordleTable[row][currentLetter], outputFile);
        }
    }
}

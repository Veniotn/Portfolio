#include <stdio.h>
#include <stdlib.h>
#include "../inc/wordle.h"


/*
 * NOTE: Follow this example to use ANSI colours at the terminal:
 * https://www.theurbanpenguin.com/4184-2/
 *
 * In order to get ANSI colors showing in the CLion Run Console,
 * we need to do the following routine:
 *
 * 1. Choose Help -> Edit Custom Properties from CLion menu
 * 2. Add the following line to the idea.properties file:
 *      run.processes.with.pty=false
 * 3. Restart CLion.
 *
 * Reference:
 * https://youtrack.jetbrains.com/issue/CPP-8395/Registry-setting-runprocesseswithpty-not-saved#focus=Comments-27-2499735.0-0
 *
 */

int main(int argc, char** argv)
{
    FILE *inputFile, *outputFile;
    int wordSize,guesses,matches=0,maxLine=10;
    char ruleInput[maxLine];
    char* inputFileName;
    char* outputFileName;
    char* headerMessage;
    char **wordleTable;

    //Validate command line arguments and collect the I/O file names
    if(argc != 5)
    {
        fprintf(stderr, "Invalid number of command line arguments.");
        return 1;
    }

    if (argv[1][0] == '-')
    {
        switch (argv[1][1])
        {
            case 'i':
                inputFileName = argv[2];
                break;
            case 'o':
                outputFileName = argv[2];
                break;
            default:
                fprintf(stderr, "Invalid command line argument usage.");
                return 1;
        }
    }
    else
    {
        fprintf(stderr, "Invalid command line argument usage.");
    }

   if(argv[3][0] == '-')
    {
        switch (argv[3][1])
        {
            case 'i':
                inputFileName = argv[4];
                break;
            case 'o':
                outputFileName = argv[4];
                break;
            default:
                fprintf(stderr, "Invalid command line argument usage.");
                return 1;
        }
    }
    else
    {
        fprintf(stderr,"Invalid command line argument usage.");
        return 1;
    }


    //open the files
    inputFile = fopen(inputFileName,"r");
    outputFile = fopen(outputFileName, "a");

    if(inputFile == NULL )
    {
        fprintf(stderr,"Cannot open %s for reading.\n", inputFileName);
        return 1;
    }
    else if(outputFile == NULL)
    {
        fprintf(stderr,"Cannot open %s for writing.\n", outputFileName);
        return 1;
    }


    for(int i=0; i< maxLine; i++)    //Read in the first line of the input file.
    {
        fscanf(inputFile,"%d", &ruleInput[i]);
    }

    wordSize = ruleInput[0] + 1;    //Add one for null terminator
    guesses = ruleInput[1];

    char word[wordSize];

    fgets(word, wordSize,inputFile);         //Scanning the next line for the word.
    wordSize--;         //No longer need to check for the null terminator after scanning the word in.

    wordleTable = malloc(guesses * sizeof *wordleTable);  //allocate the 2d arrays memory
    for (int i=0; i<guesses; i++)
    {
        wordleTable[i] = malloc(wordSize * sizeof(*wordleTable[i])); //allocate memory for every column in the array
    }


    setbuf(stdout, NULL);

    char guess[wordSize];   //Players guess each round
    int currentGuess = 0;


    printf("Welcome to C-Wordle!!\n\nCurrent game state:");
    defaultState(wordleTable,guesses,wordSize);//Create a blank slate and start the game
    do
    {
        validGuess(guess, wordSize);//takes input and also makes sure its valid
        guessToUpper(guess,wordSize);

        for(int letter=0; letter<wordSize; letter++)
        {
            wordleTable[currentGuess][letter] = guess[letter];  //Fill the current row with the guess.
        }
        //Process the guess for matches, print the guess to the table and end the turn.
        matches = printCurrentState(wordleTable,guesses,wordSize,word,matches,currentGuess);
        currentGuess++;
    }
    while (currentGuess < guesses && matches != wordSize);

    //Check win condition.
    if(matches == wordSize)
    {
        headerMessage = "The solution was found.";
        writeToFile(wordleTable, outputFile, guesses, wordSize, headerMessage);
        printf("\nYou WIN!!!\nThe game result was written to the %s file.",outputFileName);
    }
    else
    {
        headerMessage = "The solution was not found.";
        writeToFile(wordleTable, outputFile, guesses, wordSize, headerMessage);
        printf("\nYou LOSE!!!\nThe game result was written to the %s file.", outputFileName);
    }

    //Free the memory!!
    for(int i=0; i<guesses; i++)
    {
        free(wordleTable[i]);
    }
    free(wordleTable);

    //Close the files.
    fclose(inputFile);
    fclose(outputFile);

    //Exit the program.
    return 0;
}

#include "../inc/fileOps.h"

int writeAppendToFile(char *filePath, char *inMessage, bool append){
    FILE *outputFile;

    outputFile = !append ? fopen(filePath, "w") : fopen(filePath, "a");//checking for the desired mode (write or append).

    if(outputFile == NULL)//if file doesn't exist, print an error and exit the program.
    {
        fprintf(stderr, "Could not open file for writing/appending!");
        return 1;
    }
    while (*inMessage!='\0')//if the file exits, write each letter of the message to the output file until the string is null.
    {
        fputc(*inMessage, outputFile);
        inMessage++;
    }
    fputs("\n", outputFile);//add a mew line for any future appends.

    printf("File written.");

    fclose(outputFile);//close the file.
    return 0;
};

int readFromFile(char *filePath)
{
    FILE *inputFile;
    inputFile = fopen(filePath, "r"); //attempt to open the input file in read mode.
    int i;

    if(inputFile==NULL)//if the file doesn't exist, print an error and terminate the program.
    {
        fprintf(stderr, "Could not open file for reading.");
        return 1;
    }
    printf("File read. Contents:");
    while ((i = getc(inputFile)) != EOF)//if the end of the file has not been reached, set i to the next character of the input file
    {
        printf("%c",i);//print each letter of the input file to the console
    }

    fclose(inputFile);//close the file
    return 0;
}

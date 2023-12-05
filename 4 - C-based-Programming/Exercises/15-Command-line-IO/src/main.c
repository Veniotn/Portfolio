#include <stdio.h>

#include "../inc/fileOps.h"

int main(int argc, char *argv[]) { //checks for invalid number of arguments.
    if(argc < 3 || argc > 4)
    {
        fprintf(stderr,"Invalid number of command line arguments. ");
        return 1;
    }
    //message to write
    char *message = argv[3];

    if(argv[1][0] == '-')//check the first character of the first argument
    {

        switch (argv[1][1])//check the second character of the first argument
        {
            case 'w':
                return writeAppendToFile(argv[2],message,false);
            case 'a':
                return writeAppendToFile(argv[2],message,true);
            case 'r':
                return readFromFile(argv[2]);
            default:
                fprintf(stderr, "Invalid command line argument usage.");
                return 1;
        }

    }



    return 0;
}

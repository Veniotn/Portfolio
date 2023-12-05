#include <stdio.h>

#include "../inc/arrayOps.h"
#include <stdlib.h>

int main(int argc, char *argv[]) {

    setbuf(stdout,0);

    // IMPLEMENT FUNCTION
    // MAKE SURE TO PROCESS COMMAND LINE ARGUMENTS HERE
    // MAKE SURE TO DYNAMICALLY ALLOCATE MEMORY FOR SPECIFIED ARRAY SIZE
    // MAKE SURE TO RELEASE THE MEMORY PROPERLY WHEN DONE
    if(argc!=3)
    {
        printf("Sorry, bad number of command line arguments.");

        return 1;
    }

    const int SIZE = atoi(argv[2]); // declared after we check if they've ran the program correctly.
    int numArray[SIZE];

    if(argv[1][0] == '-')
    {
        switch (argv[1][1])
        {
            case 's':
                printf("\nThe result is %.1f.", processArray(SUM,SIZE,numArray));
                break;
            case 'a':
                printf("The result is %.1f.", processArray(AVERAGE,SIZE,numArray));
                break;
            case 'm':
                if(argv[1][2] == 'x')
                {
                    printf("The result is %.1f.", processArray(MAX,SIZE,numArray));
                    break;
                } else if(argv[1][2]=='n')
                {
                    printf("The result is %.1f.", processArray(MIN,SIZE,numArray));
                    break;
                } else
                {
                    printf("Sorry, bad operator.");
                    return 1;
                }
            default:
                printf("Sorry, bad operator.");

                return 1;
        }
    }

    free(argv[2]);//free the memory after we're done with it.
    return 0;
}

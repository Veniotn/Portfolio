#include <stdio.h>
#include <stdlib.h>

#include "../inc/calculator.h"

int main(int argc, char *argv[]) {

    if(argc < 4 || argc > 4){
        printf("Sorry, bad number of command line arguments.");

        return 1;
    }

    if(argv[1][0] == '-'){
        switch (argv[1][1]) {
            case 'a':
                printf("The result is %.3f.",calculateResult(ADDITION,atoi(argv[2]), atoi(argv[3])));
                break;
            case 's':
                printf("The result is %.3f.",calculateResult(SUBTRACTION,atoi(argv[2]), atoi(argv[3])));
                break;
            case 'm':
                printf("The result is %.3f.",calculateResult(MULTIPLICATION,atoi(argv[2]), atoi(argv[3])));
                break;
            case 'd':
                printf("The result is %.3f.",calculateResult(DIVISION,atoi(argv[2]), atoi(argv[3])));
                break;
            case 'p':
                printf("The result is %.3f.",calculateResult(POWER,atoi(argv[2]), atoi(argv[3])));
                break;
            default:
                printf("Sorry, bad operator.");
                return 1;
        }
    }


    return 0;
}

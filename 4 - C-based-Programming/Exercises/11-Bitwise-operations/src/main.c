#include <stdio.h>
#include "../inc/binOps.h"
#include <stdbool.h>

#define NUMBITS 32

int main() {
    int num,num2=0,shiftAmount, result;
    char operator[3];
    char binaryString[NUMBITS];
    // TODO: Ask the user to enter a positive unsigned integers
    do {
        printf("Please enter a positive integer value: \n");
        scanf("%d", &num);
    } while (num <=0);

    //ask user for an operator
    printf("Please enter an operator (&, |, ^, <<, >>) :\n");
    scanf("%s", operator);

    // TODO: If they entered an operator that requires a second number, ask for one
    if(operator[0] == '|' || operator[0] == '&' || operator[0] == '^')
    {
        do
        {
            printf("Please enter another positive integer value: \n");
            scanf("%d", &num2);
        } while (num <=0);
    } else if((operator[0] == '<' && operator[1] == '<') || (operator[0] == '>' && operator[1] == '>'))          // TODO: If they entered a shift operator, ask how many places to shift
    {
        do
        {
            printf("Please enter the number of spaces to shift the bits\n");
            scanf("%d", &shiftAmount);
        }while (shiftAmount <=0);
    }else
    {
        // TODO: if they entered a wrong operator, print an error and return 1
        printf("Sorry, bad operator.");
        return 1;
    }


    // TODO: Perform the requested operation if valid
    if(operator[0] == '<' && operator[1] == '<')
    {
        result = num << shiftAmount;
    }
    else if(operator[0] == '>' && operator[1] == '>')
    {
        result = num >> shiftAmount;
    } else{
        switch (operator[0])
        {
            case '&':
                result = num & num2;
                break;
            case '|':
                result = num | num2;
                break;
            case '^':
                result = num ^ num2;
                break;
            default:
                printf("Oops");
                return 1;
        }
    }
    getBinary(result, NUMBITS, binaryString);
    printf("The result is: %s - %d", binaryString, result);

    // TODO: Use the provided function to show the result in text

    return 0;
}

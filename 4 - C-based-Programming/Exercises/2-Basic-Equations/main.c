#include <stdio.h>
//test
/*
    Using the program in example 2.6 (page 18) of the textbook as a guide
    create a program that stores the values 50 and 25 in two variables
    and outputs the result of adding, subtracting,  multiplying , and dividing them.

    Desired output:
        The sum of 50 and 25 is 75
        The difference of 50 and 25 is 25
        The product of 50 and 25 is 1250
        The result of dividing 50 by 25 is 2

    Then, uncomment and fix the indicated block of code.

    Desired output:
        The answer is 43
*/

int main() {

    int a = 50;
    int b = 25;
    int sum = a + b;
    int difference = a - b;
    int product = a * b;
    int division = a / b;
    printf("The sum of %i and %i is %i\n", a,b,sum);
    printf("The difference of %i and %i is %i\n", a,b,difference);
    printf("The product of %i and %i is %i\n", a,b,product);
    printf("The result of dividing %i by %i is %i\n", a,b,division);


//     SELECT FOLLOWING 5 LINES OF CODE, USE CRTL+/ TO UNCOMMENT, FIX THIS BLOCK OF CODE
    int total;
    //COMPUTE RESULT
    total = (25 + 37) - 19;
    //DISPLAY RESULTS
    printf ("The answer is %i\n", total);


    return 0;
}

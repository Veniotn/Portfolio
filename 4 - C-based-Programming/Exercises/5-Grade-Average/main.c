#include <stdio.h>
#include <math.h>

int main() {
    setbuf(stdout, 0);
    // ENTER YOUR CODE HERE
    const int ARRAY_SIZE = 6;
    float gradeSum,average;
    float grades[ARRAY_SIZE];
    int gradeToCheck;
    for(int i=0; i<ARRAY_SIZE; i++)
    {
        printf("Please enter Grade %i:\n", i+1);
        scanf("%f", &grades[i]);
        float gradeTest = grades[i];
        printf("Grade test : %f", gradeTest);
        if(grades[i] < 0)
        {
            printf("You cannot enter negative grades.");
            return 1;
        }
        else if(grades[i] > 100)
        {
            printf("You cannot enter grades above 100.");
            return 1;
        }

    }
    gradeSum = 0;
    for(int i=0; i<ARRAY_SIZE; i++)
    {
        gradeSum += grades[i];
    }

    average = gradeSum / ARRAY_SIZE;
    printf("\nYour average for the term is: %.1f", average);

    printf("\nWhich grade do you want to look up?");
    scanf("%i",&gradeToCheck);
    printf("\nGrade %i: %.0f\n",gradeToCheck, grades[gradeToCheck-1]);

    return 0;
}

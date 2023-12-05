// Assignment #2 - Starter Files

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include "../inc/leapyear.h"
#include <ctype.h>

int main() {
    int yearNum, startYear, endYear, yearCap, centuryCap; //year converted from string to int, first year of each century, last year of each century, present year, present century
    char year[4]; //used to store the year input from user
    bool exit = false;
    printf("Leap Checker!\n");
    while (!exit){
        setbuf(stdout,0);
        printf("\nPlease enter the year to check('N' to quit): ");
        scanf("%s",year);
        char checkForExit = tolower(year[0]);//takes the first char
        if(checkForExit =='n' && year[1]=='\0'){ // If user enters n and n only the program will exit and print the century report
            exit = true;
        }
        else{
            yearNum = atoi(year); //atoi changes string to integer, if it detects a letter it returns 0
            if(yearNum <= 0){
                printf("Sorry that input is invalid..\n");
            }
            else{
                if(leapYearCheck(yearNum) == 0){
                    printf("%i IS NOT a leap year!\n", yearNum);
                }
                else{
                    printf("%i IS a leap year!\n", yearNum);
                }
            }
        }
    }
    //Nick Veniot W0404614 0/09/2022
    printf("Quitting.. \n \nTHE LEAP YEARS FOR CENTURY REPORT:\n");
    startYear = 1;
    endYear = 100;
    centuryCap = 21;
    for(int century = 1; century<centuryCap; century++) {
        printf("\nCentury #%i: ", century);
        for (int i = startYear; i <= endYear; i++) {
            if(leapYearCheck(i) == true){
                printf("%3i ",i);
            }
        }
        startYear = endYear + 1;
        endYear = endYear + 100;
        printf("\n");
    }

    //since we only need to go up to 2022 in the 21st century we will just do it in its own for-loop to keep the previous code clean
    yearCap = 2022;
    printf("\nCentury #21: ");
    for(int i = 2004; i<=yearCap; i++){
        if(leapYearCheck(i)==true){
            printf("%3i ",i);
        }
    }

}

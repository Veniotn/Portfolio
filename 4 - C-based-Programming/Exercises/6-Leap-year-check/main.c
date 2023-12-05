#include <stdio.h>
#include <stdbool.h>
#include <string.h>

/*
 * First take the code from our leap.c sample file in the Resources for the Making Decisions
 * lecture and refactor it into a function that returns true or false if a passed in year
 * is a leap year or not. Call it from the main function to make sure it works.
 *
 * Then create a new function that takes in the year and a numeric code for a month, i.e. 1 = January,
 * 2 = February, and so forth. Have it return the number of days in that month. Make sure to make
 * use of your new leap year function so you can correctly tell if February has 28 or 29 days that
 * year.
 *
 * Also, return a message of "Bad year" if a year between 1 and 9999 not entered and return 1 error code.
 * Return a message of "Bad month" if a month between 1 and 12 not entered and return 1 error code.
 *
 * NOTE: This would be a great job for a switch-case statement!!
 * REMINDER: "30 days has September, April, June, and November".
 */

// ADD NEW FUNCTIONS HERE

bool leapYearCheck(int year);
char* yearCheck(int year, int month);

int main() {
    char result [27]; // max size of the string
    int year,month;
    printf("Please enter the year: ");
    scanf("%d", &year);
    if(year < 1 || year > 9999)
    {
        printf("Bad year");
        return 1;
    }
    printf("\nPlease enter the month: ");
    scanf("%d", &month);
    if(month < 1 || month > 12)
    {
        printf("Bad month");
        return 1;
    }
    strcpy(result, yearCheck(year, month));
    printf("%s", result);
    return 0;

}

char* yearCheck(int year, int month) {
    if(leapYearCheck(year) == 1)
    {
        switch (month) {
            case 1:
                return "That month has/had 31 days.";
                break;
            case 2:
                return "That month has/had 29 days.";
                break;
            case 3:
                return "That month has/had 31 days.";
                break;
            case 4:
                return "That month has/had 30 days.";
                break;
            case 5:
                return "That month has/had 31 days.";
                break;
            case 6:
                return "That month has/had 30 days.";
                break;
            case 7:
                return "That month has/had 31 days.";
                break;
            case 8:
                return "That month has/had 31 days.";
                break;
            case 9:
                return "That month has/had 30 days.";
                break;
            case 10:
                return "That month has/had 31 days";
                break;
            case 11:
                return "That month has/had 30 days.";
                break;
            case 12:
                return "That month has/had 31 days.";
                break;
            default:
                return "error";
                break;
        }
    }
    else{
        switch (month) {
            case 1:
                return "That month has/had 31 days.";
                break;
            case 2:
                return "That month has/had 28 days.";
                break;
            case 3:
                return "That month has/had 31 days.";
                break;
            case 4:
                return "That month has/had 30 days.";
                break;
            case 5:
                return "That month has/had 31 days.";
                break;
            case 6:
                return "That month has/had 30 days.";
                break;
            case 7:
                return "That month has/had 31 days.";
                break;
            case 8:
                return "That month has/had 31 days.";
                break;
            case 9:
                return "That month has/had 30 days.";
                break;
            case 10:
                return "That month has/had 31 days";
                break;
            case 11:
                return "That month has/had 30 days.";
                break;
            case 12:
                return "That month has/had 31 days.";
                break;
            default:
                return "error";
                break;
        }
    }
}



bool leapYearCheck(int year) {
    int rem_4,rem_100, rem_400;
    rem_4 =year % 4;
    rem_100 = year % 100;
    rem_400 = year % 400;
    if ((rem_4 == 0 && rem_100 != 0) || rem_400 == 0) {
        return  true;
    }
    else {
        return false;
    }
}


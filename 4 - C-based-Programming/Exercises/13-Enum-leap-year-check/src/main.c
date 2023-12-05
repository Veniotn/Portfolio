#include <stdio.h>

#include "../inc/dates.h"

int main() {
     // max size of the string
     char* result;
    int year,month,leapCheck;

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

    leapCheck = IS_LEAP_YEAR(year);
    result = daysInMonth(leapCheck,month);
    printf("%s", result);


    return 0;
}




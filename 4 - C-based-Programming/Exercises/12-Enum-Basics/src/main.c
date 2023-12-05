#include <stdio.h>

#include "../inc/litreGallon.h"


int main() {
    float litres, gallons;

    printf("Please enter a number of litres:\n");
    scanf("%f",&litres);

    if(LOCALE == 1)
    {
        gallons = LITRE_TO_US_GALLON_CONVERT(litres);
    }
    else if(LOCALE == 2)
    {
        gallons = LITRE_TO_UK_GALLON_CONVERT(litres);
    }


    printf("\nThat is %.3f gallons.", gallons);

    return 0;
}


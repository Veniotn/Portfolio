#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
//
// Created by nick on 10/4/2022.

bool leapYearCheck(int year){
    //if divisible by 400 it is a leap year(year 2000,  year 400 etc.)
    if(year % 400 == 0){
        return true;
    }
    // if not divisible by 400 but divisible by 100 it is not a leap year
     else if(year % 100 == 0){
        return false;
    }
    // if neither of the above but divisible by 4 it is a leap year
    else if(year % 4 == 0){
        return true;
    }
    else{
        return false;  //everything else is not a leap year
    }
}


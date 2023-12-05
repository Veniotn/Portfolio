#include <stdbool.h>
#include "../inc/dates.h"

char* daysInMonth(int year, int month){
    if(year == 1 && month == FEBUARY) {
        return "That month has/had 29 days.";
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
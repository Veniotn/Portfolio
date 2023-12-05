#ifndef EX13_DATES_H
#define EX13_DATES_H



#define IS_LEAP_YEAR(year) year % 4 == 0 && year % 100 !=0 || year % 400 == 0
char* daysInMonth(int year, int month);

enum months{
    JANUARY = 1,
    FEBUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER
};



#endif //EX13_DATES_H

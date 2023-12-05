//
// Created by W0404614 on 2022-10-21.
//

#ifndef EX7_HIGHSCORES_H
#define EX7_HIGHSCORES_H

#include <stdio.h>


struct Date{
    int day;
    int month;
    int year;
};

struct Player{
    char name[16];
    int score;
    struct Date date;
};
void highScores(int playerCount, struct Player* players);
#endif //EX7_HIGHSCORES_H

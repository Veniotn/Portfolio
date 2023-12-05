//
// Created by W0404614 on 2022-10-21.
//

#include "../inc/highScores.h"

void highScores(int playerCount, struct Player *players){
    printf("\nHigh Scores\n");
    for(int i = 0; i <= playerCount; i++)
    {
        printf("\n%s   %i  %i/%i/%i", players[i].name, players[i].score,players[i].date.month,players[i].date.day, players[i].date.year);
    }
}

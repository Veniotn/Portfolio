#include <ctype.h>
#include <string.h>
#include "../inc/highScores.h"

int main() {
    int playerCount,i;
    int const MAX_ARRAY_SIZE = 5;
    struct Player players[MAX_ARRAY_SIZE];
    playerCount = 0;

    for(i=0; i < MAX_ARRAY_SIZE; i++){
        printf("\nEnter the player name (q to quit):");
        scanf("%s", players[i].name);
        if(strcmp(players[i].name,"q") == 0){
            //highScores(playerCount, &players);
            printf("test");
        }
        else{
            printf("\nEnter the score:");
            scanf("%i", &players[i].score);
            printf("\nEnter the month:");
            scanf("%i", &players[i].date.month);
            printf("\nEnter the day:");
            scanf("%i", &players[i].date.day);
            printf("\nEnter the year:");
            scanf("%i", &players[i].date.year);
            ++playerCount;
        }
    }
    printf("Quitting..");
    highScores(playerCount, players);

    return 0;
}

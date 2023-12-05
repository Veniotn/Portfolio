/*
 * We can calculate a baseball player's OBP (On-base plus Slugging) Percentage
 * using the following formula given here:
 * https://en.wikipedia.org/wiki/On-base_percentage#Overview
 *
 * We can calculate their SLG (Slugging Percentage) by the formula given here:
 * https://en.wikipedia.org/wiki/Slugging_percentage
 *
 * We can calculate their OPS (On-base Plus Slugging) by simply adding the OBP and SLG
 *
 * Use these variable values (MAKE SURE TO DECLARE THEM AS INT DATA TYPES):
 *      At-bats: 600
 *      Hits: 200
 *      Singles: 124
 *      Doubles: 40
 *      Triples 6
 *      Homeruns: 30
 *      Walks: 40
 *      Hit-by-Pitches: 5
 *      Sacrifice-Flies: 8
 *
 * Output all three values OBP, SLG, and OPS on three different lines so all tests pass.
 * It is okay to have more decimal places than the test is looking for (only 3).
 *
 * INFO: Any OPS over .900 is considered great (i.e. Josh Donaldson had .939 the year he
 * won the MVP for the Blue Jays, although Mike Trout had a .991 that year)
 */

#include <stdio.h>

int main() {
    setbuf(stdout, 0);
    int atBat = 600;
    int hit = 200;
    int singles = 124;
    int doubles = 40;
    int triples = 6;
    int homeRuns = 30;
    int walks = 40;
    int hitPitch = 5;
    int sacrifice = 8;
    int obp1 = (hit + walks) + hitPitch;//first half of formula
    int obp2 = (atBat + walks) + hitPitch + sacrifice; //second half of formula
    double obp = (double)obp1 / (double)obp2;
    int slg1 = (singles) + (2*doubles) + (3*triples) + (4*homeRuns);
    int slg2 = atBat;
    double slg = (double)slg1/(double)slg2;
    double ops = obp + slg;
    printf("The hitter's OBP is: %f\n", obp);
    printf("The hitter's SLG is: %f\n", slg);
    printf("The hitter's OPS is: %f\n", ops);


    return 0;
}

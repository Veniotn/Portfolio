#include <stdio.h>
#include "../inc/studentRecord.h"

int main() {
    //Declaring student record objects
    struct StudentRecord studentRecord1,studentRecord2,studentRecord3;

    //generating Student Records
    studentRecord(&studentRecord1);
    studentRecord(&studentRecord2);
    studentRecord(&studentRecord3);

    //generating average mark for each student
    averageMark(&studentRecord1);
    averageMark(&studentRecord2);
    averageMark(&studentRecord3);

    //Generating and printing Report Cards for each student
    printf("\n***********************************REPORT CARDS************************************************\n");
    reportCard(&studentRecord1);
    reportCard(&studentRecord2);
    reportCard(&studentRecord3);

    return 0;
}

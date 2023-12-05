#include <stdio.h>
#include <string.h>

#include "../inc/studentRecord.h"

int main() {

    struct Student  studentOne;
    float           gpa = 3.57;
    int             term = 2;

    // TODO - Create a pointer to the studentOne variable
    struct Student* pStudentOne = &studentOne;

    // TODO - Using the pointer, set the student's properties
    // NOTE - Two of the struct's members are pointers themselves
    strcpy(pStudentOne->firstName, "Justin");
    strcpy(pStudentOne->lastName, "Trudeau");
    strcpy(pStudentOne->studentID, "w5555555");
    pStudentOne->term = &term;
    pStudentOne->gradePointAverage = &gpa;
    pStudentOne->isFullTime = false;
    // TODO - Output the student's details using the Pointer
    printf("Student One:\nID: %s NAME: %s, %s\n", pStudentOne->studentID, pStudentOne->lastName, pStudentOne->firstName);
    printf("TERM: %i GPA: %.2f FULL-TIME: %s", *pStudentOne->term, *pStudentOne->gradePointAverage, pStudentOne->isFullTime ==1 ? "true" : "false");

    // TODO - Uncomment and fix the following code
    int originalVariable;
    int* originalVarPointer;

    originalVariable = 10;
    originalVarPointer = &originalVariable;
    *originalVarPointer = *originalVarPointer + 10;

    printf("\nFirst updated variable value: %i\n", originalVariable);

    *originalVarPointer+=10;

    printf("\nSecond updated variable value: %i\n", originalVariable);

    return 0;
}



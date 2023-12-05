#include <string.h>
#include <stdio.h>

void studentRecord(struct StudentRecord *record){
    int i; // used for our for loop

    //Gathering data about The student
    printf("Please enter the Student ID: \n");
    scanf("%i", &record->studentID);
    printf("Please enter the last name for Student #%i: \n",record->studentID);
    scanf("%s", record->lastName);
    printf("Please enter the first name for Student #%i: \n",record->studentID);
    scanf("%s",record->firstName);

    //for loop to fll the array of courses
    for(i=0; i<5; i++){
        printf("\nPlease enter the course name:\n");
        scanf("%s",record->courseRecords[i].courseName);
        printf("Please enter the mark for %s:\n",record->courseRecords[i].courseName);
        scanf("%f", &record->courseRecords[i].mark);
    }
};

void averageMark(struct StudentRecord *record){
    double gradeCount; // used to add all of our marks together
    int i,courseCount; // i is for our for loop, courseCount was an attempt to keep magic numbers out
    courseCount = 0;
    gradeCount = 0;
    for(i=0; i<5; i++){
        gradeCount += record->courseRecords[i].mark;
        ++courseCount;
    }
    record->averageMark = gradeCount / courseCount;
};

void reportCard(struct StudentRecord *record){
    int i;
    printf("\nStudent: ID:%i                    Name: %s, %s",record->studentID,record->lastName,record->firstName);
    printf("\n----------------------------------------------------\n");
    for(i=0; i<5; i++){
        printf("\nCourse name: %s   Course mark: %.0f\n",record->courseRecords[i].courseName, record->courseRecords[i].mark);
    }
    printf("\n Grade Average: %.1f\n", record->averageMark);

};

//
// Created by nick on 10/16/2022.
//

#ifndef ASSIGN3_STUDENTRECORD_H
#define ASSIGN3_STUDENTRECORD_H

//structs
struct CourseRecord{
    char courseName [21];
    float mark;
};
struct StudentRecord{
    int studentID;
    char firstName[21], lastName[21];
    struct CourseRecord courseRecords[5];
    float averageMark;
};

//methods
void studentRecord(struct StudentRecord *record);
void averageMark(struct StudentRecord *record);
void reportCard(struct StudentRecord *record);

#endif //ASSIGN3_STUDENTRECORD_H

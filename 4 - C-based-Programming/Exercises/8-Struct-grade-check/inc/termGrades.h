//
// Created by nick on 10/24/2022.
//

#ifndef EX8_TERMGRADES_H
#define EX8_TERMGRADES_H
union Grade{
    char letterGrade[3];
    float gpa;
    int numberGrade;
};
struct Course{
    char courseName[10];
    union Grade finalMark;
    int gradeCode;
};

double calculateTermGPA(int numCourses, struct Course courseList[]);
#endif //EX8_TERMGRADES_H

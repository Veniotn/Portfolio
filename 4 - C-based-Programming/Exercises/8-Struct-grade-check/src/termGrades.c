//
// Created by nick on 10/24/2022.
//

// 0 is letter, 1 is double and 2 is int
#include "../inc/termGrades.h"
#include <stdio.h>

double calculateTermGPA(int numCourses, struct Course courseList[]){
    double gradeSum;
    int i;
    gradeSum = 0;
    for(i=0; i<numCourses; i++)
    {
        if(courseList[i].gradeCode == 0)
        {
            switch (courseList[i].finalMark.letterGrade[0])
            {
                case 'A':
                    if(courseList[i].finalMark.letterGrade[1] == '-')
                    {
                        gradeSum += 3.7;
                        break;
                    } else
                    {
                        gradeSum += 4.0;
                        break;
                    }
                case 'B':
                    if(courseList[i].finalMark.letterGrade[1] == '+')
                    {
                        gradeSum += 3.3;
                        break;
                    }
                    else if(courseList[i].finalMark.letterGrade[1] == '-')
                    {
                        gradeSum += 2.7;
                        break;
                    }
                    else{
                        gradeSum += 3.0;
                        break;
                    }
                case 'C':
                    if(courseList[i].finalMark.letterGrade[1]== '+')
                    {
                        gradeSum += 2.3;
                        break;
                    }
                    else if(courseList[i].finalMark.letterGrade[1] == '-')
                    {
                        gradeSum += 1.7;

                        break;
                    }
                    else
                    {
                        gradeSum += 2;
                        break;
                    }
                case 'D':
                    if(courseList[i].finalMark.letterGrade[1] == '+')
                    {
                        gradeSum += 1.3;
                        break;
                    }
                    else
                    {
                        gradeSum += 1;
                        break;
                    }
                default:
                    gradeSum += 0;
            }
        }
        else if(courseList[i].gradeCode == 1){
            gradeSum += courseList[i].finalMark.gpa;
        }
        else
        {
            if(courseList[i].finalMark.numberGrade >=85 && courseList[i].finalMark.numberGrade <= 100)
            {
                gradeSum += 4;
            }
            else if(courseList[i].finalMark.numberGrade >=80 && courseList[i].finalMark.numberGrade <= 84)
            {
                gradeSum += 3.7;
            }
            else if(courseList[i].finalMark.numberGrade >=76 && courseList[i].finalMark.numberGrade <= 79)
            {
                gradeSum += 3.3;
            }
            else if(courseList[i].finalMark.numberGrade >=73 && courseList[i].finalMark.numberGrade <= 75)
            {
                gradeSum += 3;
            }
            else if(courseList[i].finalMark.numberGrade >=70 && courseList[i].finalMark.numberGrade <= 72)
            {
                gradeSum += 2.7;
            }
            else if(courseList[i].finalMark.numberGrade >=67 && courseList[i].finalMark.numberGrade <= 69)
            {
                gradeSum += 2.3;
            }
            else if(courseList[i].finalMark.numberGrade >=64 && courseList[i].finalMark.numberGrade <= 66)
            {
                gradeSum += 2;
            }
            else if(courseList[i].finalMark.numberGrade >=60 && courseList[i].finalMark.numberGrade <= 63)
            {
                gradeSum += 1.7;
            }
            else if(courseList[i].finalMark.numberGrade >=55 && courseList[i].finalMark.numberGrade <= 59)
            {
                gradeSum += 1.3;
            }
            else if(courseList[i].finalMark.numberGrade >=50 && courseList[i].finalMark.numberGrade <= 54)
            {
                gradeSum += 1;
            } else
            {
                gradeSum += 0;
            }
        }
    }
    return gradeSum / numCourses;

}

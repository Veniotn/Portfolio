//
// Created by nick on 2/28/2023.
//

#include "student.h"
#include "util.h"



void Student::addCourse()
{
    //If a course has been added already resize the array.
    if (numCourses >= 1)
    {
        Student::resizeCourseList();
    }

    cout << "Enter the name of the course for " + this->name + ": ";

    //numCourses always points to the last index of the courseList
    cin >> courseList[numCourses];
    numCourses++;
}

void Student::printCourses()
{
    cout << "\nPrinting courses for " << name <<  ":" << endl;
    cout << "Total courses: " << numCourses << endl;

    for (int currentCourseIndex = 0; currentCourseIndex < courseListSize; currentCourseIndex++) {
        cout << "Course " << "#" << (currentCourseIndex+1) << ": " << courseList[currentCourseIndex] << endl;
    }


}



void Student::resizeCourseList()
{
    //increase the max size of the list and create a new list with the greater size.
    courseListSize++;
    string *tempCourseList = new string[courseListSize];


    //Copy the current list of courses into the temporary list.
    for (int listIndex = 0; listIndex < numCourses; listIndex++)
    {
        tempCourseList[listIndex] = courseList[listIndex];
    }
    //delete the old list in memory.
    delete[] courseList;

    //rename the new array.
    courseList = tempCourseList;
}

void Student::resetCourseList()
{
    numCourses = 0;
    courseListSize = 0;
    delete[] courseList;
};


bool Student::addCoursePrompt()
{
    string answer = "";

    while (true)//Will return is input is valid so no need to leave the loop in the function.
    {
        cout << "Would you like to add another course? [yes] or [no]: ";
        cin >> answer;

        if (Util::toLower(answer) == "yes")
        {
            return true;
            //Continue the loop if they type yes
        }
        else if (Util::toLower(answer) == "no")
        {
            return false;
        }
        else
        {
            cout << "invalid response." << endl;
        }

    }
}









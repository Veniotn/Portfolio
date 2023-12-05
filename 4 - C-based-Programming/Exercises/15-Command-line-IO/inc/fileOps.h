#ifndef EX15_FILEOPS_H
#define EX15_FILEOPS_H

#include <stdio.h>
#include <stdbool.h>

#define MAXINPUT 264


int writeAppendToFile(char *filePath, char *inMessage, bool append);
int readFromFile(char *filePath);

#endif //EX15_FILEOPS_H

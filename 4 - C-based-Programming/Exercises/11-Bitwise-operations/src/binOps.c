#include "../inc/binOps.h"

// SOURCE: https://www.geeksforgeeks.org/binary-representation-of-a-given-number/
void getBinary(unsigned int positiveInteger, int bitCount, char *binaryString)
{
    int charCount = 0;

    for (unsigned int i = 1 << (bitCount - 1); i > 0; i = i / 2) {
        char currentChar;
        (positiveInteger & i) ? (currentChar = '1') : (currentChar = '0');

        binaryString[charCount] = currentChar;
        charCount++;
    }

    binaryString[charCount] = '\0';
}


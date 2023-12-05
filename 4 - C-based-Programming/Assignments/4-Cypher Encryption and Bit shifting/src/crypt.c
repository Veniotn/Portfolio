
#include "../inc/crypt.h"

//
// Created by nick on 11/9/2022.
//
void encrypt(char originalString[], const int SIZE,char startMap[],char subMap[])
{
    int resultBinary[MAXINPUT], numericText [MAXINPUT], subIndex;
    char *pSubLocation;

    for (int i = 0; i < SIZE; ++i)
    {
        pSubLocation = strchr(startMap, toupper(originalString[i]));
        subIndex = pSubLocation - &startMap[0];
        originalString[i] = subMap[subIndex];
    }
    //Scan through the original string, cast all individual letters to their int equivalent , than perform a bitwise exclusive OR, encrypting the message.
    for (int i = 0; i < SIZE; i++)
    {
        numericText[i] = (int)(originalString[i]);
        resultBinary[i] = ENCRYPTION(numericText[i],MASK);
    }

    printf("\nThe encrypted message is:\n");
    for (int i = 0; i < SIZE; i++)
    {
        printf("%d ", resultBinary[i]);
    }
}


void decrypt(int originalBinary[], int size,char startMap[],char subMap[])
{
    int resultBinary[MAXINPUT], startIndex;
    char *pStartLocation;
    char resultString[MAXINPUT],currentLetter[2]; //1 is for the char and 2 is for the null operator


    for (int i = 0; i <= size; i++)
    {
        resultBinary[i] = DECRYPTION(originalBinary[i],MASK);
    }

    for (int i = 0; i <= size; ++i)
    {
        currentLetter[0] = resultBinary[i];
        pStartLocation = strchr(subMap, toupper(currentLetter[0]));
        startIndex = pStartLocation - &subMap[0];
        resultString[i] = startMap[startIndex];
    }

    printf("\nThe decrypted message is:\n");
    for (int i = 0; i <= size; i++)
    {
        printf("%c", resultString[i]);
    }
}


#include "../inc/crypt.h"



int main() {
    enum encryptDecrypt choice;
    int originalBinary[MAXINPUT];
    char originalString[MAXINPUT];
    char *currentNum;
    char startMap[] = {'0', '1', '2', '3', '4', '5', '6',
                       '7', '8', '9', 'A', 'B', 'C', 'D',
                       'E', 'F', 'G', 'H', 'I', 'J', 'K',
                       'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                       'S', 'T', 'U', 'V', 'W', 'X', 'Y',
                       'Z', '!', '@', '#', '$', '%', '&',
                       '(', ')', ':', ';', '?', '.', ',',
                       '/',' '};
                //Two char maps used for letter swapping
    char subMap[] =   {':', ';', '?', '.', ',', '/', '0',
                       '1', '2', '3', '4', '5', '6', '7',
                       '8', '9', 'A', 'B', 'C', 'D', 'E',
                       'F', 'G', 'H', 'I', 'J', 'K', 'L',
                       'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                       'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                       '!', '@', '#', '$', '%', '&', '(',
                       ')',' '};



    printf("What operation would you like to perform (1 - Encrypt, 2 - Decrypt)?\n");
    scanf("%d",&choice);

    if(choice == ENCRYPT)
    {
        printf("\nSo, you want to encrypt the message!\nPlease enter your message:\n");
        scanf(" %[^'\n']s",originalString);
        const int SIZE = strlen(originalString);
        encrypt(originalString,SIZE,startMap,subMap);


        return 0;
    }
    else if(choice==DECRYPT)
    {
        printf("So, you want to decrypt the message!\nPlease enter your message:\n");
        scanf(" %[^'\n']s",originalString);

        //https://stackoverflow.com/questions/47456692/c-string-of-numbers-separated-by-whitespaces-into-integer-array Used to convert the input numbers to an int array
        //We start at index -1 because if we started at 0 the while would register as null
        int index=-1;
        currentNum = strtok(originalString, " ");

        while(currentNum != NULL)
        {
            index++;
            originalBinary[index] = atoi(currentNum);
            currentNum = strtok(NULL, " ");
        }
        decrypt(originalBinary,index,startMap,subMap);


        return 0;
    }
    else
    {
        printf("\nSo, you do not know what you want!.\n");


        return 1;
    }
}

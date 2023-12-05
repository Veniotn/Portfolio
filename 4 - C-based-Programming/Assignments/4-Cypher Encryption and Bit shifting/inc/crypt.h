
// Created by nick on 11/9/2022.
//

#ifndef ASSIGN4_CRYPT_H
#define ASSIGN4_CRYPT_H

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MASK 0xa5
#define MAXINPUT 256

#define ENCRYPTION(input,MASK) (input ^ MASK)
#define DECRYPTION(input,MASK) (input ^ MASK)


enum encryptDecrypt{
    ENCRYPT=1,
    DECRYPT
};


void encrypt(char originalString[], const int SIZE,char startMap[],char subMap[]);
void decrypt(int originalBinary[], int size,char startMap[],char subMap[]);


#endif //ASSIGN4_CRYPT_H

#ifndef EX16_ARRAYOPS_H
#define EX16_ARRAYOPS_H

#include <limits.h> // ANY IDEA WHY THIS IS HERE?
#include <stdio.h>



typedef enum{
    SUM,
    AVERAGE,
    MAX,
    MIN
} ArrayOperation;

/* FUNCTION TO CALL FROM MAIN */
float processArray(ArrayOperation selectedOp, int arrayCount, int *array);

#endif //EX16_ARRAYOPS_H

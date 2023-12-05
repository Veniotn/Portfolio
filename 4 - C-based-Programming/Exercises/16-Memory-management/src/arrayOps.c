#include "../inc/arrayOps.h"

/* HELPER FUNCTION PROTOTYPE DECLARATIONS */
float arraySum(int arrayCount, int *array);
float arrayAverage(int arrayCount, int *array);
float arrayMaximum(int arrayCount, int *array);
float arrayMinimum(int arrayCount, int *array);

float processArray(ArrayOperation selectedOp, int arrayCount, int *array)
{
    double result = 0; // this will hold the answer to all issues.

    // IMPLEMENT FUNCTION
    for (int i = 0; i < arrayCount; i++)
    {
        printf("Enter value #%i: ", i+1);
        scanf("%d", &array[i]);
    }
    switch (selectedOp)
    {
        case SUM:
            result = arraySum(arrayCount, array);
            break;
        case AVERAGE:
            result = arrayAverage(arrayCount,array);
            break;
        case MAX:
            result = arrayMaximum(arrayCount,array);
            break;
        case MIN:
            result = arrayMinimum(arrayCount,array);
            break;
        default:
            result = 0; //should never get to this point.
            break;
    }
//    free(arrayCount);
    return result;
}

// WE WILL DEFINE OUR HELPER FUNCTIONS DOWN HERE
float arraySum(int arrayCount, int *array)
{
    // IMPLEMENT FUNCTION
    int sum = 0;
    for (int i = 0; i < arrayCount; ++i)
    {
        sum += array[i];
    }

    return sum;
}

float arrayAverage(int arrayCount, int *array)
{
    float sum;
    // IMPLEMENT FUNCTION - MIGHT BE NICE TO REUSE FUNCTION ABOVE
    sum = arraySum(arrayCount,array);

    return (double) (sum / arrayCount);
}

float arrayMaximum(int arrayCount, int *array)
{
    float highest = INT_MIN; // ANY IDEA WHY THIS IS HERE?
    float temp;

    // IMPLEMENT FUNCTION
    for (int i = 0; i < arrayCount; i++)
    {
        for (int j = 0; j < arrayCount - 1; j++)
        {
            if(array[i] < array[j])
            {
                temp = array[i];
                array[i] = array[j]; // sort the array
                array[j] = temp;
            }
        }
    }

    return array[arrayCount-1]; //return the last index of our sorted array
}

float arrayMinimum(int arrayCount, int *array)
{
    float lowest = INT_MAX; // ANY IDEA WHY THIS IS HERE?

    // IMPLEMENT FUNCTION
    arrayMaximum(arrayCount,array); // sort the array and return the first index

    return array[0];
}



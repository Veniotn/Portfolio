#include "../inc/calculator.h"


float calculateResult(Operator selectedOp, int value1, int value2){
    switch (selectedOp) {
        case ADDITION:
            return (float)value1 + value2;
        case SUBTRACTION:
            return (float)value1 - value2;
        case MULTIPLICATION:
            return (float)value1 * value2;
        case DIVISION:
            return (float)value1 / value2;
        case POWER:
            return (float)pow(value1,value2);
    }
}

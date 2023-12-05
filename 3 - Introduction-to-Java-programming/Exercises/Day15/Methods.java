import java.util.Random;

public class Methods {

    /**
     * Methods in Java are essentially "functions" in other programming languages
     *
     * Methods are reusable/callable blocks of code that allow us to write code once, then "call" it
     * to execute that code block.
     *
     * Methods have "signatures", which include the method's name, and parameter types. Signatures at a glance tell
     * us most of what we need to know about the method.
     *
     * When we call methods to execute them, if they are defined with parameters, we must pass in arguments within
     * that function call.
     *
     * Methods can return a value, but don't have to.
     */

    // The "main" method has a method signature of main(String[])
    public static void main(String[] args) {

        // Let's call some methods we've defined in the Utilities class
        Utilities utils = new Utilities();

        // Calling a method that doesn't return a value
        utils.greetUser();

        // Often when we call a method, it will return a value to us for later use, the following examples
        // demonstrate using a value returned by a method

        // Calling a method and providing two arguments of type int because the method signature requires it
        // We create a variable called sum, which matches the type returned by the method (int)
        int sum = utils.addTwoNums(2, 2);

        float val = utils.subtractNumsToZero(100, 5);

        // We can also pass in arrays, not just individual primitives or reference types
        int[] numArray = {
                10, 20, 30, 40, 50, 60, 70, 80, 90, 100
        };

        int sumOfArray = utils.sumArray(numArray);
        System.out.println(sumOfArray);

        // Let's talk about memory structure and the implications it has on methods

        // run on the assumption an int is 8 bits to simplify the example

        // Let's pass in and modify some primitive values
        int baseNum = 8; // 00001000 MA = 0x1313
        utils.addTen(baseNum);

        // if we want to keep the value around, we will have to update our addTen method to return a value
        //baseNum = utils.addTen(baseNum);   // 00010010  MA - 0x1313

        System.out.println(baseNum);

        int[] fooArray = { // reference type variable
                10, 20, 30, 40, 50, 60, 70, 80, 90, 100   // 0x4555  MA - 0x4444
        };                                              // where our array contents are stored     MA - 0x4555

        utils.clearArray(numArray);
        // ccbb     MA - 0xabab is the memory address of the numArray variable
        // 80 bits           MA - 0xccbb is the memory address where our array of ints is actually stored

        // Let's check the contents of the numArray
        System.out.println();

        // Why did the contents of the array of ints change.. yet our primitive baseNum didn't?

        Dog rover = new Dog("Rover");   //   0xdddd        MA - 0xcccc
                                              //  the actual info for rover         MA - 0xdddd
        System.out.println(rover.name);

        Dog ruffie = new Dog("Ruffie");  //   0xdddd       MA - 0xbbbb

        System.out.println(ruffie.name);

        ruffie = rover;
        rover.name = "Rover Runnigan";

        System.out.println(ruffie.name);
    }
}


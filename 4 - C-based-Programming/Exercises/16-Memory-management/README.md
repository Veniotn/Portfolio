
<img width="150px" src="https://www.nscc.ca/img/aboutnscc/visual-identity-guidelines/artwork/nscc-jpeg.jpg" >

# PROG 2007 - Exercise 16

## Task
We are going to build a simple program to perform some basic array calculations.

**It will work based on command line arguments**

It will **dynamically allocate** int arrays of the specified size and prompt the user for the proper number of entries.

### STEPS:
Our program will be called like so:  

EX16.exe [op ] [arraySize]

**ops**: **-s** = sum, **-a** = average, **-mx** = maximum, **-mn** = minimum

e.g. .\EX16.exe -a 7

**If proper arguments are used, show the result to one decimal place.**

If there is an incorrect number of command line arguments, we should print the correct message and return 1 as indicated in the examples below.

If the second command line argument is not a valid operator string, we should print the correct message and return 1 as indicated in the examples below.

There is a limit to how much validation we can do on an in-class exercise though, so we can assume a valid **int** for the third command line argument.

### IMPORTANT NOTES:

Make use of **all included code** provided in "**inc/arrayOps.h**" and "**src/arrayOps.c**" (i.e. implement and use the functions, enums, and variables already provided). Read all of the code comments in UPPERCASE for some help. **Do not forget to properly release the dynamic memory for the array when done with it.**

### Sample outputs:

 Sample of improper number of command line arguments:  
    <img width="600px" src="https://prog2007.netlify.app/ex16-bad-num-args.png" alt="EX16 Improper Number of Command Line Arguments">

Sample of improper operator:  
    <img width="600px" src="https://prog2007.netlify.app/ex16-bad-op.png" alt="EX16 Improper Operator">

Sample of finding array **sum**:  
    <img width="600px" src="https://prog2007.netlify.app/ex16-sum.png" alt="EX16 Array Sum">

Sample of finding array **average**:  
    <img width="600px" src="https://prog2007.netlify.app/ex16-avg.png" alt="EX16 Array Average">

Sample of finding array **maximum** value:  
    <img width="600px" src="https://prog2007.netlify.app/ex16-max.png" alt="EX16 Array Maximum">

Sample of finding array **miminum** value:  
    <img width="600px" src="https://prog2007.netlify.app/ex16-min.png" alt="EX16 Array Minimum">

### Instructions:
-   Clone this repository to your local machine, make changes in CLion so all tests pass, and then commit and push the entire project up to GitHub
-   You should then be able to see your raw score on GitHub out of 10 as shown in class. The final grade will depend on the time of submission, see below:

#### Marking Scheme
Final Grade | Requirement
:---: | ---
|**10/10** | Exercise is correct (passes all tests) and is completed within the allotted in-class time.
|**8/10** | Exercise is correct (passes all tests) and is completed within a 12-hour grace period beginning immediately following the end of in-class time.
|**6/10** | Exercise is correct (passes all tests) and is completed and submitted after the 12-hour grace period has elapsed. 
|**0/10** | Exercise is not submitted or does not pass all tests.

> Written with [StackEdit](https://stackedit.io/).
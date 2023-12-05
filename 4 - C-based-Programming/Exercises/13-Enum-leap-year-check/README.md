

<img width="150px" src="https://www.nscc.ca/img/aboutnscc/visual-identity-guidelines/artwork/nscc-jpeg.jpg" >

# PROG 2007 - Exercise 13

**NOTE: One of the typical tasks of a programmer is to go back to old code, which is already "running" and *refactor* it to make the code cleaner, more efficient, etc.**

**Refactoring** is not always as exciting as building a new application, but it is necessary. It is particularly useful for you as students, once you learn new techniques, to see how we could go back to an old application and make it better.

## Task
We are going to refactor our solution to Exercise 6. As a reminder, it calculated how many days were in a specified month for a given year.

### STEP 1:
Take the leap year function that you already have and **reimplement it as a preprocessor macro**. You will probably want to do this in the included "**inc/dates.h**" file.  
Try to do it yourself, but if stuck you can refer to the example on page 306 in Chapter 12 of the book.

### STEP 2:
Define an **enumeration for the possible months**. You will probably want to do this in the included "**inc/dates.h**" file.    
Try to do it yourself, but if stuck you can refer to the example on page 320 in Chapter 13 of the book.

### STEP 3:
**Use the enumeration in your function** to calculate the days in a month. You will probably want to do declare this function in the "**inc/dates.h**" file and define it in "**src/dates.c**".  The function should take in the enumeration data type instead of just an integer month code like before. The switch or if-else if block inside you function should operate on month enumeration values.

### REMINDERs:
- Return a message of "Bad year" if a year between 1 and 9999 is not entered and return 1 error code.
- Return a message of "Bad month" if a month between 1 and 12 is not entered and return 1 error code.
- "30 days has September, April, June, and November".

### Sample outputs (which should be the same as Exercise 6):

Sample of proper input:    
<img width="400px" src="https://prog2007.netlify.app/ex6-success.png" alt="EX13 Success">

Sample of bad year input:  
<img width="400px" src="https://prog2007.netlify.app/ex6-bad-year.png" alt="EX13 Bad Year">

Sample of bad month input:   
<img width="400px" src="https://prog2007.netlify.app/ex6-bad-month.png" alt="EX13 Bad Month">

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
<img width="150px" src="https://www.nscc.ca/img/aboutnscc/visual-identity-guidelines/artwork/nscc-jpeg.jpg" >

# PROG 2007 - Exercise 12

## Task
We will create an application to convert from litres to gallons using Preprocessor macros.

### STEPS:
You have already been provided with "**src/main.c**" and "**inc/litreGallon.h**" files. The main.c file is fine as-is and you will do all your work in the "litreGallon.h" file.**

**NOTE**: US and UK Gallons are different. See the following link: [https://tinyurl.com/2p9y8yrw](https://tinyurl.com/2p9y8yrw)

In the header file, create a #DEFINE constant called **LOCALE** and set it to **1** to start for US gallons.

Place conditionally compiled preprocessor macro code to convert litres to gallons via US values if LOCALE is 1.

**Take note of the name of the macro as expected in the main.c code.**

When done, your code should work as in the following image:  
<img width="600px" src="https://prog2007.netlify.app/ex12-us.png" alt="EX12 US Conversion">

**Now, place additional conditionally compiled preprocessor macro code to convert litres to gallons via UK values if LOCALE is 2. Then set the LOCALE to 2 in the header file to test it.**

When done, your code should work as in the following image:  
<img width="600px" src="https://prog2007.netlify.app/ex12-uk.png" alt="EX12 UK Conversion">

**Now, comment out the LOCALE definition in the header file as we will pass the value in during compilation.**

Go run **make test** via Git Bash and you should see the following:  
<img width="600px" src="https://prog2007.netlify.app/ex12-us-tests.png" alt="EX12 US Test Results">

**Now, change the COUNTRY_CODE to 2 at the top of the Makefile.**

Go run **make test** via Git Bash again and you should see the following:  
<img width="600px" src="https://prog2007.netlify.app/ex12-uk-tests.png" alt="EX12 UK Test Results">

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
import java.util.Arrays;
import java.util.Scanner;
//ready for marking

public class TimeSheet{

    public static Scanner scan = new Scanner(System.in);

    public static void main(String []args){
        System.out.print("Enter hours worked on Day #1: ");
        int day1 = scan.nextInt();
        System.out.print("Enter hours worked on Day #2: ");
        int day2 = scan.nextInt();
        System.out.print("Enter hours worked on Day #3: ");
        int day3 = scan.nextInt();
        System.out.print("Enter hours worked on Day #4: ");
        int day4 = scan.nextInt();
        System.out.print("Enter hours worked on Day #5: ");
        int day5 = scan.nextInt();
        int[] array ={day1, day2, day3, day4, day5};
        int[] dayArray = {1,2,3,4,5};
        int sum = sum(array);
        int[] mostHours = new int[5];
        System.arraycopy(array, 0, mostHours, 0, 4);                  //copy of original array. To be sorted
        for(int i=0; i<mostHours.length; i++){                        //sorting the array, after sorting we will access the last element of the sorted array which will be the day with most hours worked
            for(int j=i; j<mostHours.length; j++){
                if(mostHours[i] > mostHours[j]){
                    int temp = mostHours[i];
                    mostHours[i] = mostHours[j];
                    mostHours[j] = temp;
                    int temp2 = dayArray[i];
                    dayArray[i] = dayArray[j];
                    dayArray[j] = temp2;                             //sorting days the same as we sorted hours
                }
            }
        }


        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("The most hours worked was on:");
        System.out.println("Day #" + dayArray[4] + " when you worked " + mostHours[4] +" hours."); //accessing last element of both sorted hours and sorted days to figure out the most hours worked and the day that it goes with 
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
       
        double sumDouble = sum;
        double average = sumDouble / 5;
        System.out.println("The total number of hours worked was: " + sum);
        System.out.println("The average number of hours worked each day was: " + average);
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("Days you slacked off (i.e worked less than 7 hours):");
        for(int i=0; i< array.length; i++){
            if(array[i] < 7){
                System.out.println("Day #" + dayArray[i] + " " + array[i] + " hours");
            }
        }
    }
            
    
    public static int sum(int[] numbersToAdd){
        int sum = 0;
        int i;
        for(i=0; i<numbersToAdd.length; i++){
            sum += numbersToAdd[i];
        }
        return sum;
    }
}

    
   

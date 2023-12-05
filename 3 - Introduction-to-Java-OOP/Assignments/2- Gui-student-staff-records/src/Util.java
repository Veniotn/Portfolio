import javax.swing.*;

public class Util {
   public static int isStudentNum(String input){
        try{
            int year = Integer.parseInt(input);
            if ((year<1 || year > 4)){ //make sure the number is in the valid range
                JOptionPane.showMessageDialog(null,"Please enter a number between 1-4", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
            return year;// if the input can parse and is in the valid range of numbers we return it.
        }catch (NumberFormatException e){//if it cant parse we know it's not an int
            JOptionPane.showMessageDialog(null,"Please enter a number", "Message", JOptionPane.INFORMATION_MESSAGE);
            return 0;// returning 0 means input was invalid. It will keep us in our do-while loop in the registration function.
        }
   }

   public static int isStaffNum(String input){
       try{
           int year = Integer.parseInt(input);
           if (year <1 || year >30){
               JOptionPane.showMessageDialog(null, "Please enter valid number (1-30)", "Message", JOptionPane.INFORMATION_MESSAGE);
           }
           return year;// if the input can parse we return it.
       }catch (NumberFormatException e){//if it cant parse we know it's not an int
           JOptionPane.showMessageDialog(null,"Please enter a number", "Message", JOptionPane.INFORMATION_MESSAGE);
           return 0;// returning 0 means input was invalid. It will keep us in our while loop in the registration function.
       }
   }

   public static int isEmpty(String input){
        if (input==null) {
           return 1;
        }
        else if (input.equals("")){//if its empty we re-prompt the user
           JOptionPane.showMessageDialog(null, "Please enter valid information", "Message", JOptionPane.INFORMATION_MESSAGE);
           return 3;//we return 3 to keep out do-while loop running
       }
        return 2;// return code for valid input

   }

}

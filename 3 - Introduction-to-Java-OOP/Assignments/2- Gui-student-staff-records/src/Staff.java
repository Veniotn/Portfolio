import javax.swing.*;
import java.util.ArrayList;

public class Staff extends Person{
    int yearsOfService;
    double salary;
    double pay;

    public Staff(String name, String address, int yearsOfService) {
        super(name, address);
        this.yearsOfService = yearsOfService;
        this.salary = 50000 + (500 * this.yearsOfService);
        this.pay = this.salary / 26;
    }

    public static void registration(ArrayList<Staff> staff){
        int year = 0, checkResults; //checkResults is for input validation
        String input, name, address = "";
        boolean validInput = false;

        do { //String input/validation
            validInput = false;
            name = JOptionPane.showInputDialog("Enter Staff Name");
            checkResults = Util.isEmpty(name);//check for empty input
            if (checkResults == 1) {//cancel was pressed
                return;
            } else if (checkResults == 3) {//valid input was not entered
                validInput = false;
            } else {//Valid name input
                address = JOptionPane.showInputDialog("Enter staff Address");
                checkResults = Util.isEmpty(address);
                switch (checkResults) {
                    case 2:
                        validInput = true;
                        break;
                    case 1:
                        return;
                    default:
                        break;
                }
            }
        } while (!validInput);

        //Year input/validation
        do {
            input = JOptionPane.showInputDialog(null, "Enter staff year", "Input", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {//if cancel or x is pressed return to previous menu
                return;
            } else if (input.equals(""))//if blank retry input
            {
                JOptionPane.showMessageDialog(null, "Please enter valid information", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {//if neither parse into integer
                year = Util.isStaffNum(input);
            }
        } while (year<1 || year >30);
        staff.add(new Staff(name, address, year));

    }

    public double getPay() {
        return pay;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public double getSalary() {
        return salary;
    }
    

    public static int outgoing(ArrayList<Staff> staff){
        int outgoing = 0;
        for(int i=0; i<staff.size(); i++){
            outgoing += staff.get(i).getPay();
        }
        return outgoing;
    }

    public static String generateReport(ArrayList<Staff> staff){
        String staffResults = "Staff:[Total: " + staff.size() + "]";
        for(int i=0; i<staff.size(); i++){
            staffResults += "\n" + (i+1) + ".name = " + staff.get(i).getName() + ", address = " + staff.get(i).getAddress() + ", years = " + staff.get(i).getYearsOfService() + ", pay = " + staff.get(i).getSalary();
        }
        return staffResults;
    }
}

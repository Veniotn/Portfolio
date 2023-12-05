import javax.swing.*;
import java.util.ArrayList;

public class Student extends Person{

    int year;
    double fees;
    double invoice;

    public Student(String name, String address, int year) {
        super(name, address);
        this.year = year;
        this.fees = year > 1 ? 3000 + (year * 100)-100: 3000;
        this.invoice =  this.fees / 2;
    }

    public int getYear() {
        return year;
    }

    public double getFees() {
        return fees;
    }

    public double getInvoice() {
        return invoice;
    }


    protected static void registration(ArrayList<Student> students){
        int year = 0, checkResults; //checkResults is for input validation
        String input, name, address = "";
        boolean validInput = false;


        do {//ask user for student year, and check for valid input
            input = JOptionPane.showInputDialog(null, "Enter student year (1-4)", "Input", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {//if cancel return to previous menu
                return;
            } else if (input.equals("")) {//if empty prompt for valid info
                JOptionPane.showMessageDialog(null, "Please enter valid information", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                year = Util.isStudentNum(input); // check that input is a number
            }
        } while (year < 1 || year > 4);

        do {
            validInput = false;
            name = JOptionPane.showInputDialog("Enter Student Name");
            checkResults = Util.isEmpty(name);
            if (checkResults == 1) {
                return;
            } else if (checkResults == 3) {
                validInput = false;
            } else {
                address = JOptionPane.showInputDialog("Enter student Address");
                checkResults = Util.isEmpty(address);
                if(checkResults == 2){
                    validInput = true;
                }
            }
        } while (!validInput);


        students.add(new Student(name, address, year));
        return;
    }

    public static int income(ArrayList<Student> students){
        int incoming = 0;
        for(int i=0; i<students.size(); i++){
            incoming += students.get(i).getInvoice();
        }
        return incoming;
    }

    public static String generateReport(ArrayList<Student> students){
        String stuResults = "Students:[Total: " + students.size() + "]";
        for(int i=0; i<students.size(); i++){
            stuResults += "\n" + (i+1) + ".name = " + students.get(i).getName() + ", address = " + students.get(i).getAddress() + ", year = " + students.get(i).getYear() + ", fee = " + students.get(i).getFees();
        }
        return stuResults;

    }


}

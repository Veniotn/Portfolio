import javax.swing.*;
import java.util.ArrayList;
import java.text.DecimalFormat;


public class Main {
    public static void main(String[] args) {
        int choice;
        double  incoming, outgoing, total;
        String stuReport,staffReport;
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Staff> staffList = new ArrayList<>();
        String[] menuChoices = {"Student", "Staff", "Finish"};
        DecimalFormat format = new DecimalFormat(".##");

        //Main menu
        do {
            choice = JOptionPane.showOptionDialog(null, "Select Student or Staff.", "Accounting App", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuChoices, null);
            switch (choice) {
                case -1://exit symbol
                    int exitChoice = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?", "Accounting app", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,null,null);
                    if (exitChoice == 0){//yes to confirm exit
                        System.exit(0);
                    }
                    break;
                case 2://finish
                    choice=2;
                    break;
                case 0://Student button
                    Student.registration(studentList);
                    break;
                case 1://Staff button
                    Staff.registration(staffList);
                    break;
            }
        } while (choice != 2);
        //User clicks finish

        //Generate student reports
        incoming = Student.income(studentList);
        stuReport = Student.generateReport(studentList);

        //Generate staff reports
        outgoing = Staff.outgoing(staffList);
        staffReport = Staff.generateReport(staffList);

        //Calculate total income/expenditures and create the string that will go under both reports
        total = incoming - outgoing;
        String bottomText = "Results:\n" + "Outgoing: $" + format.format(outgoing) + "\nIncoming: $" + format.format(incoming) + "\nTotal: $" + format.format(total);

        //Display the info to the user
        JOptionPane.showMessageDialog(null, stuReport + "\n" + staffReport + "\n\n\n" + bottomText, "Report", JOptionPane.INFORMATION_MESSAGE);

    }


}

import java.util.Scanner;

public class Player {
    String name;
    int goals;
    int assists;



    public Player(String n, int g, int a){
        this.name = n;
        this.goals = g;
        this.assists = a;
    }
    public static String[] playerGenerator(String tName, String[] pName, int[] goals, int[] assists){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter Players for " + tName + "\n");
        for(int i=0; i<3; i++){
            boolean validName = false;
            while(!validName){ //checking to see if player name is greater than 3 characters
                System.out.println("Enter name for player # " + (i+1) + ": ");
                pName[i] = scan.nextLine();
                if(pName[i].length() < 3){
                    System.out.println("Player name too short try again. (Three characters required!)");
                    validName = false;
                }
                else{
                    validName = true;
                }
            }
            System.out.println("Enter number of goals for " + pName[i] + ": ");
            while (!scan.hasNextInt()) { //if input contains letters of any kind it will prompt the user to try again
                System.out.println("Numbers only, try again.");
                scan.next();
                System.out.println("Enter number of goals for " + pName[i] + ": ");
            }
            goals[i] = scan.nextInt();
            while (goals[i] < 0){
                System.out.println("Goals must be equal to or  greater than 0");
                System.out.println("Enter number of goals for " + pName[i] + ": ");
                goals[i] = scan.nextInt();
            }
            System.out.println("Enter number of assists for " + pName[i] + ": ");
            while (!scan.hasNextInt()) {
                System.out.println("Numbers only, try again.");
                scan.next();
                System.out.println("Enter number of Assists for " + pName[i] + ": ");
            }
            assists[i] = scan.nextInt();
            while (assists[i] < 0){
                System.out.println("Assists must be equal to or greater than 0");
                System.out.println("Enter number of assists for " + pName[i] + ": ");
                assists[i] = scan.nextInt();
            }
            scan.nextLine(); //used when we use scan next line after scan nextInt(Avoids skipping over player 2)
        }
        return pName;
    }
}

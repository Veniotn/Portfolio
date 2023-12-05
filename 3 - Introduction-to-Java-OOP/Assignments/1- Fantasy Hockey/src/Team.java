import java.util.Random;
import java.util.Scanner;

public class Team {
    String teamName;
    Player player1;
    Player player2;
    Player player3;
    double budget;


    public Team(String i){
        Random random = new Random();
        this.teamName = i;
        this.budget = random.nextDouble(1,100000);
    }
    public static String[] getName(String[] names){
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < names.length; i++) {
            boolean valid = false;
            while (!valid){
                System.out.println("Enter name for team " + (i+1) + ": ");
                names[i] = scan.nextLine();
                if(names[i].length() < 3) {
                    System.out.println("Team name too short try again. (Three characters required!)");
                    valid = false;
                }
                else{
                    valid = true;
                }
            }
        }
        return names;
    }

    public void fillTeam(Player p1, Player p2, Player p3){
        this.player1 = p1;
        this.player2 = p2;
        this.player3 = p3;
    }

    public static int sum(int[] stat){
        int sum = 0;
        for(int i =0; i<stat.length; i++){
            sum += stat[i];
        }
        return sum;
    }


    public static String rating(int total){
        if(total == 0){
            return "Zero Stars";
        } else if (total > 0 && total < 10) {
            return "* star";
        } else if (total > 9 && total <= 20) {
            return "** stars";
        }
        else{
            return "*** stars";
        }
    }
}

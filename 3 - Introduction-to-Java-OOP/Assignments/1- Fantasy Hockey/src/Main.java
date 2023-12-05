import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import java.math.*;
public class Main {
    public static void main(String []args) {
        DecimalFormat format = new DecimalFormat("#.##");
        //Containers to store our data
        String[] tNames = new String[3]; // array to store team names
        String[] playerNames1 = new String[3]; //names for first teams players
        String[] playerNames2 = new String[3]; //names for second teams players
        String[] playerNames3 = new String[3]; //names for third teams players
        int[] team1Goals = new int[3];
        int[] team1Assists = new int[3];
        int[] team2Goals = new int[3];
        int[] team2Assists = new int[3];
        int[] team3Goals = new int[3];
        int[] team3Assists = new int[3];

        //Data entry / object creation
        System.out.println("TEAM ENTRY \n\n=============================\n");
        Team.getName(tNames); //Getting the names of the teams from user.
        Team team1 = new Team(tNames[0]);
        Team team2 = new Team(tNames[1]); // creating empty teams as objects
        Team team3 = new Team(tNames[2]);
        System.out.println("PLAYER ENTRY \n\n=============================\n");
        Player.playerGenerator(tNames[0],playerNames1,team1Goals, team1Assists); //generating players for team 1
        Player player1 = new Player(playerNames1[0],team1Goals[0],team1Assists[0]);
        Player player2 = new Player(playerNames1[1],team1Goals[1],team1Assists[1]);
        Player player3 = new Player(playerNames1[2],team1Goals[2],team1Assists[2]);
        team1.fillTeam(player1,player2,player3);//Filling team 1 roster
        Player.playerGenerator(tNames[1],playerNames2,team2Goals, team2Assists);//generating players for team 2
        Player player4 = new Player(playerNames2[0],team2Goals[0],team2Assists[0]);
        Player player5 = new Player(playerNames2[1],team2Goals[1],team2Assists[1]);
        Player player6 = new Player(playerNames2[2],team2Goals[2],team2Assists[2]);
        team2.fillTeam(player4,player5,player6);//Filling team 2 roster
        Player.playerGenerator(tNames[2],playerNames3,team3Goals,team3Assists);//generating players for team 3
        Player player7 = new Player(playerNames3[0],team3Goals[0],team3Assists[0]);
        Player player8 = new Player(playerNames3[1],team3Goals[1],team3Assists[1]);
        Player player9 = new Player(playerNames3[2],team3Goals[2],team3Assists[2]);
        team3.fillTeam(player7,player8,player9);

        //Data Manipulation for team stats
        int team1GoalSum = team1.sum(team1Goals);
        int team1AssistSum = team1.sum(team1Assists);
        int team1Total = team1GoalSum + team1AssistSum;
        int team2GoalSum = team2.sum(team2Goals);
        int team2AssistSum = team2.sum(team2Assists);
        int team2Total = team2GoalSum + team2AssistSum;
        int team3GoalSum = team3.sum(team3Goals);
        int team3AssistSum = team3.sum(team3Assists);
        int team3Total = team3GoalSum + team3AssistSum;

        //Team Ratings
        String team1Rating = team1.rating(team1Total);
        String team2Rating = team2.rating(team2Total);
        String team3Rating = team3.rating(team3Total);


        //Team reports
        System.out.println("REPORT: Stats per Team");
        System.out.println("================================");
        System.out.println(team1.teamName + ": G - " + team1GoalSum + " A - " + team1AssistSum + " Total - " + team1Total + " Budget - $" + format.format(team1.budget));
        System.out.println("Rating: " + team1Rating);
        System.out.println(team2.teamName + ": G - " + team2GoalSum + " A - " + team2AssistSum + " Total - " + team2Total + " Budget - $" + format.format(team2.budget));
        System.out.println("Rating: " + team2Rating);
        System.out.println(team3.teamName + ": G - " + team3GoalSum + " A - " + team3AssistSum + " Total - " + team3Total + " Budget - $" + format.format(team3.budget));
        System.out.println("Rating: " + team3Rating);


        //Player reports
        System.out.println("REPORT: Stats per Player");
        System.out.println("================================");
        //team 1 players
        System.out.println(team1.teamName + "\n" + team1.player1.name +": G - " + team1.player1.goals + " A - " + team1.player1.assists + " Total - " + (team1.player1.goals + team1.player1.assists) + "\n");
        System.out.println(team1.teamName + "\n" + team1.player2.name +": G - " + team1.player2.goals + " A - " + team1.player2.assists + " Total - " + (team1.player2.goals + team1.player2.assists) + "\n");
        System.out.println(team1.teamName + "\n" + team1.player3.name +": G - " + team1.player3.goals + " A - " + team1.player3.assists + " Total - " + (team1.player3.goals + team1.player3.assists) + "\n");
        //team 2 players
        System.out.println(team2.teamName + "\n" + team2.player1.name +": G - " + team2.player1.goals + " A - " + team2.player1.assists + " Total - " + (team2.player1.goals + team2.player1.assists) + "\n");
        System.out.println(team2.teamName + "\n" + team2.player2.name +": G - " + team2.player2.goals + " A - " + team2.player2.assists + " Total - " + (team2.player2.goals + team2.player2.assists) + "\n");
        System.out.println(team2.teamName + "\n" + team2.player3.name +": G - " + team2.player3.goals + " A - " + team2.player3.assists + " Total - " + (team2.player3.goals + team2.player3.assists) + "\n");
        //Team 3 players
        System.out.println(team3.teamName + "\n" + team3.player1.name +": G - " + team3.player1.goals + " A - " + team3.player1.assists + " Total - " + (team3.player1.goals + team3.player1.assists) + "\n");
        System.out.println(team3.teamName + "\n" + team3.player2.name +": G - " + team3.player2.goals + " A - " + team3.player2.assists + " Total - " + (team3.player2.goals + team3.player2.assists) + "\n");
        System.out.println(team3.teamName + "\n" + team3.player3.name +": G - " + team3.player3.goals + " A - " + team3.player3.assists + " Total - " + (team3.player3.goals + team3.player3.assists) + "\n");
    }


}

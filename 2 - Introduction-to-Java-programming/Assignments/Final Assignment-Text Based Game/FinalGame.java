import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

import javax.swing.text.PlainDocument;

import java.math.*;
import java.text.DecimalFormat;

/**
 * FinalGame, felt really really good to make this, feels like I have a super solid foundation now after finishing the project.
 * Things I would change:
 * I would set playerHealth to be its own property, had a very hard time with regenerating the proper amount of health according to the players level.
 * would make new functions for light attack/ heavy attack instead of copying the code.
 * would make massive balance changes to stats, player feels much stronger than the boss sometimes.
 * Find a much better way of doing the cave section, im pretty proud of it but it also feels pretty messy and too much copied code in my opinion.
 * I would add more to the levels in between the fights, similar setups as the cave.
 * More variety of boss mechanics.
 * Would have added saving.
 * In conclusion I wanna thank you for all the support you have given us throughout the course, i felt confused at moments but after finishing each assignment the topic would click. thank you for everything this semester and I hope we get you again next semester!
 */
public class FinalGame {
    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();
    public static DecimalFormat format = new DecimalFormat(".0");
    public static void main(String []args) {
        //boss 1 dialogue
        ArrayList<String> boss1Dialogue = new ArrayList<String>();
        boss1Dialogue.add("Assignment 1");
        boss1Dialogue.add("Welcome to Hipster's Local Vinyl Records! Our favorite band has the perfect soundtrack for this fight but, you've probably never heard of them..");
        boss1Dialogue.add("Sorry about that.. here take a copy of our uncles latest post-folk-screamo demo tape to ease the pain.");
        boss1Dialogue.add("Did our moody lofi beats put you to sleep?... That's the point!");
        boss1Dialogue.add("Al--exa..... p-play..... despacito..");
        //boss 2 dialogue
        ArrayList<String> boss2Dialogue = new ArrayList<String>();
        boss2Dialogue.add("Assignment 2");
        boss2Dialogue.add("GET READY, TO GET ENCRYPTED");
        boss2Dialogue.add("You feel your soul turning into rot13 encoding....");
        boss2Dialogue.add("What are you tired already? This is just the first part!!");
        boss2Dialogue.add("ABG YVXR GUVF!!!!!!!!");
        //boss 3 dialogue
        ArrayList<String> boss3Dialogue = new ArrayList<String>();
        boss3Dialogue.add("Assignment 2 PART 2");
        boss3Dialogue.add("This array isn't set large enough for the both of us!");
        boss3Dialogue.add("Bet you wish you used an arrayList!");
        boss3Dialogue.add("The only thing at index [0] is your health.");
        boss3Dialogue.add("FREE ME FROM MY BOX CONSTRAINED EXISTENCE");
        double[] bossStats = {100,15,20}; //base stats for boss 1 bossLevelUp(bossStats);
        System.out.println("Welcome to PROG1700: The Game.");
        System.out.print("Enter your name.. ");
        String playerName = scan.nextLine();
        System.out.println(" "); 
        double[] playerBuild = new double[5];
        playerBuild = cave(playerName, playerBuild); //cave is used as an interactive character builder
        System.out.println("You walk out of the cave to a vast field covered in snow, you see a campfire 30meters infront of you, while walking towards the campfire the ground below you falls out, dropping you 20ft back down into a spooky looking cave. \nThankfully the snow breaks your fall, and theres lights!! Wait, whats that noise? ");
        System.out.println(" ");
        System.out.println("press any button to continue");
        String anyButton = scan.nextLine().toLowerCase();
        if(anyButton.equals("a")){
            bossFight(boss1Dialogue, playerName, playerBuild, bossStats);
        }
        else{
            bossFight(boss1Dialogue, playerName, playerBuild, bossStats);
        }
        bossStats[0] = 100; //healing boss from last fight
        bossLevelUp(bossStats);
        System.out.println("You walk away from the encounter feeling many things, glad to be alive, confused and most importantly pumped to listen to this demo tape! \nYou put the CD in the conviently placed cd player and press play, the sweet sounds of celtic guitar and teenage rebellion fill your ears! ");
        System.out.println(" ");
        System.out.println("ACHIVEMENT UNLOCKED: CELTIC-CORE");
        System.out.println(" ");
        System.out.println("walking through the labrynth you spot many doors and pathways all blocked off with walls lined with 1s and 0s, the devs really only cared about the first level huh... NO TIME TO THINK ABOUT THE LACK OF STORY, ITS " + boss2Dialogue.get(0));
        System.out.println("press any button to continue");
        String anyButton2 = scan.nextLine().toLowerCase();
        if(anyButton2.equals("a")){
            bossFight(boss2Dialogue, playerName, playerBuild, bossStats);
        }
        else{
            bossFight(boss2Dialogue, playerName, playerBuild, bossStats);
        }
        bossStats[0] = 200;//healing boss, accounting for previous level up
        bossLevelUp(bossStats);
        System.out.println("okay.. that was actually close.. thankfully it's o--- ? PART 2????????");
        System.out.println("FINAL BOSS.");
        System.out.println("press any button to continue");
        String anyButton3 = scan.nextLine().toLowerCase();
        if(anyButton3.equals("a")){
            bossFight(boss3Dialogue, playerName, playerBuild, bossStats);
        }
        else{
            bossFight(boss3Dialogue, playerName, playerBuild, bossStats);
        }
        System.out.println("CREDITS: \nAssignment1 played by: Assignment 1 \nAssignment2-Part 1 played by: The Devil \nAssignment 2-part 2 played by: String[] arraySorter \n" + playerName + "played by: " + playerName + "!");
        System.out.println("CONGRATULATIONS " + playerName + " you beat the game and are rewarded with passing PROG1700 with flying colors!");
        System.out.println("press any button to CLAIM VICTORY");
        String anyButton4 = scan.nextLine().toLowerCase();
        if(anyButton4.equals("a")){
            boolean ding = false;
            while(ding!=true){
            System.out.println(" Dingdiggidiggiding, ");
            }
        }
        else{
            boolean ding = false;
            while(ding!=true){
            System.out.println(" Dingdiggidiggiding, ");
            }
        }
        System.exit(0);
    }
    public static double[] cave(String playerName, double[] playerBuild){
        playerBuild[0] = 0;//player health
        playerBuild[1] = 0;//player energy
        playerBuild[2] = 0;//player weapon
        playerBuild[3] = 0;//player armor
        playerBuild[4] = 0;//health pot
        boolean loadoutChoice1 = false;
        boolean loadoutChoice2 = false;
        boolean loadoutChoice3 = false;
        System.out.println("You awake in a cave, after standing up you see nothing around you but feel the breeze of the outside world in the distance..");
        System.out.println(" ");
        boolean goodStory1 = false;
        while(goodStory1!=true){
        System.out.print("So " + playerName + " what would you like to do: ");
        String firstSteps = scan.nextLine().toLowerCase();
            if(firstSteps.equals("go towards the breeze") || firstSteps.equals("go forward") || firstSteps.equals("go straight") || firstSteps.equals("walk forward") || firstSteps.equals("follow the breeze") || firstSteps.equals("walk straight") || firstSteps.equals("go ahead")){
                System.out.println("");
                goodStory1 = true;
                boolean goodStory2 = false;
                System.out.println("you walk towards the breeze, as it gets closer and colder you hear a cold but familliar voice, calling for you to follow it. \nYour heart rate shoots up, you freeze in fear, or is it the wind? No, defintely the fear. ");
                System.out.println("");
                while(goodStory2!=true){
                System.out.print("what would you like to do: ");
                String forward2 = scan.nextLine().toLowerCase();
                if(forward2.equals("follow the voice") ||forward2.equals("go right") ||forward2.equals("walk right") ||forward2.equals("follow") ||forward2.equals("walk towards it") ||forward2.equals("walk towards the voice") || forward2.equals("approach the voice") || forward2.equals("go towards the voice")){                       
                    System.out.println(" ");
                    goodStory1 = true;
                    System.out.println("");
                    goodStory2 = true;
                    System.out.println("As you approach the voice, it speaks out to you.. \"YES, COME CLOSER, YOUR DESTINY AWATES! \". \n You contemplate your decision with every step you take, but you also feel a strange calm/warming energy.");
                    System.out.println(" ");
                    System.out.println("....");
                    System.out.println("The room fills with light! Infront of you is.... wait, is that Mini-Assignment 1? \n\"YES IT IS I! *COUGH* MINI-ASSIGNMENT 1, I'VE COME TO BESTOW THE GREAT GIFT OF *COUGH* MY FAMILY, PASSED DOWN FOR GENERATIONS AND GENERATIONS, YOU SEE THIS GIF-\" \n  \nBefore mini-assignment 1 has a chance to finish you push him over, knocking him out cold. \nHowever you find a sword and shield behind his back so dont feel too bad about yourself. Better him than you!");
                    loadoutChoice1 = true;
                }
                else if(forward2.equals("ignore it") ||forward2.equals("ignore") ||forward2.equals("go straight") ||forward2.equals("go forward") ||forward2.equals("dont follow the voice") ||forward2.equals("ignore the voice") ||forward2.equals("go straight") ||forward2.equals("walk forward") || forward2.equals("walk straight")){
                    System.out.println("Probably for the best.. you keep following the breeze until things start to get lighter, eventually you find an opening, conviently next to this opening you see a light but rusty sword and shield, nothing special but it works. ");
                    goodStory1 =true;
                    goodStory2 = true;
                    loadoutChoice2 = true;
                }
                else if(forward2.equals("left") || forward2.equals("go left") || forward2.equals("walk left") || forward2.equals("check left") || forward2.equals("look left") || forward2.equals("see left")){
                    System.out.println("You walk to the left and... Hit an invisible wall!? Must be DLC.");
                    System.out.println(" ");
                    boolean goodStory4 = false;
                    while(goodStory4!=true){
                    System.out.println("The voice is still calling....");
                    System.out.print("What would you like to do: ");
                    String forward3 = scan.nextLine().toLowerCase();
                    if(forward3.equals("follow the voice") ||forward3.equals("go right") ||forward3.equals("walk right") ||forward3.equals("follow") ||forward3.equals("walk towards it") ||forward3.equals("walk towards the voice") || forward3.equals("approach the voice") || forward3.equals("go towards the voice")){                       
                    System.out.println(" ");
                    goodStory4 = true;
                    goodStory2 = true;
                    goodStory1 = true;
                    System.out.println("");
                    System.out.println("As you approach the voice, it speaks out to you.. \"YES, COME CLOSER, YOUR DESTINY AWATES! \". \n You contemplate your decision with every step you take, but you also feel a strange calm/warming energy.");
                    System.out.println(" ");
                    System.out.println("....");
                    System.out.println("The room fills with light! Infront of you is.... wait, is that Mini-Assignment 1? \n\"YES IT IS I! *COUGH* MINI-ASSIGNMENT 1, I'VE COME TO BESTOW THE GREAT GIFT OF *COUGH* MY FAMILY, PASSED DOWN FOR GENERATIONS AND GENERATIONS, YOU SEE THIS GIF-\" \n  \nBefore mini-assignment 1 has a chance to finish you push him over, knocking him out cold. \nHowever you find a sword and shield behind his back so dont feel too bad about yourself. Better him than you!");
                    loadoutChoice1 = true;
                    }
                    else if(forward3.equals("ignore it") ||forward3.equals("ignore") ||forward3.equals("go straight") ||forward3.equals("go forward") ||forward3.equals("dont follow the voice") ||forward3.equals("ignore the voice") ||forward3.equals("go straight") ||forward3.equals("walk forward") || forward3.equals("walk straight")){
                        System.out.println("Probably for the best.. you keep following the breeze until things start to get lighter, eventually you find an opening, conviently next to this opening you see a light but rusty sword and shield, nothing special but it works. ");
                        goodStory1 =true;
                        goodStory4 = true;
                        goodStory2 = true;
                        loadoutChoice2 = true;
                    }
                    else if(forward3.equals("go back")||forward3.equals("turn back")||forward3.equals("turn around")||forward3.equals("back")||forward3.equals("backwards")||forward3.equals("run back")|| forward3.equals("back up")||forward3.equals("go backwards")||forward3.equals("run away")){
                        System.out.println(" ");
                        System.out.println("you cant go back now...");
                        System.out.println(" ");
                    }
                    else if(forward3.equals("scream")||forward3.equals("cry")||forward3.equals("nothing")||forward3.equals("freeze")||forward3.equals("do nothing")||forward3.equals("start crying")||forward3.equals("stop")||forward3.equals("stand still")||forward3.equals("stop walking")||forward3.equals("neither")||forward3.equals("scream for help")){
                        System.out.println(" ");
                        System.out.println("you cant go back now...");
                        System.out.println(" ");
                    }
                    else{
                        System.out.println(" ");
                        System.out.println("We didnt test have the budget for more choices. (no whitespace allowed at the end of input either)");
                        System.out.println(" ");
                    }
                }
                }
                else if(forward2.equals("ignore it") ||forward2.equals("ignore") ||forward2.equals("go straight") ||forward2.equals("go forward") ||forward2.equals("dont follow the voice") ||forward2.equals("ignore the voice") ||forward2.equals("go straight") ||forward2.equals("walk forward") || forward2.equals("walk straight")){
                    System.out.println("Probably for the best.. you keep following the breeze until things start to get lighter, eventually you find an opening, conviently next to this opening you see a light but rusty sword and shield, nothing special but it works. ");
                    goodStory1 =true;
                    goodStory2 = true;
                    loadoutChoice2 = true;
                }
                else if(forward2.equals("go back")||forward2.equals("turn back")||forward2.equals("turn around")||forward2.equals("back")||forward2.equals("backwards")||forward2.equals("run back")|| forward2.equals("back up")||forward2.equals("go backwards")||forward2.equals("run away")){
                    System.out.println(" ");
                    System.out.println("you cant go back now...");
                    System.out.println(" ");
                }
                else if(forward2.equals("scream")||forward2.equals("cry")||forward2.equals("nothing")||forward2.equals("freeze")||forward2.equals("do nothing")||forward2.equals("start crying")||forward2.equals("stop")||forward2.equals("stand still")||forward2.equals("stop walking")||forward2.equals("neither")||forward2.equals("scream for help")){
                    System.out.println(" ");
                    System.out.println("you cant go back now...");
                    System.out.println(" ");
                }
                else{
                    System.out.println(" ");
                    System.out.println("We didnt have the budget for more choices. (no whitespace allowed at the end of input either)");
                    System.out.println(" ");
                }  
            }
        }    
        else if(firstSteps.equals("go backwards") || firstSteps.equals("turn around") || firstSteps.equals("back") || firstSteps.equals("walk backwards") || firstSteps.equals("walk back") || firstSteps.equals("turn back") || firstSteps.equals("spin around")|| firstSteps.equals("go back")){
            System.out.println(" ");
            System.out.println("You turn around, behind you you still see nothing, but you can sense a giant pit, maybe bottomless? better to not find out.... unless?");
            System.out.print("what would you like to do: ");
            System.out.println(" ");
            boolean goodStory3 = false;
            while(goodStory3!=true){
            String backwardsChoice = scan.nextLine().toLowerCase();
            if(backwardsChoice.equals("jump")|| backwardsChoice.equals("find out")|| backwardsChoice.equals("jump in")|| backwardsChoice.equals("go forward")|| backwardsChoice.equals("walk forward")|| backwardsChoice.equals("straight")|| backwardsChoice.equals("walk straight")|| backwardsChoice.equals("jump in the pit")|| backwardsChoice.equals("go in the pit")|| backwardsChoice.equals("pit")|| backwardsChoice.equals("jump off the edge")){
                System.out.println("You plummet to the bottom.. You di-- land on a soft pile of pillows! wow are those silk?! wait. is that a HEAVY SWORD / SHIELD????! Wait, is that a PORTAL TO THE CAVE EXIT?? Your risk paid off.");
                goodStory3 = true;
                loadoutChoice3 =true;
            }
            else if(backwardsChoice.equals("go back")|| backwardsChoice.equals("turn back")|| backwardsChoice.equals("back")|| backwardsChoice.equals("stop")|| backwardsChoice.equals("dont jump")|| backwardsChoice.equals("dont")|| backwardsChoice.equals("backwards")|| backwardsChoice.equals("turn around")){
                System.out.println("You think about it for a second before turning back around and heading towards the breeze.");
                System.out.println("You walk towards the breeze, as it gets closer and colder you hear a cold but familliar voice, calling for you to follow it. \nYour heart rate shoots up, you freeze in fear, or is it the wind? No, defintely the fear. ");
                System.out.println("");
                System.out.print("what would you like to do: ");
                String forward2 = scan.nextLine().toLowerCase();
                if(forward2.equals("follow the voice") ||forward2.equals("go right") ||forward2.equals("walk right") ||forward2.equals("follow") ||forward2.equals("walk towards it") ||forward2.equals("walk towards the voice") || forward2.equals("approach the voice") || forward2.equals("go towards the voice")){ 
                    System.out.println(" ");
                    goodStory1 = true;
                    System.out.println("");
                    goodStory3 = true;
                    System.out.println("As you approach the voice, it speaks out to you.. \"YES, COME CLOSER, YOUR DESTINY AWATES! \". \n You contemplate your decision with every step you take, but you also feel a strange calm/warming energy.");
                    System.out.println(" ");
                    System.out.println("....");
                    System.out.println("The room fills with light! Infront of you is.... wait, is that Mini-Assignment 1? \n\"YES IT IS I! *COUGH* MINI-ASSIGNMENT 1, I'VE COME TO BESTOW THE GREAT GIFT OF *COUGH* MY FAMILY, PASSED DOWN FOR GENERATIONS AND GENERATIONS, YOU SEE THIS GIF-\" \n  \nBefore mini-assignment 1 has a chance to finish you push him over, knocking him out cold. \nHowever you find a sword and shield behind his back so dont feel too bad about yourself. Better him than you!");
                    loadoutChoice1 = true;
                }
                else if(forward2.equals("ignore it") ||forward2.equals("ignore") ||forward2.equals("go straight") ||forward2.equals("go forward") ||forward2.equals("dont follow the voice") ||forward2.equals("ignore the voice") ||forward2.equals("go straight") ||forward2.equals("walk forward") || forward2.equals("walk straight")){
                    System.out.println("Probably for the best.. you keep following the breeze until things start to get lighter, eventually you find an opening, conviently next to this opening you see a light but rusty sword and shield, nothing special but it works. ");
                    goodStory1 =true;
                    goodStory3 = true;
                    loadoutChoice2 = true;
                }
                else if(forward2.equals("left") || forward2.equals("go left") || forward2.equals("walk left") || forward2.equals("check left") || forward2.equals("look left") || forward2.equals("see left")){
                    System.out.println("You walk to the left and... Hit an invisible wall!? Must be DLC.");
                    System.out.println(" ");
                    boolean goodStory4 = false;
                    while(goodStory4!=true){
                    System.out.println("The voice is still calling....");
                    System.out.print("What would you like to do: ");
                    String forward3 = scan.nextLine().toLowerCase();
                    if(forward3.equals("follow the voice") ||forward3.equals("go right") ||forward3.equals("walk right") ||forward3.equals("follow") ||forward3.equals("walk towards it") ||forward3.equals("walk towards the voice") || forward3.equals("approach the voice") || forward3.equals("go towards the voice")){                       
                    System.out.println(" ");
                    goodStory4 = true;
                    goodStory3= true;
                    goodStory1 = true;
                    System.out.println("");
                    System.out.println("As you approach the voice, it speaks out to you.. \"YES, COME CLOSER, YOUR DESTINY AWATES! \". \n You contemplate your decision with every step you take, but you also feel a strange calm/warming energy.");
                    System.out.println(" ");
                    System.out.println("....");
                    System.out.println("The room fills with light! Infront of you is.... wait, is that Mini-Assignment 1? \n\"YES IT IS I! *COUGH* MINI-ASSIGNMENT 1, I'VE COME TO BESTOW THE GREAT GIFT OF *COUGH* MY FAMILY, PASSED DOWN FOR GENERATIONS AND GENERATIONS, YOU SEE THIS GIF-\" \n  \nBefore mini-assignment 1 has a chance to finish you push him over, knocking him out cold. \nHowever you find a sword and shield behind his back so dont feel too bad about yourself. Better him than you!");
                    loadoutChoice1 = true;
                    }
                    else if(forward3.equals("ignore it") ||forward3.equals("ignore") ||forward3.equals("go straight") ||forward3.equals("go forward") ||forward3.equals("dont follow the voice") ||forward3.equals("ignore the voice") ||forward3.equals("go straight") ||forward3.equals("walk forward") || forward3.equals("walk straight")){
                        System.out.println("Probably for the best.. you keep following the breeze until things start to get lighter, eventually you find an opening, conviently next to this opening you see a light but rusty sword and shield, nothing special but it works. ");
                        goodStory1 =true;
                        goodStory4 = true;
                        goodStory3 = true;
                        loadoutChoice2 = true;
                    }
                    else if(forward3.equals("go back")||forward3.equals("turn back")||forward3.equals("turn around")||forward3.equals("back")||forward3.equals("backwards")||forward3.equals("run back")|| forward3.equals("back up")||forward3.equals("go backwards")||forward3.equals("run away")){
                        System.out.println(" ");
                        System.out.println("you cant go back now...");
                        System.out.println(" ");
                    }
                    else if(forward3.equals("scream")||forward3.equals("cry")||forward3.equals("nothing")||forward3.equals("freeze")||forward3.equals("do nothing")||forward3.equals("start crying")||forward3.equals("stop")||forward3.equals("stand still")||forward3.equals("stop walking")||forward3.equals("neither")||forward3.equals("scream for help")){
                        System.out.println(" ");
                        System.out.println("you cant go back now...");
                        System.out.println(" ");
                    }
                    else{
                        System.out.println(" ");
                        System.out.println("We didnt test have the budget for more choices. (no whitespace allowed at the end of input either)");
                        System.out.println(" ");
                    }
                    
                }     

            }
            else{
                System.out.println(" ");
                System.out.println("We didnt have the budget for more choices. (no whitespace allowed at the end of input either)");
                System.out.println(" ");
                }
            }
            }    
        }
        else{
            System.out.println(" ");
            System.out.println("We didnt have the budget for more choices. (no whitespace allowed at the end of input either)");
            System.out.println(" ");
        }
        //loadouts
        if(loadoutChoice1==true){
            playerBuild[0] = 100;
            playerBuild[1] = 100;
            playerBuild[2] = 15;
            playerBuild[3] = 5;
            playerBuild[4] = 50;
            System.out.println(" ");
            System.out.println("STANDARD SWORD AQQUIRED +" + playerBuild[2] + " DAMAGE.");
            System.out.println("STANDARD SHIELD AQQUIRED +" + playerBuild[3] + " PROTECTION.");
            System.out.println("STANDARD HEALTHPOT AQQUIRED +" + playerBuild[4] + "HP PER USE.");
            System.out.println(" ");
            System.out.println("PLAYER HEALTH: " + playerBuild[0] + " PLAYER ENERGY: " + playerBuild[1]);
            System.out.println(" ");
            return playerBuild;
        }
        else if(loadoutChoice2==true){
            playerBuild[0]= 100;
            playerBuild[1] = 150;
            playerBuild[2] = 10;
            playerBuild[3] = 3;
            playerBuild[4] = 100;
            System.out.println(" ");
            System.out.println("RUSTY SWORD AQQUIRED +" + playerBuild[2] + " DAMAGE.");
            System.out.println("RUSTY SHIELD AQQUIRED +" + playerBuild[3] + " PROTECTION.");
            System.out.println("LARGE HEALTHPOT AQQUIRED +" + playerBuild[4] + "HP PER USE.");
            System.out.println(" ");
            System.out.println("PLAYER HEALTH: " + playerBuild[0] + " PLAYER ENERGY: " + playerBuild[1]);
            System.out.println(" ");
            return playerBuild;
        }
        else if(loadoutChoice3==true){
            playerBuild[0] = 100;
            playerBuild[1] = 70;
            playerBuild[2] = 25;
            playerBuild[3] = 8;
            playerBuild[4] = 25;
            System.out.println(" ");
            System.out.println("HEAVY SWORD AQQUIRED +" + playerBuild[2] + " DAMAGE.");
            System.out.println("HEAVY SHIELD AQQUIRED +" + playerBuild[3] + " PROTECTION.");
            System.out.println("SMALL HEALTHPOT AQQUIRED +" + playerBuild[4] + "HP PER USE.");
            System.out.println(" ");
            System.out.println("PLAYER HEALTH: " + playerBuild[0] + " PLAYER ENERGY: " + playerBuild[1]);
            System.out.println(" ");
            return playerBuild;
        }
    }
    return playerBuild;
    }
    public static double[] bossLevelUp(double[] bossStats){
        bossStats[0] = bossStats[0] += 100;
        bossStats[1] = bossStats[1] += 10;
        bossStats[2] = bossStats[2] += 30;
        return bossStats;
    }
    public static double[] bossFight(ArrayList<String> bossDialogue, String playerName, double[] playerBuild, double[] bossStats){
        boolean defeated= false;
        playerBuild[0] = playerBuild[0];
        System.out.println("New encounter! " + " It's, " + bossDialogue.get(0) + "!");
        System.out.println(" ");
        System.out.println(bossDialogue.get(0) + ": " + bossDialogue.get(1));
        System.out.println(" ");
        System.out.println("Player health: " + playerBuild[0]);
        System.out.println(" ");
        System.out.println("Player Energy: " + playerBuild[1]);
        System.out.println("Boss Health " + bossStats[0]);
        System.out.println(" ");
        while(defeated!=true){
            if(playerBuild[0] <=0){
                System.out.println(bossDialogue.get(2));
                System.out.println("You died. GAME OVER.");
                System.exit(0);
            }
            else if(playerBuild[1]<0){
                System.out.println(bossDialogue.get(3));
                System.out.println("You passed out. GAME OVER.");
                System.exit(0);
            }
            else if(bossStats[0] <=0){
                System.out.println(bossDialogue.get(4));
                System.out.println(" ");
                System.out.print("spare or defeat?: ");
                String choice = scan.nextLine().toLowerCase();
                if(choice.equals("spare")){
                    System.out.println("You spared " + bossDialogue.get(0) + ".");
                    playerBuild[0] = (playerBuild[0] + 50) + 50;
                    playerBuild[1] = playerBuild[1] + 50;//player energy
                    System.out.println("HEALED FOR 50HP / RESTED FOR 50 ENERGY");
                    System.out.println("LEVEL UP: +50 HP / +50 ENERGY");
                    return playerBuild;
                }
                else if(choice.equals("defeat")){
                    System.out.println("So cruel.. " + bossDialogue.get(0) + " defeated.");
                    playerBuild[0] = playerBuild[0] + 50;
                    playerBuild[1] = playerBuild[1] + 50;
                    playerBuild[2] = playerBuild[2] + 20;
                    playerBuild[3] = playerBuild[3] + 20;
                    System.out.println("HEALED FOR 50HP / RESTED FOR 50 ENERGY");
                    System.out.println("LEVEL UP: +20 ATTACK / +20 PROTECTION!");
                    return playerBuild;
                }
                else{
                    System.out.println("you let your guard down.. " + playerName);
                    System.out.println(bossDialogue.get(0)+ " regains strength and takes a MASSIVE swing for " + (bossStats[2] - playerBuild[3]) + " damage!");
                    bossStats[0] = bossStats[0] + 100;
                    playerBuild[0] = playerBuild[0] - (bossStats[2] - playerBuild[3]);
                }
            }
            else{
                boolean attackCheck = false;
                while(attackCheck!=true){
                System.out.println("How do you want to attack? Light attack(15 Energy) Heavy Attack(40 energy) Heal(1 Use per fight) Rest(+30 Energy)");
                String attack = scan.nextLine().toLowerCase();
                if(attack.equals("light attack")){
                    playerBuild[1] = playerBuild[1] - 15;
                    double critChance = random.nextDouble(1,10);
                    if(critChance>=1 && critChance<=4){
                        bossStats[0] = bossStats[0] - (playerBuild[2] *0.5);
                        System.out.println("Whiffed!");
                        System.out.println("Hit boss for: " + format.format(playerBuild[2] * .5) + " damage. :(");
                        attackCheck = true;
                    }
                    else if(critChance >4 && critChance <=6){
                        bossStats[0] = bossStats[0] - (playerBuild[2] * 1); 
                        System.out.println("Hit boss for: " + format.format(playerBuild[2]) + " damage!");
                        attackCheck = true;
                    }
                    else if(critChance>6 && critChance<=8){
                        bossStats[0] = bossStats[0] - (playerBuild[2] * 1.5);
                        System.out.println(" ");
                        System.out.println("Nice hit!");
                        System.out.println("Hit boss for: " + format.format(playerBuild[2] * 1.5) + " damage!");
                        System.out.println(" ");
                        attackCheck = true;
                    }
                    else if(critChance>8 && critChance<=10){
                        bossStats[0] = bossStats[0] - (playerBuild[2] * 2);
                        System.out.println(" ");
                        System.out.println("CRITICAL hit! ");
                        System.out.println("Hit boss for: " + format.format(playerBuild[2] * 2) + " damage!");
                        System.out.println(" ");
                        attackCheck =true;
                    }
                    else{
                        System.out.println("Critless?");
                    }
                }
                else if(attack.equals("heavy attack")){
                    playerBuild[1] = playerBuild[1] - 40;
                    double critChance = random.nextDouble(1,10);
                    if(critChance>=1 && critChance<=4){
                        bossStats[0] = bossStats[0] - ((playerBuild[2] * 2) *0.5);
                        System.out.println("You whiffed!");
                        System.out.println(playerName + ", hit boss for: " + format.format((playerBuild[2]*2) * .5) + " damage. :(");
                        attackCheck = true;
                    }
                    else if(critChance >4 && critChance <=6){
                        bossStats[0] = bossStats[0] - ((playerBuild[2] * 2) * 1); 
                        System.out.println(playerName + ", hit boss for: " + format.format(playerBuild[2]*2) + " damage!");
                        attackCheck = true;
                    }
                    else if(critChance>6 && critChance<=8){
                        bossStats[0] = bossStats[0] - ((playerBuild[2]*2) * 1.5);
                        System.out.println(" ");
                        System.out.println("Nice hit!");
                        System.out.println(playerName + ", hit boss for: " + format.format((playerBuild[2]*2) * 1.5) + " damage!");
                        System.out.println(" ");
                        attackCheck = true;
                    }
                    else if(critChance>8 && critChance<=10){
                        bossStats[0] = bossStats[0] - (playerBuild[2] * 2);
                        System.out.println(" ");
                        System.out.println("CRITICAL hit!");
                        System.out.println(playerName + ". hit boss for: " + format.format((playerBuild[2]*2) * 2) + " damage!");
                        System.out.println(" ");
                        attackCheck =true;
                    }
                    else{
                        System.out.println("Critless?");
                    }
                }
                else if(attack.equals("heal")){
                    System.out.println("Regained: " + playerBuild[4] + "HP");
                    playerBuild[0] = playerBuild[0] + playerBuild[4];
                    playerBuild[4] = 0;
                    attackCheck=true;
                }
                else if(attack.equals("rest")){
                    bossStats[0] = bossStats[0] + 5;
                    playerBuild[1] = playerBuild[1] + 30;
                    System.out.println("Regained: 30 energy!");
                    System.out.println(bossDialogue.get(0) + "Regained 5 HP!");
                    attackCheck=true;
                }
            }
            //Boss attack
            boolean bossAttack = false;
            while(bossAttack!=true){
            double bossCrit =random.nextDouble(1,10);
            if(bossCrit>=1 && bossCrit<=4){
                playerBuild[0] = playerBuild[0] - (bossStats[1] * 0.5) + playerBuild[3];
                System.out.println(bossDialogue.get(0) + " Whiffed!");
                System.out.println(bossDialogue.get(0) + " attacks for: " + format.format((bossStats[1]* .5) - playerBuild[3]) + " damage. :)");
                System.out.println(" ");
                bossAttack = true;
            }
            else if(bossCrit >4 && bossCrit <=6){
                playerBuild[0] = playerBuild[0] - (bossStats[1] * 1) + playerBuild[3]; 
                System.out.println(bossDialogue.get(0) + " attacks for: " + format.format(bossStats[1] - playerBuild[3]) + " damage.");
                System.out.println(" ");
                bossAttack = true;
            }
            else if(bossCrit>6 && bossCrit<=8){
                playerBuild[0] = playerBuild[0] - (bossStats[1] * 0.5) + playerBuild[3];
                System.out.println("Oof thats gonna hurt..");
                System.out.println(bossDialogue.get(0) + " attacks for: " + format.format((bossStats[1]* 1.5) - playerBuild[3]) + " damage.");
                System.out.println(" ");
                bossAttack = true;

            }
            else if(bossCrit>8 && bossCrit<=10){
                playerBuild[0] = playerBuild[0] - (bossStats[1] * 2) + playerBuild[3];
                System.out.println("CRITICAL hit!");
                System.out.println(bossDialogue.get(0) + " attacks for: " + format.format((bossStats[1]* 2) - playerBuild[3]) + " damage.");
                System.out.println(" ");
                bossAttack = true;
            }
            else{
                System.out.println("boss Critless?");
            }
        }
    }
            System.out.println("current boss health: " + bossStats[0]);
            System.out.println("Current player health: " + playerBuild[0]);
            System.out.println("Current player energy " + playerBuild[1]);
            System.out.println(" ");
        }
        return playerBuild;
    }   
}

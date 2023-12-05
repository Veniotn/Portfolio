import java.util.Scanner;

public class NickBoxPartyPack {
    public static Scanner scanner = new Scanner(System.in); //scanner for reading input.
    
    public static void main(String []args) {
        System.out.println("Welcome to the game, the most game of any game to ever game, You game? Enter your name...");
        String name = scanner.nextLine();
        menu(name);
    }
    
    public static void menu(String name) {
        while(true){
            System.out.println("\n" + name + ", Pick a number between 1-10");
            int answer = scanner.nextInt();
            switch(answer){
                case 10:
                    System.out.println("Just like you, " + name + " a solid 10/10! lets get real, " + name + " we didnt have the budget to code all of these games so you're gonna have to be happy with these. [1]Cyberpunk2077 RARE [2]DarkSouls 4 [3]Mario Kart 10\n"); 
                    chooseGame(name);
                    break;
                case 9:
                    System.out.println("10110010 ArE1000010 we 101011 not GOOD 10001 enough f0r you " + name + "? you know what " + name + " thats okay, pick your 10/10. [1]Cyberpunk2077 RARE [2]DarkSouls 4 [3]Mario Kart 10\n");
                    chooseGame(name);
                    break;
                case 8:
                    System.out.println("8 is great, we love 8! Thank you " + name + " we cannot wait to brag to our m8! Who is also pretty good. Pick your game. [1]Cyberpunk2077 RARE [2]DarkSouls 4 [3]Mario Kart 10\n");
                    chooseGame(name);
                    break;
                case 7:
                    System.out.println("we dont have 7 games but we do have 3, and trust me " + name + " they're really good. Take your pick. [1]Cyberpunk2077 RARE [2]DarkSouls 4 [3]Mario Kart 10\n");
                    chooseGame(name);
                    break;
                case 6:
                    System.out.println("2,4,6 wait.... you never told us this was YOUR favorite number " + name + " now you are legally obligated to play our games! Choose one. [1]Cyberpunk2077 RARE [2]DarkSouls 4 [3]Mario Kart 10\n");
                    chooseGame(name);
                    break;
                case 5:
                    System.out.println("I respect it " + name + " you like to keep it cool, right down the middle, I get it, I really do, I respect your time so ll keep it simple for you. " + name + " [2]Darksouls 4 [2]Darksouls 4 [2]Darksouls 4");
                    chooseGame(name);
                    break;
                case 4:
                    System.out.println("4 score and 4 games ago, we thought of this game. But we never followed through.. Thats until YOU " + name + " came along and now we just HAVE to make it! pick your game. [1]Cyberpunk2077 RARE [2]DarkSouls 4 [3]Mario Kart 10\n");
                    chooseGame(name);
                    break;
                case 3:
                    System.out.println("WOW " + name + " you guessed it! You got it right! there was orignally only 2 games but we needed to add an extra game as a day 1 patch, and you " + name + " get to test it! [1]Cyberpunk2077 RARE [2]DarkSouls 4 [3]Mario Kart 10\n");
                    chooseGame(name);
                    break;
                case 2:
                    System.out.println("Theres only Two devs on this dev team you know.. Me and YOU " + name + "! Because you're about to choose what game we make, in real time! [1]Cyberpunk2077 RARE [2]DarkSouls 4 [3]Mario Kart 10\n");
                    chooseGame(name);
                    break;
                case 1:
                    System.out.println("#1 game of the year material is what were about to be " + name + " and we'll show you why! Take your pick. [1]Cyberpunk2077 RARE [2]DarkSouls 4 [3]Mario Kart 10\n");
                    chooseGame(name);
                    break;
                case 0:
                    System.out.println("wow you broke it, good job..");
                    break;
                default:
                    System.out.println("wow. so edgy.. Try Again");
                    menu(name);
                }
                return;
            }
        }

    public static void chooseGame(String name) {
        while (true) {
            int answer = scanner.nextInt();
            scanner.nextLine();
            
            if (answer == 1) {
                while (true) {
                    System.out.println("Welcome to CyberPunk2077 " + name + "! What life path would you like to choose? [nomad] [corpo] [street kid]");
                    String lifepath = scanner.nextLine();

                    if (lifepath.equals("nomad")) {
                        System.out.println("You spend your days in the desert asking yourself, where is Panam?... you die of thirst. GAME OVER.\n");
                        break;
                    }
                    else if (lifepath.equals("Nomad")) {
                        System.out.println("YoU SpeNd yoUr daYs in tHe deSert asKing yOurSelf, whEre is paNam?... you die of thirst. GAME OVER.\n");
                        break;
                    }
                    else if (lifepath.equals("corpo")) {
                        System.out.println("You spend your days watching over the lower class of Night City, constantly reminding everyone around you just how much better you are than everyone else until one day you face a Cyber Psycho resembling Johnny Silverhand on your way to work... you reach for your budget arms but its too late. GAME OVER \n");
                        break;
                    }
                    else if (lifepath.equals("Corpo")) {
                        System.out.println("YoU sPeNd yOur daYs waTChing ovEr tHe lOwer cLAss oF NiGht CiTy, consTantly reMiNding evErYone arOUnd you jUst hOw mUCh beTTer yOu ARe thaN evERyoNe elSe uNTil oNe Day y0u faCE a Cyber Psycho resembling jOHnny SilvErhand on yOUr wAY to WoRk... yOu rEAch fOR yOUr buDGet aRms bUt iTs YOu lATe. GAME OVER \n");
                        break;
                    }
                    else if (lifepath.equals("street kid")) {
                        System.out.println("You spend your days buying and selling rare DBS on the Net, everything is going well until one day your \"business\" partner sends you a link thats just too good to be true. It was. You slip on black ice. GAME OVER\n");
                        break;
                    }
                    else if (lifepath.equals("Street kid")) {
                        System.out.println("You sPenD yOUr dAys buYIng aNd seLlIng rAre DBS oN tHe Net, eVerYthIng iS gOIng wELl unTil oNe dAy yOUr \"business\" pARtner sENds yOu a lINk tHAts jUSt toO gOod To bE trUe. It wAs. YoO slIp on bLack iCe. GAME OVER\n");
                        break;
                    }
                    else if (lifepath.equals("exit")) {
                        break;
                    }
                    else {
                        System.out.println("There is no such thing as free will.\n");
                    }
                }
                break;
            }
            else if (answer == 2) {
                System.out.println("Welcome to Dark Souls. You die. GAME OVER\n");
                break;
            }
            else if (answer == 3) {
                System.out.println("Welcome to Mario Kart 10.... DMCA TAKEDOWN NOTICE NINTENDO AMERICA...... wow... that was quick.. GAME OVER\n");
                break;
            }
            else {
                System.out.println("WRONG. try again."); 
            }
        }
        menu(name);
    }
}

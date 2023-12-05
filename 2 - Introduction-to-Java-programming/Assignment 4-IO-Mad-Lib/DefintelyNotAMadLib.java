import java.io.*; //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/class-use/File.html
import java.util.ArrayList; //https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
import java.util.List; //https://docs.oracle.com/javase/8/docs/api/java/util/List.html
import java.util.Scanner; //https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
//ready for marking
public class DefintelyNotAMadLib{
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("The Itsy Bitsy Aardvark");
        System.out.println(" ");
        try{
            //importing the contents of the choice file and the story file
            File inputFile = new File("the_choices_file.csv");
            File theStory = new File("the_story_file.txt");
            BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
            BufferedReader storyReader = new BufferedReader(new FileReader(theStory)); 
            //Adding the contents into their own arrayLists
            ArrayList<String> input = new ArrayList<String>();
            String line;
            while((line = inputReader.readLine()) !=null){
                    input.add(line);
            }
            ArrayList<String> story = new ArrayList<String>();
            String storyLine;                                                       
            while((storyLine = storyReader.readLine()) !=null){
                    story.add(storyLine);
            }
            //taking each line of the input file and turning them into their own sublists, then converting those sublists into arrays to get access to each word in the line
            List<String> animalList = input.subList(0, 1);
            String[] animals = animalList.get(0).split(",");
            List<String> actionList = input.subList(1, 2);
            String[] actions = actionList.get(0).split(",");
            List<String> adjectiveList = input.subList(2, 3);
            String[] adjectives = adjectiveList.get(0).split(",");
            List<String> actionList2 = input.subList(3, 4);
            String[] actions2 = actionList2.get(0).split(",");
            List<String> nounList = input.subList(4, 5);
            String[] nouns = nounList.get(0).split(",");
            List<String> actionList3 = input.subList(5, 6);
            String[] actions3 = actionList3.get(0).split(",");
            List<String> adverbList = input.subList(6, 7);
            String[] adverbs = adverbList.get(0).split(",");
            //getting the words we are going to replace the blank spaces of the story with
            String animalChoice = getInput(animals);
            String actionChoice = getInput(actions);
            String adjectiveChoice = getInput(adjectives);
            String actionChoice2 = getInput(actions2);
            String nounsChoice = getInput(nouns);
            String actionChoice3 = getInput(actions3);
            String adverbChoice = getInput(adverbs);
            //putting those choices together and printing the final story
            String finalStory = madlibAdjacent(story,animalChoice,actionChoice,adjectiveChoice,actionChoice2,nounsChoice,actionChoice3,adverbChoice);
            System.out.println("Your completed story: ");
            System.out.println(finalStory);
            //preventing memory leaks/catching IOException
            scan.close();
            inputReader.close();
            storyReader.close();
        } catch(IOException e){
            System.out.println("Error.");
        }
    }

    public static String getInput(String[] wordList){
        String storyChoice = "";
        boolean goodInput1 =false;
        while(goodInput1 !=true){   
        // prompting the user with their choices for words    
        System.out.println(wordList[0]); 
        System.out.println("a) " + wordList[1]);
        System.out.println("b) " + wordList[2]);
        System.out.println("c) " + wordList[3]);
        System.out.println("d) " + wordList[4]);
        System.out.println("e) " + wordList[5]);
        String wordChoice = scan.nextLine();
        System.out.println("");  

            if(wordChoice.equalsIgnoreCase("a")){
                storyChoice = wordList[1];
                goodInput1 = true;

            }
            else if(wordChoice.equalsIgnoreCase("b")){
                storyChoice = wordList[2];
                goodInput1 = true;
            }
            else if(wordChoice.equalsIgnoreCase("c")){
                storyChoice = wordList[3];
                goodInput1 = true;
            }
            else if(wordChoice.equalsIgnoreCase("d")){
                storyChoice = wordList[4];
                goodInput1 = true;
            }
            else if(wordChoice.equalsIgnoreCase("e")){
                storyChoice = wordList[5];
                goodInput1 = true;
            } 
            else{
                System.out.println("Incorrect input. Please choose a letter between a-e: ");
                System.out.println(" ");
            }
        }
        return storyChoice;
    }
    //replacing the blanks in the story with words the user has chosen, changing index for every line of the story
    public static String madlibAdjacent( List<String> story, String choice1,String choice2,String choice3,String choice4,String choice5,String choice6,String choice7){
        String wordReplacement1 = story.get(0).replaceAll("_1_", choice1.toUpperCase());
        String wordReplacement2 = wordReplacement1.replaceAll("_2_", choice2.toUpperCase());
        String wordReplacement3 = wordReplacement2.replaceAll("_3_", choice3.toUpperCase());
        String lineReplacement1 = wordReplacement3;
        String wordReplacement4 = story.get(1).replaceAll("_4_", choice4.toUpperCase());
        String wordReplacement5 = wordReplacement4.replaceAll("_1_", choice1.toUpperCase());
        String lineReplacement2 = wordReplacement5;
        String wordReplacement6 = story.get(2).replaceAll("_5_", choice5.toUpperCase());
        String wordReplacement7 = wordReplacement6.replaceAll("_6_", choice6.toUpperCase());
        String lineReplacement3 = wordReplacement7;
        String wordReplacement8 = story.get(3).replaceAll("_1_", choice1.toUpperCase());
        String wordReplacement9 = wordReplacement8.replaceAll("_7_", choice7.toUpperCase());
        String lineReplacement4 = wordReplacement9;
        String finalStory = lineReplacement1 + "\n" + lineReplacement2 + "\n" + lineReplacement3 + "\n" + lineReplacement4;
        return finalStory;
    }
}

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;

public class  HashMapFunInClass{
        public static void main(String []args){
            HashMap<String, Integer> inventory = new HashMap<String, Integer>();

            inventory.put("t-shirts", 14);
            inventory.put("jeans", 99);
            inventory.put("Turtlenecks", 1000000);

            System.out.println("Is HashMap empty? "+ inventory.isEmpty());
            System.out.println("There are "+ inventory.size() + " object in the Inventory");


            inventory.put("Turtlenecks", inventory.get("Turtle necks ")/2);
            System.out.println("Number of TurtleNecks after first day: " + inventory.get("TurtleNecks")); 


            System.out.println("there are " + inventory.size() + "object in the inventory");

            inventory.replace("Turtlenecks", inventory.get("Turtlenecks") /2);
            System.out.println("Number of TurtleNecks after second day: " + inventory.get("TurtleNecks"));

            inventory.replace("Dickies", inventory.get("TurtleNecks")/2);
            System.out.println("Number of Dickies: " + invetory.get("Dickies"));

            inventory.remove("TurtleNecks");
            System.out.println("There are " + inventory.size() + "object in the Inventory");
            System.out.println("Number of TurtleNecks after last day is over: " + inventory.get("TurtleNecks"));
            // put 
            // replace
            // get
            // remove

    }
}
import java.util.ArrayList;
import java.text.DecimalFormat;


public class ArrayVsArrayList {
    public static void main(String[] args){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);

        long startTime = System.nanoTime();
        arrayWork(10000);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Array Version took: " + decimalFormat.format(duration) + "ns");

        startTime = System.nanoTime();
        arraryListWork(10000);
        endTime = System.nanoTime();

        duration = (endTime - startTime);
        System.out.println("ArraryList Version took: " + decimalFormat.format(duration) + "ns");

    }

    public static void arrayWork(int size){
        int[] myArray = new int[size];
        for (int i=0; i<myArray.length; i++){
            myArray[i]=i;
        }
        for(int i=0; i<myArray.length; i++){
            myArray[i]=myArray[i]+i;
        }
    }

    public static void arraryListWork(int size) {
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for(int i=0; i<size; i++){
            myArray.add(i);
        }
        for(int i=0; i<myArray.size(); i++){
            myArray.set(i, myArray.get(i)+i);
        }
    }
    
}

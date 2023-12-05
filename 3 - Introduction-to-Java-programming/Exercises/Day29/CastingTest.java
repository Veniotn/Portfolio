public class CastingTest {
    public static void main(String[] args) {

        long myLong = 2;

        int myInt = (int) myLong;

        myLong = (long) Integer.MAX_VALUE + 2;

        int i = (int) myLong;
        System.out.println("myInt = " + myInt);
        System.out.println("myLong = " + myLong);
        System.out.println("i = " + i);
        System.out.println();

        myInt = 300;
        short intToShort = (short) myInt;
        byte intToByte = (byte) myInt;
        System.out.println("myInt = " + myInt);
        System.out.println("intToShort = " + intToShort);
        System.out.println("intToByte = " + intToByte);
        System.out.println();


        byte myByte = 2;
        short byteToShort = myByte;
        int byteToInt = myByte;
        long byteToLong = myByte;
        System.out.println("myByte = " + myByte);
        System.out.println("byteToShort = " + byteToShort);
        System.out.println("byteToInt = " + byteToInt);
        System.out.println("byteToLong = " + byteToLong);
        System.out.println();

        short myShort = 257;
        byte shortToByte = (byte) myShort;
        int shortToInt = myShort;
        long shortToLong = myShort;
        System.out.println("myShort = " + myShort);
        System.out.println("shortToByte = " + shortToByte);
        System.out.println("shortToInt = " + shortToInt);
        System.out.println("shortToLong = " + shortToLong);
        System.out.println();


        float myFloat = 1.9f;
        double floatToDouble = myFloat;
        int floatToInt = (int)myFloat;
        System.out.println("myFloat = " + myFloat);
        System.out.println("floatToDouble = " + floatToDouble);
        System.out.println("floatToInt = " + floatToInt);
        System.out.println();


        double myDouble = 1.899999976158142;
        float doubleToFloat = (float)myDouble;
        System.out.println("myDouble = " + myDouble);
        System.out.println("doubleToFloat = " + doubleToFloat);
        System.out.println();
    }
}
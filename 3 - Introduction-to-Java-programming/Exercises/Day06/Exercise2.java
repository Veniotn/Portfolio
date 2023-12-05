public class Exercise2 {
   public static void main(String []ags) {
        int rectangle_length = 8;
        int rectangle_width = 4;
        int rectangle_height = 2;
        int value1 = multiply1(rectangle_width, rectangle_length); 
        int value2 = multiply1(rectangle_height, rectangle_length); 
        int value3 = multiply1(rectangle_height, rectangle_width);
        int answer1 = add(value1, value2, value3);
        int equation = 2;
        int answer2 = multiply1(answer1, equation);
        System.out.println("The area of a rectangluar prisim that is " + rectangle_length + "m in length, " + rectangle_width + "m in width, " + "and " + rectangle_height + "m in height is " + answer2 + "m^2.");
    }


    public static int multiply1(int w1, int w2) {
        int result = w1 * w2;
        return result;
    }

    public static int add(int n1, int n2, int n3) {
        int result2 = n1 + n2 + n3;
        return result2;
    }

} 
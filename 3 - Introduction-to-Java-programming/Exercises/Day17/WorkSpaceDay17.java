public class WorkSpaceDay17 {
    public static void main(String[] args){
        String s = "Hello";
        System.out.println("the character in position 1 is: " + s.charAt (1));

        String s1 = "Hello";
        String s2 = "PROG1700";
        String s3 = s1.concat (s2);
        String s4 = s1+s2;


        System.out.println(s3);
        System.out.println(s1.concat (s2));
        System.out.println(s1+s2);
        System.out.println(s4);

        System.out.println("The index of P is: " + s3.indexOf("p"));
        System.out.println("The index of oP is " + s3.indexOf("oP"));
        System.out.println("The index of l is: " + s3.indexOf("l"));
        System.out.println("The index of l is: " + s3.indexOf("l", s3.indexOf("l") + 1));
        System.out.println("The index of l is: " + s3.lastIndexOf("l"));

        String s5 = "         ";
        String s6 = "";

        System.out.println("Testing if blank for s5" + s5.isBlank() + " and s6: " +s6.isBlank());

        System.out.println("Testing if blank for s5" + s5.isEmpty() + " and s6: " +s6.isEmpty());

        System.out.println("Testing if blank for s5" + s5.trim().isEmpty() + " and s6: " +s6.trim().isEmpty());

        String s7 = s6.trim();
        boolean b1 = s7.isEmpty();

    }
}
package l25hw1;

import java.util.ArrayList;
/*
Прочитать статью, повторить примеры в ней.
https://www.w3schools.com/java/java_wrapper_classes.asp
 */

public class L24HW1 {
    public static void main(String[] args) {
        Integer myInt = 5;
        Double myDouble = 5.99;
        Character myChar = 'A';
        System.out.println(myInt);
        System.out.println(myDouble);
        System.out.println(myChar);

        Integer myInt1 = 5;
        Double myDouble1 = 5.99;
        Character myChar1 = 'A';
        System.out.println(myInt1.intValue());
        System.out.println(myDouble1.doubleValue());
        System.out.println(myChar1.charValue());

        Integer myInt2 = 100;
        String myString = myInt1.toString();
        System.out.println(myString.length());

            ArrayList<Integer> myNumbers = new ArrayList<Integer>();
            myNumbers.add(10);
            myNumbers.add(15);
            myNumbers.add(20);
            myNumbers.add(25);
            for (int i : myNumbers) {
                System.out.println(i);
            }
    }
}

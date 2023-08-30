package my_string;

import java.util.Iterator;

//string is immutable
public class MyStringAppl {
    public static void main(String[] args) {
        MyString myString = new MyString("Two beer, or not two beer"); // создали объект нового класса
        System.out.println(myString);

        Iterator <Character> iterator = myString.iterator();

        while (iterator.hasNext()){
            char ch = iterator.next();
            if (ch == 'e'){
                iterator.remove();
            }
        }

        System.out.println(myString);

        iterator = myString.iterator();
        while (iterator.hasNext()){
            char ch = iterator.next();
            System.out.print(Character.toUpperCase(ch));
            }
        System.out.println();


   /*     myString.addChar('!');
        System.out.println(myString);

        myString.removeChar('r');
        System.out.println(myString);

        //напечатать все большими буквами
        // StringBuilder builder = myString.getStr(); //в переменную builder переложили содержание myString с помощью геттера

        System.out.println(builder);
        for (int i = 0; i < builder.length(); i++) {
            char c = builder.charAt(i);
            c = Character.toUpperCase(c);
            System.out.print(c);
        }
        // other user make
        System.out.println();
        builder.setLength(5);
        System.out.println(builder);
        System.out.println(myString);*/

    }
}

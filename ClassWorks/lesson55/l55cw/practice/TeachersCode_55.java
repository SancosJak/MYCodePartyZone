package practice;

import static java.lang.Math.pow;

public class TeachersCode_55 {
    public static void main(String[] args) {
        TempFuncInterface tempFuncInterface = (int x) -> {
            if (x % 2 == 0) {
                System.out.println("FuncInt it is even number");
            } else {
                System.out.println("FuncInt it is odd number");
            }
        };

        TempFuncInterface powOfCube = (int x) -> System.out.println(x * x * x);

        TempFuncInterfaceImpl tempFuncInterfaceImpl = new TempFuncInterfaceImpl();
        tempFuncInterface.temp(15);
        tempFuncInterfaceImpl.temp(15);
        powOfCube.temp(15);


        tempFuncInterfaceImpl.sayHello();
        tempFuncInterface.sayHello();
        TempFuncInterface.sayStaticHello();

        pow(2, 4);

        String str1 = "hello";
        String str2 = "good bye!";

        str1.length();
        str2.length();


        SecondFuncInterface secondFuncInterface = TeachersCode_55::sayHello;
        SecondFuncInterface anotherOne = TeachersCode_55::new;

        anotherOne.doSomething();
    }

    static void sayHello() {
        System.out.println("hello");
    }

    public TeachersCode_55() {
        System.out.println("constructor");
    }
}

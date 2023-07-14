package l24hw3;
/*
Напишите приложение для вывода минимальных/максимальных значений заданных примитивных типов.
Типы как объекты String должны браться из аргументов основной функции.
Если в аргументах нет какого-либо типа, приложение должно вывести максимальное/минимальное
значения 7 типов (byte, int, short, long, char, float, double).
Если аргументы содержат неправильный тип, приложение должно вывести сообщение:
<argument> Неверный тип.
 */
public class MinMaxTypes {
    public static void main(String[] args) {
        for (String arg : args) {
            switch (arg) {
                case "byte":
                    System.out.printf("Minimum and maximum value of byte: %d, %d%n", Byte.MIN_VALUE, Byte.MAX_VALUE);
                    break;
                case "int":
                    System.out.printf("Minimum and maximum value of int: %d, %d%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    break;
                case "short":
                    System.out.printf("Minimum and maximum value of short: %d, %d%n", Short.MIN_VALUE, Short.MAX_VALUE);
                    break;
                case "long":
                    System.out.printf("Minimum and maximum value of long: %d, %d%n", Long.MIN_VALUE, Long.MAX_VALUE);
                    break;
                case "char":
                    System.out.printf("Minimum and maximum value of char: %d, %d%n", (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);
                    break;
                case "float":
                    System.out.printf("Minimum and maximum value of float: %f, %f%n", Float.MIN_VALUE, Float.MAX_VALUE);
                    break;
                case "double":
                    System.out.printf("Minimum and maximum value of double: %f, %f%n", Double.MIN_VALUE, Double.MAX_VALUE);
                    break;
                default:
                    System.out.println(arg + " is wrong type.");
            }
        }

        if (args.length == 0) {
            System.out.printf("Minimum and maximum value of byte: %d, %d%n", Byte.MIN_VALUE, Byte.MAX_VALUE);
            System.out.printf("Minimum and maximum value of int: %d, %d%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
            System.out.printf("Minimum and maximum value of short: %d, %d%n", Short.MIN_VALUE, Short.MAX_VALUE);
            System.out.printf("Minimum and maximum value of long: %d, %d%n", Long.MIN_VALUE, Long.MAX_VALUE);
            System.out.printf("Minimum and maximum value of char: %d, %d%n", (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);
            System.out.printf("Minimum and maximum value of float: %f, %f%n", Float.MIN_VALUE, Float.MAX_VALUE);
            System.out.printf("Minimum and maximum value of double: %f, %f%n", Double.MIN_VALUE, Double.MAX_VALUE);

        }
    }
}

public class WrapperClassesAppl {
    public static void main(String[] args) {
        System.out.println("======Digits number in number=====");

        Integer x = 1000;
        String st = x.toString();
        System.out.println("Number of digits in " + x + " is = " + st.length());

        Double y = 123.31;
        String st1 = y.toString();
        System.out.println("Number of digits in " + y + " is = " + st1.length());

        // Methods with const classes
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);

        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);


    }
}

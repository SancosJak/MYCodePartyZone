package code;

public class JsonWrapper1Appl {
    public static void main(String[] args) {
        //Generics - параметры для классов и методов
        // {name : Sasha; age : 28; ....} - так выглядит json
        // {value : 60}
        JsonWrapper1 wrapper1 = new JsonWrapper1("10");
        System.out.println(wrapper1);
        System.out.println();
        Integer a = (Integer) wrapper1.getValue();
    }
}

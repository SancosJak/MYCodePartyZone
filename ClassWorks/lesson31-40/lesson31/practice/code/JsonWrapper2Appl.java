package code;

public class JsonWrapper2Appl {
    public static void main(String[] args) {
        JsonWrapper2 <Long> wrapper2 = new JsonWrapper2<>(20L);
        System.out.println(wrapper2);
        Long a = wrapper2.getValue();
        System.out.println(a);

        JsonWrapper2 <Integer> wrapper3 = new JsonWrapper2<>(30);
        System.out.println(wrapper3);
        Integer a1 = wrapper3.getValue();
        System.out.println(a1);
    }
}

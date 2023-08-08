package l24hw2;
/*
Оформить решение квадратного уравнения как класс с необходимыми методами, в решении использовать
переменные типа классов-оберток, сделать необходимые тесты.
 */
public class QuadEquaSolAppl {
    public static void main(String[] args) {
        QuadEquaSol equation1 = new QuadEquaSol(1.0, -5.0, 6.0);
        equation1.solve();

        QuadEquaSol equation2 = new QuadEquaSol(1.0, -4.0, 4.0);
        equation2.solve();

        QuadEquaSol equation3 = new QuadEquaSol(2.0, 3.0, 4.0);
        equation3.solve();
    }
}

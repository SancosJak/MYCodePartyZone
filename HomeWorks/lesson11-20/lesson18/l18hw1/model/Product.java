package l18hw1.model;

public class Product {
        public double price;
        public String name;
        public long barCode;

public Product (double price, String name, long barCode) {
        this.price = price;
        this.name = name;
        this.barCode = barCode;
        }
@Override
public String toString() {
        return "Product {" +
        " price = " + price +
        ", name = '" + name + '\'' +
        ", barCode = " + barCode +
        '}';
  }
}
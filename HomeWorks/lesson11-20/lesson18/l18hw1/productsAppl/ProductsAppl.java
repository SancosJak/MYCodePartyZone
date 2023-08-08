package l18hw1.productsAppl;
/*
Создать класс Product, с полями
private double price; private String name; private long barCode;

Создать класс Food расширяющий класс Product с полем private boolean isOutOfDate;, которое отвечает за годность продукта.

Создать класс MeatFood расширяющий класс Food с полем private String meatType;, которое хранит тип мяса, из которого изготовлен продукт.

Создать класс MilkFood расширяющий класс Food с полями private String milkType; private double fat;, которые хранят тип молока и жирность продукта соответственно.

Во всех классах переопределить метод toString.

В классе ProductsAppl создать в методе main создать массив, в котором хранятся как минимум по одному объекту для каждого продукта. Создать метод печатающий все продукты из массива, и метод возвращающий сумму цен всех продуктов в магазине.
 */
import l18hw1.model.MeatFood;
import l18hw1.model.MilkFood;
import l18hw1.model.Food;
import l18hw1.model.Product;

public class ProductsAppl {
    public static void main(String[] args) {
        Product product1 = new Product(2.99, "Coca-Cola", 1234567890);
        Product product2 = new Product(1.79, "Milka chocolate", 14576547);

        Food food1 = new Food(1.19, "Lays chips", 936898710L, true);
        Food food2 = new Food(2.38, "Pringles", 98765789L, false);

        MeatFood meatFood1 = new MeatFood(8.99, "Chicken filets", 2466787690L, true, "Chicken");
        MeatFood meatFood2 = new MeatFood(13.99, "Porterhouse Steak", 2468137896L, false, "Beef");

        MilkFood milkFood1 = new MilkFood(2.49, "Milk", 135792320L, true, "Cow's Milk", 2.5);
        MilkFood milkFood2 = new MilkFood(3.49, "Cheddar", 547924680L, false, "Cheese", 7.5);

        Product[] products = {product1, product2, food1, food2, meatFood1, meatFood2, milkFood1, milkFood2};

        printProducts(products);
        double total = calculateTotalPrice(products);
        System.out.printf("Total price: %.02f", + total);
    }

    public static void printProducts(Product[] products) {
        int length = products.length;
        for (int i = 0; i < length; i++) {
            System.out.println(products[i].toString());
        }
    }
    public static double calculateTotalPrice(Product[] products) {
        double total = 0.0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }
}

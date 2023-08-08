package l18hw2.productsAppl;
import l18hw2.model.Product;
/*
Переопределить метод equals для сравнения объектов класса Product.
В классе ProductsAppl создать метод печатающий в консоль все негодные в пищу продукты.
В методе main вызвать новые методы. Результат их работы напечатать в консоль.
 */

public class ProductsAppl {
    public static void printProducts(Product[] products) {
        System.out.println("All products:");
        for (int i = 0; i < products.length; i++) {
            System.out.print(products[i].getName());
            if (i < products.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }


    public static void printExpiredProducts(Product[] products) {
        System.out.println("Unfit foods:");
        String unfit = "";
        for (Product product : products) {
            if (product.isExpired()) {
                if (!unfit.isEmpty()) {
                    unfit += ", ";
                }
                unfit += product.getName();
            }
        }
        System.out.println(unfit);

    }

    public static void main(String[] args) {
        Product[] products = new Product[11];
        products[0] = new Product("Apple", true);
        products[1] = new Product("Banana", false);
        products[2] = new Product("Milk", true);
        products[3] = new Product("Bread", false);
        products[4] = new Product("Ice cream", true);
        products[5] = new Product("Chips", false);
        products[6] = new Product("Chocolate", true);
        products[7] = new Product("Nuts", false);
        products[8] = new Product("Coca Cola", true);
        products[9] = new Product("Cheese", false);
        products[10] = new Product("Apple", true);

        printProducts(products);
        System.out.println();
        printExpiredProducts(products);
        System.out.println();
        System.out.println("Сheck without equals:");
        System.out.println(products[0]==products[5]);
        System.out.println("Сheck with equals:");
        System.out.println(products[0].equals(products[10]));
    }
}

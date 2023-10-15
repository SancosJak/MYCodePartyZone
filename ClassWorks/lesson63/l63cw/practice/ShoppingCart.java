package practice;

public class ShoppingCart {
    private int itemCount;
    private double totalPrice;

    public ShoppingCart() {
        this.itemCount = 0;
        this.totalPrice = 0.0;
    }

    public void addItem(double price) {
        if (price >= 0) {
            itemCount++;
            totalPrice += price;
        } else {
            throw new IllegalArgumentException("Стоимость товара не может быть отрицательной");
        }
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void empty() {
        itemCount = 0;
        totalPrice = 0.0;
    }
}

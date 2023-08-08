package l18hw1.model;

public class Food extends Product {
    public boolean isOutOfDate;

    public Food(double price, String name, long barCode, boolean isOutOfDate) {
        super(price, name, barCode);
        this.isOutOfDate = isOutOfDate;
    }
    @Override
    public String toString() {
        return "Food {" +
                " price = " + super.price +
                ", name = '" + super.name + '\'' +
                ", barCode = " + super.barCode +
                ", isOutOfDate = " + isOutOfDate +
                '}';
    }
}

package l18hw1.model;

public class MeatFood extends Food {
    public String meatType;

    public MeatFood(double price, String name, long barCode, boolean isOutOfDate, String meatType) {
        super(price, name, barCode, isOutOfDate);
        this.meatType = meatType;
    }

    @Override
    public String toString() {
        return "MeatFood {" +
                " price = " + super.price +
                ", name = '" + super.name + '\'' +
                ", barCode = " + super.barCode +
                ", isOutOfDate = " + super.isOutOfDate +
                ", meatType = '" + meatType + '\'' +
                '}';
    }
}

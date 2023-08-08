package l18hw1.model;

public class MilkFood extends Food {
    public String milkType;
    public double fat;

    public MilkFood(double price, String name, long barCode, boolean isOutOfDate, String milkType, double fat) {
        super(price, name, barCode, isOutOfDate);
        this.milkType = milkType;
        this.fat = fat;
    }
    @Override
    public String toString() {
        return "MilkFood {" +
                " price = " + super.price +
                ", name = '" + super.name + '\'' +
                ", barCode = " + super.barCode +
                ", isOutOfDate = " + super.isOutOfDate +
                ", milkType = '" + milkType + '\'' +
                ", fat = " + fat +
                '}';
    }
}
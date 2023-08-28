package practice.month;

public enum Month {
    // names of const in JAVA always write with UPCase letters

    JAN(31), FEB (28), MAR(31),  APR(30), MAY(31),JUN(30),JUL(31),AUG(31),SEP(30),OCT(31), NOV(30), DEC(31);

    private int days;

    private Month(int days){
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    //метод увеличивает число месяцев
    public Month plusMonth (int qty) { // qty - количество
        int index = ordinal(); // взяли текущий месяц
        index = index + qty; // увеличили
        Month[] values = values(); // определили массив values
        return values[index % values.length]; // index разделили на 12 '% values.length'
    }

    // метод возвращает имя месяца по его номеру
    public static String monthName (int num) {
        Month[] values = values();
        return  values[(num - 1) % values().length].name();
    }

}

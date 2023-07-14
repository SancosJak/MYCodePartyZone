package l18hw2.model;

public class Product {
    public String name;
    public boolean expired;

    public Product(String name, boolean expired) {
        this.name = name;
        this.expired = expired;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        return name.equals(other.name) && expired == other.expired;
    }

    public String getName() {
        return name;
    }

    public boolean isExpired() {
        return expired;
    }
}

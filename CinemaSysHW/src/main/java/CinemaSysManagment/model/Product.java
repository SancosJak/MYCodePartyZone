package CinemaSysManagment.model;

import CinemaSysManagment.dao.IProduct;

public class Product implements IProduct {
    private String name;
    private double price;
    private String description;
    private int stockQuantity;


    public Product(String name, double price, String description, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stockQuantity = stockQuantity;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void reduceStock(int quantity) {
        if (quantity > 0 && stockQuantity >= quantity) {
            stockQuantity -= quantity;
        }
    }

    public void increaseStock(int quantity) {
        if (quantity > 0) {
            stockQuantity += quantity;
        }
    }


}
package com.vostroi.java.beans.autowired;

/**
 * @author tk
 * @date 2019/3/11 22:20
 * @desc
 */
public class Computor {
    private String brand;
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computor{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}

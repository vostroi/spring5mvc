package com.vostroi.java.beans;

/**
 * @author tk
 * @date 2019/3/11 20:59
 * @desc
 */
public class Car {

    private int price;

    private String brand;

    private String location;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Car(int price, String brand, String location) {
        this.price = price;
        this.brand = brand;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", brand='" + brand + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

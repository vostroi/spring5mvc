package com.vostroi.java.beans.annotation;

import org.springframework.stereotype.Component;

/**
 * @author tk
 * @date 2019/3/12 22:00
 * @desc 基于注解来配置Bean
 */
@Component
public class Phone {
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
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}

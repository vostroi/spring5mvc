package com.vostroi.java.beans;

/**
 * @author tk
 * @date 2019/3/10 16:14
 * @desc
 */
public class Hello {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }

    public Hello() {
        System.out.println("Hello init...");
    }

    public Hello(String name) {
        this.name = name;
    }
}

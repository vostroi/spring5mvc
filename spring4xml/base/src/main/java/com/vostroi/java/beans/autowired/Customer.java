package com.vostroi.java.beans.autowired;

/**
 * @author tk
 * @date 2019/3/11 22:20
 * @desc
 */
public class Customer {
    private String name;

    private int age;

    private Address address;

    private Computor computor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Computor getComputor() {
        return computor;
    }

    public void setComputor(Computor computor) {
        this.computor = computor;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", computor=" + computor +
                '}';
    }
}

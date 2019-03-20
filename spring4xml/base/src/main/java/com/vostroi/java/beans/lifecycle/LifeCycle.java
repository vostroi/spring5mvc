package com.vostroi.java.beans.lifecycle;

/**
 * @author tk
 * @date 2019/3/12 20:45
 * @desc 学习Spring bean的生命周期
 */
public class LifeCycle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("LifeCycle setName method...");
        this.name = name;
    }

    @Override
    public String toString() {
        return "LifeCycle{" +
                "name='" + name + '\'' +
                '}';
    }

    public LifeCycle(String name) {
        System.out.println("LifeCycle constructor method with params...");
        this.name = name;
    }

    public LifeCycle() {
        System.out.println("LifeCycle constructor method no params...");
    }

    private void init() {
        System.out.println("LifeCycle init method...");
    }

    private void destroy() {
        System.out.println("LifeCycle destroy method...");
    }
}

package com.vostroi.java.beans.beanfactory;

/**
 * @author tk
 * @date 2019/3/12 21:13
 * @desc
 */
public class MyFactoryBean {
    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public MyFactoryBean(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public String toString() {
        return "MyFactoryBean{" +
                "beanName='" + beanName + '\'' +
                '}';
    }
}

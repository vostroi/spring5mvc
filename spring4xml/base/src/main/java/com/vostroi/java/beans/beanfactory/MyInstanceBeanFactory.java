package com.vostroi.java.beans.beanfactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tk
 * @date 2019/3/12 21:29
 * @desc 实例工厂方法  需要先创建工厂本身  再通过工厂来获取Bean
 */
public class MyInstanceBeanFactory {
    private Map<String, Object> beans = null;

    public MyInstanceBeanFactory() {
        this.beans = new HashMap<>();
        beans.put("bean3", new MyFactoryBean("bean3"));
        beans.put("bean4", new MyFactoryBean("bean4"));
    }

    public Object getBean(String beanName) {
        return beans.get(beanName);
    }
}

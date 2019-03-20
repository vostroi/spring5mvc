package com.vostroi.java.beans.beanfactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tk
 * @date 2019/3/12 21:13
 * @desc 静态工厂方法来配置Bean
 */
public class MyStaticBeanFactory {

    private static Map<String, Object> beans = new HashMap<>();

    static{
        beans.put("bean1", new MyFactoryBean("bean1"));
        beans.put("bean2", new MyFactoryBean("bean2"));
    }

    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }

}

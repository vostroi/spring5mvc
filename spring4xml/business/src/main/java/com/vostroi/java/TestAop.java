package com.vostroi.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tk
 * @date 2019/3/13 23:22
 * @desc
 */
public class TestAop {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/aop.xml");
        Object calculatorService = context.getBean("calculatorService");
        System.out.println(calculatorService);
    }
}

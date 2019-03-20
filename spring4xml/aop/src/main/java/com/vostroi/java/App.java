package com.vostroi.java;

import com.vostroi.java.aop.CalculatorLogProxy;
import com.vostroi.java.aop.CalculatorService;
import com.vostroi.java.aop.CalculatorServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorServiceImpl();


        CalculatorService proxy = new CalculatorLogProxy(calculatorService).getCalculatorProxy();
        int add = proxy.add(1, 2);

        int mul = proxy.mul(2, 3);



    }
}

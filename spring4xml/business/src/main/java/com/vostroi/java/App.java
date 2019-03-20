package com.vostroi.java;

import com.vostroi.java.beans.Car;
import com.vostroi.java.beans.Hello;
import com.vostroi.java.beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        /**
         * 创建Spring的Ioc容器
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        /**
         * 从Spring Ioc容器中获取Bean实例
         */
        Hello hello = (Hello) context.getBean("hello");

        /**
         * 使用Bean实例
         */
        System.out.println("hello = " + hello);

        Car car = (Car) context.getBean("car");
        System.out.println(car);


        Person person = (Person) context.getBean("person");
        System.out.println(person);

        Person person2 = (Person) context.getBean("person2");
        System.out.println(person2);

        Person person3 = (Person) context.getBean("person3");
        System.out.println(person3);

        Person person4 = (Person) context.getBean("person4");
        System.out.println(person4);

    }
}

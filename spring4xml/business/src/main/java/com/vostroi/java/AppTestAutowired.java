package com.vostroi.java;

import com.vostroi.java.beans.autowired.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author tk
 * @date 2019/3/11 22:27
 * @desc
 */
public class AppTestAutowired {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/autowired.xml");
        Customer customer1 = (Customer) context.getBean("customer1");
        System.out.println(customer1);

        Customer customer2 = (Customer) context.getBean("customer2");
        System.out.println(customer2);
        Customer customer3 = (Customer) context.getBean("customer3");
        System.out.println(customer3);
        Customer customer4 = (Customer) context.getBean("customer4");
        System.out.println(customer4);
        // bean的依赖
        /*Customer customer5 = (Customer) context.getBean("customer5");
        System.out.println(customer5);*/


        // 测试使用外部属性文件来配置DataSource
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

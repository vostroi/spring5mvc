package com.vostroi.java;

import com.vostroi.java.beans.beanfactory.MyFactoryBean;
import com.vostroi.java.beans.lifecycle.LifeCycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tk
 * @date 2019/3/12 20:08
 * @desc
 */
public class AppTestLifecycle {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/autowired.xml");

        /**
         * Bean生命周期
         */
        LifeCycle lifeCycle = context.getBean(LifeCycle.class);
        System.out.println(lifeCycle);

        /**
         * 静态工厂方法获取Bean
         */
        MyFactoryBean bean = (MyFactoryBean) context.getBean("myFactoryBean");
        System.out.println(bean);

        /**
         * 实例工厂方法获取Bean
         */
        Object myFactoryBean2 = context.getBean("myFactoryBean2");
        System.out.println(myFactoryBean2);

        /**
         * 通过Spring提供的FacotryBean来获取Bean
         */

        Object myFactoryBean3 = context.getBean("myFactoryBean3");
        System.out.println(myFactoryBean3);

        context.close();
    }
}

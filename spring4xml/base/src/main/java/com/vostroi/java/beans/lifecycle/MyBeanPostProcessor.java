package com.vostroi.java.beans.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author tk
 * @date 2019/3/12 20:54
 * @desc 自定义BeanPostProcessor, 需要实现BeanPostProcessor接口， 并实现方法；
 * 会扫描Ioc容器中的每个Bean，如果需要个性化，需要针对特定的Bean进行操作
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 在Bean的初始化方法之前调用 注意要返回当前处理的Bean
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifeCycle) {
            System.out.println("MyBeanPostProcessor postProcessBeforeInitialization " + bean + ", " + beanName);
        }
        return bean;
    }

    /**
     * 在Bean初始化方法之后调用 注意要返回当前处理的Bean
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof  LifeCycle){
            System.out.println("MyBeanPostProcessor postProcessAfterInitialization " + bean + ", " + beanName);
            LifeCycle lifeCycle = new LifeCycle("小明");
            bean = lifeCycle;
        }

        return bean;
    }
}

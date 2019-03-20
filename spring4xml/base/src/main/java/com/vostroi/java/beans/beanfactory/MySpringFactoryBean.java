package com.vostroi.java.beans.beanfactory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author tk
 * @date 2019/3/12 21:52
 * @desc 通过实现Spring的FactoryBean来自定义FactoryBean; 可以通过MySpringFactoryBean来获取对应的Bean:在整合第三方库的时候常用
 */
public class MySpringFactoryBean implements FactoryBean<MyFactoryBean> {
    /**
     * 可以自定义属性
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取Bean实例
     * @return
     * @throws Exception
     */
    @Override
    public MyFactoryBean getObject() throws Exception {
        return new MyFactoryBean(name);
    }

    @Override
    public Class<?> getObjectType() {
        return MyFactoryBean.class;
    }

    /**
     * 是否单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}

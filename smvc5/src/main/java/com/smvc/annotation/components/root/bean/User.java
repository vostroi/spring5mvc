package com.smvc.annotation.components.root.bean;

import org.springframework.stereotype.Component;

/**
 * @author tk
 * @date 2019/6/11 23:42
 * @desc
 */
@Component
public class User {
    public String name;

    public Integer age = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

package com.vostroi.java.beans.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.Annotation;

/**
 * @author tk
 * @date 2019/3/12 22:00
 * @desc 基于注解来配置Bean
 */
@Repository(value = "phoneDao")
public class PhoneDaoImpl implements PhoneDao{
    public void savePhoen(Phone phone) {
        System.out.println("PhoneDaoImpl save phone = " + phone);
    }

}

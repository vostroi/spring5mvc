package com.vostroi.java.beans.annotation;

import org.springframework.stereotype.Service;

/**
 * @author tk
 * @date 2019/3/12 22:00
 * @desc 基于注解来配置Bean
 */
public interface PhoneService {
    public void addPhone(Phone phone);
}

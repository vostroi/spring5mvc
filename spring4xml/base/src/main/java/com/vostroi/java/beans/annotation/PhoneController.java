package com.vostroi.java.beans.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author tk
 * @date 2019/3/12 22:00
 * @desc 基于注解来配置Bean
 */
@Controller
public class PhoneController {
    /**
     * required=false：如果没有对应的实例 不会报错 但注入为空
     * Autowired:默认是byType; 如果有多个类型相当的Bean, 1.可以使用@Qualifier来指定要要注入的Bean的id；
     * 2.保持属性名和类名一致：比如这里的phoneService与PhoneServiceImpl的beanId一致
     */
    @Autowired(required = false)
    @Qualifier(value = "phoneService")
    private PhoneService phoneService;

    public void addPhone(Phone phone) {

        System.out.println("PhoneController saveT phone = " + phone);

        phoneService.addPhone(phone);
    }
}

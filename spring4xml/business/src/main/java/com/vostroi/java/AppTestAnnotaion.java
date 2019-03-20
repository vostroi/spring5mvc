package com.vostroi.java;

import com.mchange.v2.sql.filter.SynchronizedFilterDataSource;
import com.vostroi.java.beans.annotation.Phone;
import com.vostroi.java.beans.annotation.PhoneController;
import com.vostroi.java.beans.annotation.PhoneDao;
import com.vostroi.java.beans.annotation.genericity.BaseService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.midi.Soundbank;

/**
 * @author tk
 * @date 2019/3/12 22:19
 * @desc
 */
public class AppTestAnnotaion {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/annotation.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        Phone phone = new Phone();
        PhoneController phoneController = (PhoneController) context.getBean("phoneController");
        phone.setBrand("Apple");
        phone.setPrice(4567.8);
        phoneController.addPhone(phone);

        BaseService genericityPhoneService = (BaseService) context.getBean("genericityPhoneService");
        genericityPhoneService.addT(phone);
    }
}

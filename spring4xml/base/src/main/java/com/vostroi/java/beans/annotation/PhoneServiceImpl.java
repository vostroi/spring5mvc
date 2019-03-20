package com.vostroi.java.beans.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tk
 * @date 2019/3/12 22:00
 * @desc 基于注解来配置Bean
 */
@Service(value = "phoneService")
public class PhoneServiceImpl implements PhoneService{
    @Autowired
    private PhoneDao phoneDao;
    @Override
    public void addPhone(Phone phone) {
        System.out.println("PhoneServiceImpl saveT phone =" + phone);
        phoneDao.savePhoen(phone);
    }
}

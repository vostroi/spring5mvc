package com.vostroi.java.beans.annotation.genericity;

import com.vostroi.java.beans.annotation.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tk
 * @date 2019/3/12 23:33
 * @desc BaseRepository 泛型依赖注入：
 */
@Service(value = "genericityPhoneService")
public class PhoneServiceImpl implements BaseService<Phone> {
    @Autowired
    private BaseRepository baseRepository;

    @Override
    public void addT(Phone phone) {
        System.out.println("泛型依赖注入：PhoneServiceImpl addT phone=" + phone);
        baseRepository.saveT(phone);
    }
}

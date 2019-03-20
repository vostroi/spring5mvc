package com.vostroi.java.beans.annotation.genericity;

import com.vostroi.java.beans.annotation.Phone;
import org.springframework.stereotype.Repository;

/**
 * @author tk
 * @date 2019/3/12 23:27
 * @desc
 */
@Repository
public class PhoneRepository implements BaseRepository<Phone> {
    @Override
    public void saveT(Phone phone) {
        System.out.println("泛型依赖注入：PhoneRepository saveT phone = " + phone);
    }
}

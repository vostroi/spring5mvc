package com.java.vostroi.component.dao;

import com.java.vostroi.component.beans.Address;
import com.java.vostroi.component.beans.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tk
 * @date 2019/3/24 16:00
 * @desc
 */
@Component(value = "personDao")
public class PersonDao {
    public List<Person> getAllPerson() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("111", "小明", "xiaoming", new Address("四川", "成都", "高新")));
        list.add(new Person("222", "小王", "", new Address("四川", "南充", "高坪")));
        list.add(new Person("333", "小红", "hong", new Address("四川", "成都", "天府")));
        list.add(new Person("444", "小强", "", new Address("四川", "成都", "大源")));
        return list;
    }

}

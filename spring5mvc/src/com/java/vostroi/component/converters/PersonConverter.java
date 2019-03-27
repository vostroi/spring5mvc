package com.java.vostroi.component.converters;

import com.java.vostroi.component.beans.Address;
import com.java.vostroi.component.beans.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author tk
 * @date 2019/3/25 21:11
 * @desc
 */
@Component
public class PersonConverter implements Converter<String, Person> {
    @Override
    public Person convert(String source) {

        //name-password-province-city-street
        String[] params = source.split("-");

        Address address = new Address(params[2], params[3], params[4]);

        Person person = new Person("", params[0], params[1], address);
        System.out.println(source + "--source--"+ person);
        return person;
    }
}

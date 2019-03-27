package com.java.vostroi.component.beans;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author tk
 * @date 2019/3/21 20:41
 * @desc
 */
@Component
public class Person {

    private String id;

    @NotEmpty
    private String userName;

    private String password;

    private Address address;

    /**
     * 需要配置FormattingConversionServiceFactoryBean转换器
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", birth=" + birth +
                '}';
    }

    public Person(String id, String userName, String password, Address address) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.address = address;
    }
}

package com.vostroi.java.beans;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author tk
 * @date 2019/3/14 22:37
 * @desc
 */
@Component
public class Account implements RowMapper {
    private int id;

    private String name;

    private int balance;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public Account(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Account(resultSet.getInt(1),resultSet.getString(2), resultSet.getInt(3));
    }
}

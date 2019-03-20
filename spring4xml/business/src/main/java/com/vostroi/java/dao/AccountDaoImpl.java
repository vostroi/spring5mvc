package com.vostroi.java.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author tk
 * @date 2019/3/18 21:47
 * @desc
 */
@Repository(value = "accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getBalanceByName(String name) {
        String sql = "select balance from account where name = ?";

        Integer balance = jdbcTemplate.queryForObject(sql, Integer.class, name);

        return balance;
    }

    @Override
    public Integer updateBalanceByName(String name, Integer cost) {
        String sql = "update account set balance = balance - ? where name = ?";

        int result = jdbcTemplate.update(sql, cost, name);

        return result;
    }

}

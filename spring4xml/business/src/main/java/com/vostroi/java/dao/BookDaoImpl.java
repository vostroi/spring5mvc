package com.vostroi.java.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author tk
 * @date 2019/3/18 21:52
 * @desc
 */
@Repository(value = "bookDao")
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getPriceById(String id) {
        String sql = "select price from book where id = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return price;
    }
}

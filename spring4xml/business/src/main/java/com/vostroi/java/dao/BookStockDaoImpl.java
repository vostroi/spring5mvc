package com.vostroi.java.dao;

import com.mchange.v1.identicator.IdentityHashCodeIdenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;

/**
 * @author tk
 * @date 2019/3/18 21:54
 * @desc
 */
@Repository(value = "bookStockDao")
public class BookStockDaoImpl implements BookStockDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getStockByBookId(String bookId) {
        String sql = "select count from book_stock where bookid = ?";

        Integer stock = jdbcTemplate.queryForObject(sql, Integer.class, bookId);

        return stock;
    }

    @Override
    public Integer updateStockByBookId(Integer count, String bookId) {
        String sql = "update book_stock set count = count - ? where bookid = ?";
        int result = jdbcTemplate.update(sql, count, bookId);
        return result;
    }
}

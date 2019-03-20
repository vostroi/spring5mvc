package com.vostroi.java.dao;

/**
 * @author tk
 * @date 2019/3/18 21:46
 * @desc
 */
public interface BookStockDao {
    public Integer getStockByBookId(String bookId);

    public Integer updateStockByBookId(Integer count, String bookId);
}

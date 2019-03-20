package com.vostroi.java.beans.ssh.dao;

import com.vostroi.java.beans.ssh.BookShEntity;

import java.awt.print.Book;

/**
 * @author tk
 * @date 2019/3/18 21:45
 * @desc
 */
public interface BookShDao {

    public Integer getPriceById(String id);


    public void insert(BookShEntity book);

    public void update(BookShEntity book);
}

package com.vostroi.java.beans.ssh.service;

import com.vostroi.java.beans.ssh.AccountShEntity;
import com.vostroi.java.beans.ssh.BookShEntity;
import com.vostroi.java.beans.ssh.dao.AccountShDao;
import com.vostroi.java.beans.ssh.dao.AccountShDaoImpl;
import com.vostroi.java.beans.ssh.dao.BookDaoShImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author tk
 * @date 2019/3/18 21:58
 * @desc
 */
@Service(value = "bookService")
public class BookService {

    @Autowired
    private BookDaoShImpl bookDao;

    @Autowired
    private AccountShDaoImpl accountDao;


    @Transactional(timeout = 2, readOnly = false)
    public void purchase(String name, String bookId, Integer count) {

    }

    @Transactional(readOnly = false)
    public void insertData() {
        BookShEntity book = new BookShEntity(1, "java", "JAVA1", new BigDecimal(123.45), 123);
        AccountShEntity accout = new AccountShEntity(2, "张三2", new BigDecimal(562.34));

        bookDao.insert(book);

//        int i = 9 / 0;

        accountDao.insert(accout);
    }

    @Transactional(readOnly = true)
    public void updateData() {
        BookShEntity book = new BookShEntity(1, "java", "JAVA1", new BigDecimal(123.45), 123);
        AccountShEntity accout = new AccountShEntity(2, "张三2", new BigDecimal(562.34));

        bookDao.update(book);


        accountDao.update(accout);
    }

}

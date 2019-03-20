package com.vostroi.java.service;

import com.vostroi.java.dao.AccountDao;
import com.vostroi.java.dao.BookDaoImpl;
import com.vostroi.java.dao.BookStockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tk
 * @date 2019/3/18 21:58
 * @desc
 */
@Service(value = "bookService")
public class BookService {

    @Autowired
    private BookDaoImpl bookDao;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private BookStockDao bookStockDao;

    @Transactional(timeout = 2, readOnly = false)
    public void purchase(String name, String bookId, Integer count) {

        Integer balance = accountDao.getBalanceByName(name);

        Integer price = bookDao.getPriceById(bookId);

        Integer stock = bookStockDao.getStockByBookId(bookId);

        System.out.println(balance);

        System.out.println(price);

        System.out.println(stock);

        Integer result1 = accountDao.updateBalanceByName(name, count * price);

        Integer result2 = bookStockDao.updateStockByBookId(count, bookId);

        System.out.println(result1);

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(result2);
    }

}

package com.vostroi.java.beans.ssh.dao;

import com.vostroi.java.beans.ssh.BookShEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author tk
 * @date 2019/3/18 21:52
 * @desc
 */
@Repository(value = "bookDao")
public class BookDaoShImpl implements BookShDao {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 获取与当前线程绑定的session
     * @return
     */
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Integer getPriceById(String id) {
        String hql = "select b.price from BookShEntity b where b.id = :id";
        Query query = getSession().createQuery(hql).setParameter(id, id);
        return (Integer) query.uniqueResult();
    }

    @Override
    public void insert(BookShEntity book) {
        getSession().save(book);
    }

    @Override
    public void update(BookShEntity book) {
        getSession().update(book);
    }
}

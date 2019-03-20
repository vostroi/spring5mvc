package com.vostroi.java.beans.ssh.dao;

import com.vostroi.java.beans.ssh.AccountShEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author tk
 * @date 2019/3/18 21:47
 * @desc
 */
@Repository(value = "accountDao")
public class AccountShDaoImpl implements AccountShDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public Integer getBalanceByName(String name) {

        return 0;
    }

    @Override
    public Integer updateBalanceByName(String name, Integer cost) {

        return 0;
    }

    @Override
    public void insert(AccountShEntity accout) {
        getSession().save(accout);

    }

    @Override
    public void update(AccountShEntity account) {
        getSession().update(account);
    }

}

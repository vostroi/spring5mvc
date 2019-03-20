package com.vostroi.java.beans.ssh.dao;

import com.vostroi.java.beans.ssh.AccountShEntity;

/**
 * @author tk
 * @date 2019/3/18 21:43
 * @desc
 */
public interface AccountShDao {

    public Integer getBalanceByName(String name);

    public Integer updateBalanceByName(String name, Integer cost);

    public void insert(AccountShEntity account);

    public void update(AccountShEntity account);
}

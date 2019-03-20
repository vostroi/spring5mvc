package com.vostroi.java.dao;

/**
 * @author tk
 * @date 2019/3/18 21:43
 * @desc
 */
public interface AccountDao {

    public Integer getBalanceByName(String name);

    public Integer updateBalanceByName(String name, Integer cost);
}

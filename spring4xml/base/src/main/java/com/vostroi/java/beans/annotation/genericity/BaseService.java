package com.vostroi.java.beans.annotation.genericity;

import java.util.List;

/**
 * @author tk
 * @date 2019/3/12 23:29
 * @desc
 */
public interface BaseService<T> {
    public void addT(T t);
    public default List<T> getAll(){

        return null;
    }
}

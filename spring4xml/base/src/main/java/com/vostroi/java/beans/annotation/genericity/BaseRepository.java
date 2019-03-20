package com.vostroi.java.beans.annotation.genericity;

/**
 * @author tk
 * @date 2019/3/12 23:25
 * @desc 泛型依赖注入
 */
public interface BaseRepository<T> {

    public void saveT(T t);
}

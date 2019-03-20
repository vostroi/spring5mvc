package com.vostroi.java.aop;

/**
 * @author tk
 * @date 2019/3/13 21:48
 * @desc
 */
public interface CalculatorService {
    /**
     * 加法
     * @param i
     * @param j
     * @return
     */
    public int add(int i, int j);

    /**
     * 减法
     * @param i
     * @param j
     * @return
     */
    public int sub(int i, int j);

    /**
     * 乘法
     * @param i
     * @param j
     * @return
     */
    public int mul(int i, int j);

    /**
     * 除法
     * @param i
     * @param j
     * @return
     */
    public int div(int i, int j);
}

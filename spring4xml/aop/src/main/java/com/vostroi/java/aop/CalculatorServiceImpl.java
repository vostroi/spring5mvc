package com.vostroi.java.aop;

import org.springframework.stereotype.Service;

/**
 * @author tk
 * @date 2019/3/13 21:49
 * @desc
 */
@Service(value = "calculatorService")
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}

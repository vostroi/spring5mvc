package com.vostroi.java.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author tk
 * @date 2019/3/13 21:51
 * @desc
 */
public class CalculatorLogProxy {
    private CalculatorService target;

    public CalculatorLogProxy(CalculatorService calculatorService) {
        this.target = calculatorService;
    }

    public CalculatorService getCalculatorProxy() {
        CalculatorService proxy = null;
        ClassLoader loader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        InvocationHandler handler = new InvocationHandler() {
            /**
             * @param proxy 正在被代理的对象:不能在invoke中使用proxy对象（调用方法又会触发invoke 死循环）
             * @param method 被调用的方法
             * @param args 被调用方法的参数
             * @return 返回值是被调用方法的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("The method " + method.getName() + " start with args " + Arrays.asList(args));
                Object result = method.invoke(target, args);
                System.out.println("The method " + method.getName() + " end with result " + result);
                return result;
            }
        };

        proxy = (CalculatorService) Proxy.newProxyInstance(loader, interfaces, handler);

        return proxy;
    }
}

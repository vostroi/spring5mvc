package com.vostroi.java.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author tk
 * @date 2019/3/13 23:05
 * @desc 日志Aop  声明为切面；需要交给Spring管理；可以用@Order来指定 切面的优先级，值越小，优先级越高
 */
@Order(value = 2)
@Component
@Aspect
public class LogAop {

    /**
     * 在匹配的方法执行之前执行
     * @param joinPoint
     */
//    @Before("com.vostroi.java.aop.AopExecutionUtil.validateArgs()")
    public void beforeMethodLog(JoinPoint joinPoint) {

        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("method " + joinPoint.getSignature().getName() + " start with args " + args);
    }

    /**
     * 在匹配的方法执行之后执行，无论该方法是否异常（因为匹配的方法可能异常，所以拿不到方法的返回值）
     * @param joinPoint
     */
//    @After("com.vostroi.java.aop.AopExecutionUtil.validateArgs()")
    public void afterMethond(JoinPoint joinPoint) {
        System.out.println("method " + joinPoint.getSignature().getName() + " end");
    }

    /**
     * 在匹配的方法正常返回结束后执行；可以访问到方法的返回值
     * @param joinPoint
     */
//    @AfterReturning(value = "com.vostroi.java.aop.AopExecutionUtil.validateArgs()", returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        System.out.println("method " + joinPoint.getSignature().getName() + " return with " + result);
    }

    /**
     * 可以由参数来匹配指定的异常
     * @param joinPoint
     * @param exception 可以指定特定的异常类型，如果异常类型不匹配，本通知也不会执行
     */
//    @AfterThrowing(value = "com.vostroi.java.aop.AopExecutionUtil.validateArgs()" , throwing = "exception")
    public void afterException(JoinPoint joinPoint, NullPointerException exception) {
        System.out.println("method " + joinPoint.getSignature().getName() + " throw exception with " + exception);
    }

    /**
     * 环绕通知-类似于动态代理的全过程
     * @param proceedingJoinPoint 可以决定是否执行目标方法；
     * @return 环绕通知必须有返回值，且返回值就是目标方法的返回值
     */
    @Around(value = "com.vostroi.java.aop.AopExecutionUtil.validateArgs()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(proceedingJoinPoint.getArgs());

        // 在这里实现前置通知功能
        System.out.println("method " + methodName + " start with args " + args);

        // 执行目标方法
        try {
            result = proceedingJoinPoint.proceed();

            // 在这里实现后置通知功能--这里是后置通知，不是返回通知，因为如果执行目标方法异常后，这里的代码不会被执行
            System.out.println("method " + methodName + " end");
        } catch (Throwable throwable) {
            // 在这里实现异常通知的功能
            System.out.println("method " + methodName + " throw exception with " + throwable);
            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        }
        // 在这里实现返回通知的功能
        System.out.println("method " + methodName + " return with " + result);
        return result;
    }
}

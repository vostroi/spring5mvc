package com.vostroi.java.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author tk
 * @date 2019/3/14 21:12
 * @desc 日志验证切面；可以用@Order来指定切面的优先级，值越小，优先级越高
 */
@Order(value = 1)
@Aspect
@Component
public class ValidateAop {

    @Before(value = "com.vostroi.java.aop.AopExecutionUtil.validateArgs()")
    public void validateArgs(JoinPoint joinPoint) {
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("validate emthod " + joinPoint.getSignature().getName() + " args = " + args);
    }
}

package com.vostroi.java.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author tk
 * @date 2019/3/14 21:20
 * @desc AOP公共的切入点表达式，达到让切入点表达式公用的目的（通过“包名.类名.方法名”来使用）; 使用到@Pointcut注解
 */
@Aspect
@Component
public class AopExecutionUtil {

    @Pointcut(value = "execution(* com.vostroi.java.aop.*.*(..))")
    public void validateArgs(){}

}

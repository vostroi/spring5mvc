package com.java.vostroi.component.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author tk
 * @date 2019/3/26 21:55
 * @desc 统一处理系统的异常 使用@ControllerAdvice
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView handleException(Exception ex) {
        System.out.println("MyExceptionHandler handle exception...");
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", ex);
        return modelAndView;
    }
}

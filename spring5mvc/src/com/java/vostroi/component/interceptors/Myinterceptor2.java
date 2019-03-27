package com.java.vostroi.component.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tk
 * @date 2019/3/26 20:45
 * @desc 自定义拦截器
 */
public class Myinterceptor2 implements HandlerInterceptor {

    /**
     * 在目标方法之前调用
     * 如果某一个拦截器的preHandle方法返回false，不会继续执行之后的拦截器和目标方法；
     * 若返回true则继续调用之后的拦截器和目标方法
     * 可以考虑 做权限，日志，事务...功能
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Myinterceptor2 preHandle...");
        return true;
    }

    /**
     * 调用目标方法之后，在渲染视图之前调用
     * 可以对请求域的中属性或者视图作修改
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Myinterceptor2 postHandle...");
    }

    /**
     * 渲染视图之后调用
     * 可以释放资源操作
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Myinterceptor2 afterCompletion...");
    }
}

package com.smvc.annotation.components.web.controller;

import com.smvc.annotation.app.util.DeferredQueueUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import javax.swing.*;
import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @author tk
 * @date 2019/6/16 10:14
 * @desc 异步请求
 */
@Controller
@RequestMapping(value = "async")
public class AsyncController {

    /**
     * 返回Callable
     * springmvc会异步将callable提交到一个隔离的任务执行器中
     * DispatcherServlet和所有的Filter都退出Web容器（Tomcat），但响应仍然保持打开状态
     * callable返回结果，springmvc提交结果给Web容器，恢复之前的处理
     *
     * @return
     */
    @RequestMapping(value = "hello")
    @ResponseBody
    public Callable hello() {

        System.out.println("main thread start..." + Thread.currentThread() + " time..." + System.currentTimeMillis());

        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("async thread start..." + Thread.currentThread() + "time..." + System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println("async thread end..." + Thread.currentThread() + "time..." + System.currentTimeMillis());
                return "AsyncController...";
            }
        };
        System.out.println("main thread end..." + Thread.currentThread() + " time..." + System.currentTimeMillis());
        return callable;
    }


    @ResponseBody
    @GetMapping(value = "defer")
    public DeferredResult<Object> createOrder() {

        DeferredResult result = new DeferredResult(3000l, "create order time out...");
        DeferredQueueUtil.add2Queue(result);

        return result;
    }

    @ResponseBody
    @GetMapping(value = "setResult")
    public String pollQueue() {
        DeferredResult result = DeferredQueueUtil.get();
        String orderid = UUID.randomUUID().toString();
        result.setResult("order id = " + orderid);
        return "order id = " + orderid;
    }
}

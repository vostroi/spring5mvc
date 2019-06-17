package com.smvc.annotation.app.util;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author tk
 * @date 2019/6/16 23:03
 * @desc
 */
public class DeferredQueueUtil {
    private static Queue<DeferredResult> queue = new ConcurrentLinkedQueue<>();

    public static void add2Queue(DeferredResult result) {
        queue.add(result);
    }

    public static DeferredResult get() {
        return queue.poll();
    }
}

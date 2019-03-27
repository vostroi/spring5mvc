package com.java.vostroi.component.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author tk
 * @date 2019/3/26 22:06
 * @desc ResponseStatus标在类上统一处理异常情况，优先级低于@ExceptionHandler和@ControllerAdvice，
 * 也可以标记在Controller的方法上，目标方法成功执行后起作用
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "测试将异常转换为Http状态返回")
public class MyException extends RuntimeException {

}

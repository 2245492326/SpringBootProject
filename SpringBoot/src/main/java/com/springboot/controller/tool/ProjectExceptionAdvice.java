package com.springboot.controller.tool;

import com.springboot.exception.BusinessException;
import com.springboot.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//需要被SpringMVC加载上
public class ProjectExceptionAdvice {
    //业务异常
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex) {
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    //系统异常
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex) {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    //其他未知异常
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex) {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        System.out.println(ex);
        return new Result(Code.SYSTEM_UNKNOW_ERR, null, "系统繁忙, 请稍后重试");
    }
}

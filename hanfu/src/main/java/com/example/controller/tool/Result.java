package com.example.controller.tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设置统一数据返回结果类
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    //状态码
    private Integer status;

    //返回数据
    private Object data;

    //返回消息
    private String message;

    public Result(Integer code, Object data) {
        this.status = code;
        this.data = data;
    }
}

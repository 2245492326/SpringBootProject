package com.example.controller.test;

public class Code {
    //操作成功
    public static final Integer POST_OK = 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer PUT_OK = 20031;
    public static final Integer GET_OK = 20041;

    //操作失败
    public static final Integer POST_ERR = 40010;
    public static final Integer DELETE_ERR = 40020;
    public static final Integer PUT_ERR = 40030;
    public static final Integer GET_ERR = 40040;

    //业务异常
    public static final Integer BUSINESS_ERR = 50010;
    //系统异常
    public static final Integer SYSTEM_ERR = 50020;
    //未知异常
    public static final Integer SYSTEM_UNKNOW_ERR = 59999;
}
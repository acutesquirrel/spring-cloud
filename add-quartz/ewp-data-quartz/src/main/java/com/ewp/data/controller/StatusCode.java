package com.ewp.data.controller;

import com.ewp.data.RestStatus;
import com.google.common.collect.ImmutableMap;

/**
 * @author zhanglm
 */
public enum StatusCode implements RestStatus {

	OK(20000, "请求成功"),
	
	/**
     * 用于根据模板id查询模板信息不存在的情况
     */
	MSGTEMPLATE_NOT_EXISTS(30001, "模板信息不存在"),
	
    // 40xxx 客户端不合法的请求
    INVALID_MODEL_FIELDS(40001, "字段校验非法"),

    /**
     * 参数类型非法，常见于SpringMVC中String无法找到对应的enum而抛出的异常
     */
    INVALID_PARAMS_CONVERSION(40002, "参数类型非法"),

    // 41xxx 请求方式出错
    /**
     * http media type not supported
     */
    HTTP_MESSAGE_NOT_READABLE(41001, "HTTP消息不可读"),

    /**
     * 请求方式非法
     */
    REQUEST_METHOD_NOT_SUPPORTED(41002, "不支持的HTTP请求方法"),

    // 成功接收请求, 但是处理失败
    /**
     * Duplicate Key
     */
    DUPLICATE_KEY(42001, "操作过快, 请稍后再试"),

    /**
     * 用于注册时用户已经存在的情况
     */
    USER_EXISTS(42002, "菜单不存在, 请尝试登录"),

    /**
     * 用于登录时用户不存在的情况
     */
    USER_NOT_EXISTS(42003, "用户不存在, 请先注册"),

    /**
     * 凭证错误
     */
    INVALID_CREDENTIAL(42004, "用户名或密码错误"),
    
    /**
     * 要发送短信状态为空
     */
    SMS_STATE_WRONG(45020, "要发送短信状态为空！"),
    
    /**
     * 查询待发送信息失败
     */
    TO_SENDSMS_FAILE(45021, "查询待发送信息失败！"),
    /**
     * 用户余额不足
     */
    INSUFFICIENT_BALANCE(42005, "用户余额不足"),
    
    /**
     * 企业基本信息不存在
     */
    COMPANYBASEINFO_NOT_EXISTS(42006,"企业基本信息不存在"),
    /**
     * 企业员工不存在
     */
    USERSTAFF_NOT_EXISTS(42007,"企业员工不存在"),
    
    
    
    // 50xxx 服务端异常
    /**
     * 用于处理未知的服务端错误
     */
    SERVER_UNKNOWN_ERROR(50001, "服务端异常, 请稍后再试");

    private final int code;

    private final String message;

    private static final ImmutableMap<Integer, StatusCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, StatusCode> builder = ImmutableMap.builder();
        for (StatusCode statusCode : values()) {
            builder.put(statusCode.code(), statusCode);
        }
        CACHE = builder.build();
    }

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static StatusCode valueOfCode(int code) {
        final StatusCode status = CACHE.get(code);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }
        return status;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

}

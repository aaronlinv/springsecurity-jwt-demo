package com.al._01springsecuritydemo01.common;

import java.util.HashMap;

/**
 * API 接口返回结果封装
 */
public class RestResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    // 状态码
    public static final String CODE_TAG = "code";
    // 返回内容
    public static final String MSG_TAG = "msg";
    // 数据对象
    public static final String DATA_TAG = "data";

    public RestResult() {

    }

    public RestResult(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    public RestResult(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (data != null) {
            super.put(DATA_TAG, data);
        }
    }

    public static RestResult success() {
        return new RestResult(200, "成功");
    }
}

package com.action.enums;

/**
 * Created by Liuran1991 on 2019/4/19.
 */
public enum EmRetCode {
    SUCCESS(0,"成功"),
    DEFINED_EXCEPTION(200, "%s"),
    FAILED_MESSAGE(500, "%s失败，请稍后再试"),
    NETWORK_EXCEPTION(500, "网络异常，请稍后再试"),
    OPERATION_FAILURE(500, "操作失败"),
    PARAM_IS_NULL(10001, "缺少参数: %s[%s]"),
    ILLEGAL_PARAM(10002, "输入参数: %s[%s]不正确");

    private Integer code;
    private String message;

    EmRetCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.suyan.base.domain;

public enum ResultCode {

    SUCCESS(200, "Success"),
    SYS_ERROR(500, "系统错误s"),

    C600(600, "用户未登录"),
    C601(601, "登录失效，请重新登录"),
    C602(602, "用户名和密码不匹配"),
    C603(603, "您的账号已经被禁用，请联系管理员"),
    C604(604, "账号已停用"),

    /**
     * 公用错误
     */
    COMMON_MESSAGE(1000, "%s"),

    ;


    public int code;
    public String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

package com.zrt.score.enums;
//定义枚举
public enum ResultEnum {

    UNKONW_ERROR(0, "未知错误"),
    SUCCESS(1, "成功"),
    MORE(2,"成绩不能大于100"),
    LESS(3,"成绩不能小于0"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}

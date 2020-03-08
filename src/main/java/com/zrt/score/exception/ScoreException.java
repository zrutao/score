package com.zrt.score.exception;

import com.zrt.score.enums.ResultEnum;

public class ScoreException extends RuntimeException {
    private Integer code;

    public ScoreException(ResultEnum resultEnum)
    {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

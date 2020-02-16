package com.taiheblog.result;

import com.taiheblog.enums.ResultEnums;
import lombok.Data;

@Data
public class AjaxResult<T> {
    private Integer code;
    private String message;
    private T data;

    public AjaxResult(ResultEnums enums) {
        this.code = enums.getCode();
        this.message = enums.getMessage();
    }
    public AjaxResult(ResultEnums enums, T data) {
        this.code = enums.getCode();
        this.message = enums.getMessage();
        this.data = data;
    }

}



package com.taiheblog.advice;

import com.taiheblog.exception.ThException;
import com.taiheblog.result.AjaxResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(ThException.class)
    public AjaxResult handlerException(ThException e){
        return new AjaxResult(e.getExceptionEnums());
    }
}


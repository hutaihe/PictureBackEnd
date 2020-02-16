package com.taiheblog.exception;

import com.taiheblog.enums.ResultEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ThException extends RuntimeException {
    private ResultEnums exceptionEnums;
}

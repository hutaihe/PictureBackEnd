package com.taiheblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ResultEnums {
    OPERATION_SUCCESS(200, "操作成功！"),
    FILE_UPLOAD_SUCCESS (200,"文件上传成功！") ,
    SAVE_USER_SUCCESS (200,"保存用户成功！") ,
    UPDATE_USER_SUCCESS (200,"修改用户成功！"),
    UPDATE_USER_ERROR (200,"修改用户失败！"),
    DELETE_USER_SUCCESS(200,"删除用户成功！"),
    USER_NOT_FIND(500, "用户没有发现！"),
    ACCOUNT_OR_PASSWORD_ERROR (500,"账号或密码错误！"),
    PAGE_USER_NOT_FIND (500,"暂无数据！"),
    USER_ALREADY_EXISTENTCE (500,"用户已经存在！"),
    SAVE_USER_ERROR (500,"保存用户失败！"),
    INVALID_FILE_TYPE (500,"文件类型有误！"),
    UPLOAD_FILE_ERROR (500,"文件上传失败！"),
    DELETE_USER_ERROR (500,"删除用户失败！") ;
    private Integer code;
    private String message;
}

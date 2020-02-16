package com.taiheblog.vo;

import lombok.Data;

/**
 * 分页参数
 */
@Data
public class PageParams {
    private Integer id; //用户id
    private Integer pageno; //当前页
    private Integer pagesize; //一页多少条
    private String account; //账号
    private String email; //邮箱
    private String sex; //性别

}

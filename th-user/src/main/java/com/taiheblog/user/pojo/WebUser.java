package com.taiheblog.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "th_webuser")
public class WebUser {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String username;
    private String account;
    private String password;
    private String phone;
    private String email;
    private String sex;
    private String imageurl;
    private String describes;
}

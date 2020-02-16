package com.taiheblog.user.pojo;

import lombok.Data;

@Data
public class Permission {
    private Integer id;
    private Integer parentid;
    private String name;
    private String icon;
    private String url;
}

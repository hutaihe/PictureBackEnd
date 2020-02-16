package com.taiheblog.user.mapper;


import com.taiheblog.user.pojo.WebUser;
import tk.mybatis.mapper.common.Mapper;

public interface WebUserMapper extends Mapper<WebUser> {
    WebUser getWebUserById(Integer id);

    WebUser selectWebUserByAccount(String account);
}

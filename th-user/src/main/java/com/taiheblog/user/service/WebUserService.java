package com.taiheblog.user.service;


import com.taiheblog.user.pojo.WebUser;
import com.taiheblog.vo.Page;
import com.taiheblog.vo.PageParams;

public interface WebUserService {
     WebUser getWebUserById(Integer id);

    Page<WebUser> getWebUserByPage(PageParams pageParams);

    Integer saveWebUser(WebUser webuser);

    Integer updateWebUser(WebUser webuser);

    Integer deleteWebUser(Integer id);

    Integer deleteWebUserByIds(Integer[] ids);
}

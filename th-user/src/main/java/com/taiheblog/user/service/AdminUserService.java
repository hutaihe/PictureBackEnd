package com.taiheblog.user.service;


import com.taiheblog.user.pojo.AdminUser;
import com.taiheblog.vo.Page;
import com.taiheblog.vo.PageParams;


public interface AdminUserService {
     AdminUser getAdminUserById(Integer id);

     AdminUser getAdminByAccountAndPassword(String username, String password);

    Page<AdminUser> getAdminUserByPage(PageParams pageParams);

    Integer saveAdminUser(AdminUser adminuser);

    Integer updateAdminUser(AdminUser adminuser);

    Integer deleteAdminUser(Integer id);

    Integer deleteAdminUserByIds(Integer[] ids);
}

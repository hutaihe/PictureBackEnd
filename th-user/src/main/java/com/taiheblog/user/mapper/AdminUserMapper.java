package com.taiheblog.user.mapper;


import com.taiheblog.user.pojo.AdminUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AdminUserMapper extends Mapper<AdminUser> {
     AdminUser getAdminUserById(Integer id);

     AdminUser getAdminByAccountAndPassword(@Param("username")String username, @Param("password") String password);
}

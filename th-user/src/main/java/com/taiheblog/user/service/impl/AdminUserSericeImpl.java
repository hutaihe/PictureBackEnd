package com.taiheblog.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiheblog.enums.ResultEnums;
import com.taiheblog.exception.ThException;

import com.taiheblog.user.mapper.AdminUserMapper;
import com.taiheblog.user.mapper.WebUserMapper;
import com.taiheblog.user.pojo.AdminUser;
import com.taiheblog.user.pojo.WebUser;
import com.taiheblog.user.service.AdminUserService;
import com.taiheblog.user.service.WebUserService;
import com.taiheblog.vo.Page;
import com.taiheblog.vo.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AdminUserSericeImpl implements AdminUserService {
    @Autowired
    public AdminUserMapper adminUserMapper;

    @Override
    public AdminUser getAdminUserById(Integer id) {
        AdminUser user = adminUserMapper.getAdminUserById(id);
        if (user == null) throw new ThException(ResultEnums.USER_NOT_FIND);
        return user;
    }

    @Override
    public AdminUser getAdminByAccountAndPassword(String username, String password) {
        return null;
    }

    @Override
    public Page<AdminUser> getAdminUserByPage(PageParams pageParams) {
        PageHelper.startPage(pageParams.getPageno(),pageParams.getPagesize());
        Example example = new Example(AdminUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(pageParams.getId() != null){
            criteria.andEqualTo("id",pageParams.getId());
        }
        if(pageParams.getAccount() != null){
            criteria.andLike("account","%"+pageParams.getAccount().trim()+"%");
        }
        if(pageParams.getEmail() != null){
            criteria.andLike("email","%"+pageParams.getEmail().trim()+"%");
        }
        if(pageParams.getSex()!= null){
            criteria.andLike("sex","%"+pageParams.getSex()+"%");
        }
        List<AdminUser> adminUsers = adminUserMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(adminUsers)){
            throw new ThException(ResultEnums.PAGE_USER_NOT_FIND);
        }
        PageInfo<AdminUser> pageInfo = new PageInfo<>(adminUsers);
        Integer totalsize = (int)pageInfo.getTotal();
        Page<AdminUser> page = new Page<>();
        page.setTotalsize((int)pageInfo.getTotal());
        page.setList(adminUsers);
        page.setPageno(pageParams.getPageno());
        return page;
    }

    @Override
    public Integer saveAdminUser(AdminUser adminuser) {
        return null;
    }

    @Override
    public Integer updateAdminUser(AdminUser adminuser) {
        return null;
    }

    @Override
    public Integer deleteAdminUser(Integer id) {
        return null;
    }

    @Override
    public Integer deleteAdminUserByIds(Integer[] ids) {
        return null;
    }


}

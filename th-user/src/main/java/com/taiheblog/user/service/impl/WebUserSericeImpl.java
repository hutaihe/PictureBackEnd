package com.taiheblog.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taiheblog.enums.ResultEnums;
import com.taiheblog.exception.ThException;

import com.taiheblog.user.mapper.WebUserMapper;
import com.taiheblog.user.pojo.WebUser;
import com.taiheblog.user.service.WebUserService;
import com.taiheblog.utils.MD5Util;
import com.taiheblog.vo.Page;
import com.taiheblog.vo.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class WebUserSericeImpl implements WebUserService {
    @Autowired
    public WebUserMapper webUserMapper;

    @Override
    public WebUser getWebUserById(Integer id) {
        WebUser user = webUserMapper.getWebUserById(id);
        if (user == null) throw new ThException(ResultEnums.USER_NOT_FIND);
        return user;
    }

    @Override
    public Page<WebUser> getWebUserByPage(PageParams pageParams) {
        PageHelper.startPage(pageParams.getPageno(),pageParams.getPagesize());
        Example example = new Example(WebUser.class);
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
        List<WebUser> webUsers = webUserMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(webUsers)){
            throw new ThException(ResultEnums.PAGE_USER_NOT_FIND);
        }
        PageInfo<WebUser> pageInfo = new PageInfo<>(webUsers);
        Integer totalsize = (int)pageInfo.getTotal();
        Page<WebUser> page = new Page<>();
        page.setTotalsize((int)pageInfo.getTotal());
        page.setList(webUsers);
        page.setPageno(pageParams.getPageno());
        return page;
    }

    @Override
    public Integer saveWebUser(WebUser webuser) {
        WebUser user = webUserMapper.selectWebUserByAccount(webuser.getAccount());
        if(user != null){
            throw new ThException(ResultEnums.USER_ALREADY_EXISTENTCE);
        }
        if(webuser.getPassword() == null){
            webuser.setPassword(MD5Util.digest("123456"));
        }
        int i = webUserMapper.insertSelective(webuser);
        if(i != 1){
            throw new ThException(ResultEnums.SAVE_USER_ERROR);
        }
        return i;
    }


    @Override
    public Integer updateWebUser(WebUser webuser) {
        WebUser user = webUserMapper.selectWebUserByAccount(webuser.getAccount());
        if(user != null && user.getId() != webuser.getId()){
            throw new ThException(ResultEnums.USER_ALREADY_EXISTENTCE);
        }
        int i = webUserMapper.updateByPrimaryKeySelective(webuser);
        if(i != 1){
            throw new ThException(ResultEnums.UPDATE_USER_ERROR);
        }
        return i;
    }

    @Override
    public Integer deleteWebUser(Integer id) {
        int i = webUserMapper.deleteByPrimaryKey(id);
        if(i != 1){
            throw new ThException(ResultEnums.DELETE_USER_ERROR);
        }
        return i;
    }

    @Override
    @Transactional
    public Integer deleteWebUserByIds(Integer[] ids) {
        for (Integer id : ids) {
            int i = webUserMapper.deleteByPrimaryKey(id);
            if(i != 1){
                throw new ThException(ResultEnums.DELETE_USER_ERROR);
            }
        }
        return ids.length;
    }
}

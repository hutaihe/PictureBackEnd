package com.taiheblog.user.service.impl;

import com.taiheblog.user.mapper.RoleMapper;
import com.taiheblog.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
}

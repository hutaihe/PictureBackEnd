package com.taiheblog.user.service.impl;

import com.taiheblog.user.mapper.PermissionMapper;

import com.taiheblog.user.service.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
}

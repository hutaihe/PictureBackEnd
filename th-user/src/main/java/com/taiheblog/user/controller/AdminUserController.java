package com.taiheblog.user.controller;

import com.taiheblog.enums.ResultEnums;
import com.taiheblog.result.AjaxResult;

import com.taiheblog.user.pojo.AdminUser;
import com.taiheblog.user.service.AdminUserService;
import com.taiheblog.vo.Page;
import com.taiheblog.vo.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class AdminUserController {
    @Autowired
    public AdminUserService adminUserService;

    /**
     * 根据id查询管理员
     * @param id
     * @return
     */
    @GetMapping("adminuser/{id}")
    public AjaxResult<AdminUser> getAdminUserById(@PathVariable("id") Integer id){
        return new AjaxResult<AdminUser>(ResultEnums.OPERATION_SUCCESS,adminUserService.getAdminUserById(id));
    }

    /**
     * 分页查询
     * @param pageParams
     * @return
     */
    @PostMapping("adminuser/page")
    public AjaxResult<Page<AdminUser>> getAdminUserByPage(PageParams pageParams){
        return new AjaxResult<Page<AdminUser>>(ResultEnums.OPERATION_SUCCESS,adminUserService.getAdminUserByPage(pageParams));
    }

    /**
     * 保存管理员啊
     * @param adminuser
     * @return
     */
    @PostMapping("adminuser")
    public AjaxResult saveAdminUser(AdminUser adminuser){
        Integer count  = adminUserService.saveAdminUser(adminuser);
        return new AjaxResult(ResultEnums.SAVE_USER_SUCCESS);
    }

    /**
     * 更新管理员
     * @param adminuser
     * @return
     */
    @PutMapping("adminuser")
    public AjaxResult updateAdminUser(AdminUser adminuser){
        Integer count  = adminUserService.updateAdminUser(adminuser);
        return new AjaxResult(ResultEnums.UPDATE_USER_SUCCESS);
    }

    /**
     *  根据id删除管理员
     * @param id
     * @return
     */
    @DeleteMapping("adminuser/{id}")
    public AjaxResult deleteAdminUser(@PathVariable("id") Integer id){
        Integer count  = adminUserService.deleteAdminUser(id);
        return new AjaxResult(ResultEnums.DELETE_USER_SUCCESS);
    }

    /**
     * 批量删除管理员
     * @param ids
     * @return
     */
    @DeleteMapping("adminuser/ids")
    public AjaxResult deleteAdminUserByIds (Integer[] ids){
        Integer count  = adminUserService.deleteAdminUserByIds(ids);
        return new AjaxResult(ResultEnums.DELETE_USER_SUCCESS);
    }

}

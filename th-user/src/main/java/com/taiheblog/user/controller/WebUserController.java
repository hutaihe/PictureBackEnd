package com.taiheblog.user.controller;

import com.taiheblog.enums.ResultEnums;
import com.taiheblog.result.AjaxResult;
import com.taiheblog.user.pojo.WebUser;
import com.taiheblog.user.service.WebUserService;
import com.taiheblog.vo.Page;
import com.taiheblog.vo.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class WebUserController {
    @Autowired
    public WebUserService webUserService;

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping("webuser/{id}")
    public AjaxResult<WebUser> getWebUserById(@PathVariable("id") Integer id){
        return new AjaxResult<WebUser>(ResultEnums.OPERATION_SUCCESS,webUserService.getWebUserById(id));
    }

    /**
     * 分页查询
     * @param pageParams
     * @return
     */
    @PostMapping("webuser/page")
    public AjaxResult<Page<WebUser>> getWebUserByPage(PageParams pageParams){
        return new AjaxResult<Page<WebUser>>(ResultEnums.OPERATION_SUCCESS,webUserService.getWebUserByPage(pageParams));
    }

    /**
     * 保存用户
     * @param webuser
     * @return
     */
    @PostMapping("webuser")
    public AjaxResult saveWebUser(WebUser webuser){
        Integer count  = webUserService.saveWebUser(webuser);
        return new AjaxResult(ResultEnums.SAVE_USER_SUCCESS);
    }
    /**
     * 修改用户
     * @param webuser
     * @return
     */
    @PutMapping("webuser")
    public AjaxResult updateWebUser(WebUser webuser){
        Integer count  = webUserService.updateWebUser(webuser);
        return new AjaxResult(ResultEnums.UPDATE_USER_SUCCESS);
    }
    @DeleteMapping("webuser/{id}")
    public AjaxResult deleteWebUser(@PathVariable("id") Integer id){
        Integer count  = webUserService.deleteWebUser(id);
        return new AjaxResult(ResultEnums.DELETE_USER_SUCCESS);
    }
    //ids=1&ids=2
    @DeleteMapping("webuser/ids")
    public AjaxResult deleteWebUserByIds (Integer[] ids){
        Integer count  = webUserService.deleteWebUserByIds(ids);
        return new AjaxResult(ResultEnums.DELETE_USER_SUCCESS);
    }
}

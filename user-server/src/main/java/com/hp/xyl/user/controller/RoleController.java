package com.hp.xyl.user.controller;

import com.hp.xyl.user.entity.Role;
import com.hp.xyl.user.entity.User;
import com.hp.xyl.user.model.PageModel;
import com.hp.xyl.user.model.ResultModel;
import com.hp.xyl.user.model.UserModel;
import com.hp.xyl.user.service.RoleService;
import com.hp.xyl.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Author:xyl
 * Date:2018/12/21 14:58
 * Description:
 */
@Api(tags = "角色相关")
@RestController
@RequestMapping(value = "role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @ApiOperation(value = "新增/编辑用户")
    @PutMapping(value = "save")
    public ResultModel save(@RequestBody Role role) {
        ResultModel resultModel = new ResultModel();
        roleService.saveOrUpdate(role);
        return resultModel;
    }


    @ApiOperation(value = "删除用户信息")
    @GetMapping(value = "delete/{id}")
    public ResultModel delete(@PathVariable Long id) {
        ResultModel resultModel = new ResultModel();
        roleService.removeById(id);
        return resultModel;
    }
}

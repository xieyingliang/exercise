package com.hp.xyl.user.controller;

import com.hp.xyl.user.entity.User;
import com.hp.xyl.user.model.PageModel;
import com.hp.xyl.user.model.ResultModel;
import com.hp.xyl.user.model.UserModel;
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
@Api(tags = "用户相关")
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "新增/编辑用户")
    @PutMapping(value = "save")
    public ResultModel save(@RequestBody User user) {
        ResultModel resultModel = new ResultModel();
        userService.saveOrUpdate(user);
        return resultModel;
    }

    @ApiOperation(value = "列表显示")
    @PostMapping(value = "list")
    public ResultModel<PageModel<UserModel>> list(Integer pageNo, Integer pageSize, String username) {
        ResultModel<PageModel<UserModel>> resultModel = new ResultModel<>();
        resultModel.setData(userService.getUsersPage(pageNo, pageSize, username));
        return resultModel;
    }

    @ApiOperation(value = "删除用户信息")
    @GetMapping(value = "delete/{id}")
    public ResultModel delete(@PathVariable Long id) {
        ResultModel resultModel = new ResultModel();
        userService.removeById(id);
        return resultModel;
    }
}

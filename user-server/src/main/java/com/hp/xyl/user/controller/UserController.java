package com.hp.xyl.user.controller;

import com.hp.xyl.user.entity.User;
import com.hp.xyl.user.model.ResultModel;
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

    @ApiOperation(value = "新增用户")
    @PutMapping(value = "save")
    public ResultModel save(@RequestBody User user) {
        ResultModel resultModel = new ResultModel();
        userService.saveOrUpdate(user);
        return resultModel;
    }
}

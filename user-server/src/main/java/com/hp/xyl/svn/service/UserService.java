package com.hp.xyl.svn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hp.xyl.svn.entity.User;
import com.hp.xyl.svn.model.PageModel;
import com.hp.xyl.svn.model.UserModel;

/**
 * Author:xyl
 * Date:2018/12/21 14:57
 * Description:
 */
public interface UserService extends IService<User> {
    /**
     * 分页显示用户信息
     *
     * @param pageNo   页码
     * @param pageSize 页面大小
     * @param username 用户名
     * @return 分页
     */
    PageModel<UserModel> getUsersPage(Integer pageNo, Integer pageSize, String username);

    /**
     * 校验用户信息是否存在
     *
     * @param username 用户名
     * @param password 密码
     */
    void loginCheck(String username, String password);
}

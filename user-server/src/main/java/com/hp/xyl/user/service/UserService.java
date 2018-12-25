package com.hp.xyl.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hp.xyl.user.entity.User;
import com.hp.xyl.user.model.PageModel;
import com.hp.xyl.user.model.UserModel;

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
     * @param username
     * @return 分页
     */
    PageModel<UserModel> getUsersPage(Integer pageNo, Integer pageSize, String username);
}

package com.hp.xyl.svn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.xyl.svn.exception.SysException;
import com.hp.xyl.svn.mapper.UserMapper;
import com.hp.xyl.svn.entity.User;
import com.hp.xyl.svn.model.PageModel;
import com.hp.xyl.svn.model.UserModel;
import com.hp.xyl.svn.service.UserService;
import com.hp.xyl.svn.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:xyl
 * Date:2018/12/21 15:12
 * Description:
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public PageModel<UserModel> getUsersPage(Integer pageNo, Integer pageSize, String username) {
        Page<User> page = new Page<>(pageNo, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (!StringUtil.isEmpty(username)) {
            wrapper.like("username", username);
        }
        IPage<User> userPage = userMapper.selectPage(page, wrapper);
        PageModel<UserModel> pageModel = new PageModel<>();
        pageModel.setTotalElements(userPage.getTotal());
        pageModel.setTotalPages(userPage.getPages());
        pageModel.setContent(user2Models(userPage.getRecords()));
        return pageModel;
    }

    @Override
    public void loginCheck(String username, String password) {
        int count = userMapper.checkUser(username, password);
        //没有记录
        if (0 == count) {
            throw new SysException("用户名或密码错误");
        }
    }

    private List<UserModel> user2Models(List<User> users) {
        List<UserModel> models = new ArrayList<>();
        for (User user : users) {
            UserModel model = new UserModel();
            model.setId(user.getId());
            model.setEmail(user.getEmail());
            model.setPhoneNumber(user.getPhoneNumber());
            model.setSex(user.getSex());
            model.setUsername(user.getUsername());
            model.setAccount(user.getAccount());
            model.setPassword(user.getPassword());
            models.add(model);
        }
        return models;
    }
}

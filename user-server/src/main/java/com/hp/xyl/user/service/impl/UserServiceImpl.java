package com.hp.xyl.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.xyl.user.mapper.UserMapper;
import com.hp.xyl.user.entity.User;
import com.hp.xyl.user.model.PageModel;
import com.hp.xyl.user.model.UserModel;
import com.hp.xyl.user.service.UserService;
import com.hp.xyl.user.utils.StringUtil;
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
        Page page = new Page(pageNo, pageSize);
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

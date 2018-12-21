package com.hp.xyl.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.xyl.user.mapper.UserMapper;
import com.hp.xyl.user.entity.User;
import com.hp.xyl.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author:xyl
 * Date:2018/12/21 15:12
 * Description:
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

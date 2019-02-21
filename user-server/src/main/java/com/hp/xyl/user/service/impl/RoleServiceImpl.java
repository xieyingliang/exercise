package com.hp.xyl.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hp.xyl.user.entity.Role;
import com.hp.xyl.user.mapper.RoleMapper;
import com.hp.xyl.user.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author:xyl
 * Date:2018/12/21 15:12
 * Description:
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}

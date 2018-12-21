package com.hp.xyl.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hp.xyl.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author:xyl
 * Date:2018/12/21 15:15
 * Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}

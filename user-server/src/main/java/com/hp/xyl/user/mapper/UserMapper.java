package com.hp.xyl.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hp.xyl.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Author:xyl
 * Date:2018/12/21 15:15
 * Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select(value = "select * from user")
    IPage<User> getUserPage(Page page);
}

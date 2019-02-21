package com.hp.xyl.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hp.xyl.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Author:xyl
 * Date:2018/12/21 15:15
 * Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过用户名和密码查询
     *
     * @param username 用户名
     * @param password 密码
     * @return 符合的条数
     */
    @Select(value = "select count(1) from user where username = #{username} and password = #{password}")
    int checkUser(@Param("username") String username, @Param("password") String password);
}

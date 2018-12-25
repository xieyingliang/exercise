package com.hp.xyl.user.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Author:xyl
 * Date:2018/12/24 16:17
 * Description:
 */
@Getter
@Setter
public class UserModel {
    /**
     * id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phoneNumber;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
}

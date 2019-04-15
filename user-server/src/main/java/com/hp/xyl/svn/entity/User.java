package com.hp.xyl.svn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Author:xyl
 * Date:2018/12/21 14:43
 * Description:用户实体
 */
@Data
@TableName(value = "user")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String account;
    private Integer sex;
    private String email;
    private String phoneNumber;
}

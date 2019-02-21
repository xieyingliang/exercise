package com.hp.xyl.gateway.constants;

/**
 * 功能类型
 * Created by QY on 2017/11/11.
 */
public enum FunctionTypeEnum {

    /**
     * 团队
     */
    TEAM("团队",0),
    /**
     * 项目
     */
    PORJECT("项目",1),
    /**
     * 任务
     */
    TASK("任务",2),
    /**
     * 角色
     */
    ROLE("角色", 3),
    /**
     * 成员
     */
    USER("成员", 4),
    /**
     * 授权无效
     */
    INVALID("授权无效",2),

    /**
     * 授权正常
     */
    NORMAL("授权正常",0),

    /**
     * 授权过期
     */
    OVERDUE("授权过期",1);

    private String message;

    private int code;

    FunctionTypeEnum(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode(){
        return code;
    }
}

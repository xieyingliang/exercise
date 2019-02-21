package com.hp.xyl.gateway.constants;

/**
 * 看板状态分类枚举
 **/
public enum BelongTypeEnum {
    /**
     * 公共
     */
    PUBLIC("pub", -1),
    /**
     * 个人
     */
    USER("user", 0),
    /**
     * 团队
     */
    TEAM("team", 1),
    /**
     * 机构
     */
    ORG("org", 2),

    /**
     * 部门
     */
    DEP("dep", 3),
    /**
     * 岗位(前端使用)
     */
    POST("post",31),
    /**
     * 项目
     */
    PROJECT("project", 4);


    private int code;

    private String name;

    /**
     * 枚举类型
     */
    BelongTypeEnum(String name, int code) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 根据归属获取属性类型
     *
     * @param code 归属类型
     * @return 属性类型
     */
    public static BelongTypeEnum geTypeEnum(int code) {
        for (BelongTypeEnum belongTypeEnum : BelongTypeEnum.values()) {
            // 判断归属类型是否相等
            if (belongTypeEnum.getCode() == code) {
                return belongTypeEnum;
            }
        }
        return null;
    }

    /**
     * 根据归属获取属性类型
     *
     * @param name 归属类型
     * @return 属性类型
     */
    public static BelongTypeEnum geTypeEnum(String name) {
        for (BelongTypeEnum belongTypeEnum : BelongTypeEnum.values()) {
            // 判断归属类型是否相等
            if (belongTypeEnum.getName().equals(name)) {
                return belongTypeEnum;
            }
        }
        return null;
    }

    /**
     * 根据归属id获取归属类型
     *
     * @param code 归属id
     * @return 归属类型
     */
    public static String getName(int code) {
        for (BelongTypeEnum belongTypeEnum : BelongTypeEnum.values()) {
            if (belongTypeEnum.getCode() == code) {
                return belongTypeEnum.name;
            }
        }
        return null;
    }

    /**
     * 根据文字获取索引值
     *
     * @param name 归属类型值
     * @return 归属id
     */
    public static int getCode(String name) {
        for (BelongTypeEnum belongTypeEnum : BelongTypeEnum.values()) {
            if (belongTypeEnum.getName().equals(name)) {
                return belongTypeEnum.code;
            }
        }
        return -1;
    }
}

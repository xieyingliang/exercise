package com.hp.xyl.user.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Author:xyl
 * Date:2018/12/21 15:01
 * Description:前端返回model
 */
@Getter
@Setter
public class ResultModel<T> implements Serializable {
    /**
     * 状态码
     */
    private int code;
    /**
     * 信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;
    /**
     * 数据集合
     */
    private List<T> dataList;

    public ResultModel() {
        this.code = 0;
        this.message = "succeed";
    }

    public ResultModel(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

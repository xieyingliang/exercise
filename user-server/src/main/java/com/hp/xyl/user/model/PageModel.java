package com.hp.xyl.user.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:xyl
 * Date:2018/12/24 15:01
 * Description:分页model
 */
@Data
public class PageModel<T>  implements Serializable {
    /**
     * 总页面
     */
    private long totalPages;
    /**
     * 总个数
     */
    private long totalElements;
    /**
     * 内容集合
     */
    private List<T> content = new ArrayList<>();

    public PageModel() {

    }

    public PageModel(int pageSize, int totalCount) {
        int totalPage = totalCount / pageSize;
        int pageNum = totalCount % pageSize;
        totalPage = pageNum > 0 ? totalPage + 1 : totalPage;
        this.totalPages = totalPage;
        //总条数
        this.totalElements = totalCount;
    }

    /**
     * 设置总条数、总页数
     * 因为创建的时候，还不知道 totalCount
     *
     * @param totalCount 总条数
     * @param pageSize   每页个数
     */
    public void pageProcess(int totalCount, int pageSize) {
        int totalPage = totalCount / pageSize;
        int pageNum = totalCount % pageSize;
        totalPage = pageNum > 0 ? totalPage + 1 : totalPage;
        //总页数
        this.totalPages = totalPage;
        //总条数
        this.totalElements = totalCount;
    }


}

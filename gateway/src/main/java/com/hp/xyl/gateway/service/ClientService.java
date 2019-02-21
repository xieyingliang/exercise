package com.hp.xyl.gateway.service;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Author:xyl
 * Date:2019/2/1 16:14
 * Description:客户端service
 */
public interface ClientService {
    /**
     * 判断用户是否存在
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     */
    void checkUser(ServletRequest request, ServletResponse response);
}

package com.hp.xyl.gateway.config;

import com.hp.xyl.gateway.constants.Constants;
import com.hp.xyl.gateway.service.ClientService;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Author:xyl
 * Date:2019/2/1 15:55
 * Description:
 */
public class CustomFilter implements Filter {
    @Resource
    private ClientService clientService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //请求路径
        String requestURI = request.getRequestURI();
        request.getSession();
        //登录
        if (Constants.LOGIN_PATH.equals(requestURI)) {
            clientService.checkUser(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

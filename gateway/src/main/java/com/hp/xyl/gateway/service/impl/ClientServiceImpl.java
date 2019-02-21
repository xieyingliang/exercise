package com.hp.xyl.gateway.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hp.xyl.gateway.feign.UserFeignClient;
import com.hp.xyl.gateway.model.ResultModel;
import com.hp.xyl.gateway.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author:xyl
 * Date:2019/2/1 16:20
 * Description:
 */
@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    @Resource
    private UserFeignClient userFeignClient;

    @Override
    public void checkUser(ServletRequest request, ServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResultModel resultModel = userFeignClient.loginCheck(username, password);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try (PrintWriter out = response.getWriter()) {
            out.append(JSONObject.toJSONString(resultModel));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}

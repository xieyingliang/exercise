package com.hp.xyl.gateway.feign;

import com.hp.xyl.gateway.feign.fallback.UserFeignHystrix;
import com.hp.xyl.gateway.model.ResultModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author:xyl
 * Date:2019/2/1 16:43
 * Description:
 */
@FeignClient(name = "user-server", fallback = UserFeignHystrix.class)
public interface UserFeignClient {
    /**
     * 校验用户是否存在
     *
     * @param username 用户名
     * @param password 密码
     * @return 查询结果
     */
    @RequestMapping(value = "/user/check", method = RequestMethod.POST)
    ResultModel loginCheck(@RequestParam("username") String username, @RequestParam("password")String password);
}

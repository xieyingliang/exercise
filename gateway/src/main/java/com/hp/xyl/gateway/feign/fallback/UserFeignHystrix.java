package com.hp.xyl.gateway.feign.fallback;

import com.hp.xyl.gateway.feign.UserFeignClient;
import com.hp.xyl.gateway.model.ResultModel;
import org.springframework.stereotype.Component;

/**
 * Author:xyl
 * Date:2019/2/1 16:45
 * Description:
 */
@Component
public class UserFeignHystrix implements UserFeignClient {
    @Override
    public ResultModel loginCheck(String username, String password) {
        return new ResultModel(-1, "feign error");
    }
}

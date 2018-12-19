package com.hp.xyl.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Author:xyl
 * Date:2018/12/19 16:22
 * Description:
 */
@SpringBootApplication
@EnableConfigServer //开启配置服务
@EnableDiscoveryClient//使服务中心能发现此服务
public class ConfigApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigApplication.class).web(true).run(args);
    }
}

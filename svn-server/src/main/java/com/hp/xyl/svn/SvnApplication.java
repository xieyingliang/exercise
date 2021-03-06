package com.hp.xyl.svn;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Author:xyl
 * Date:2018/12/21 11:44
 * Description:
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing
@EnableHystrix
@EnableHystrixDashboard
public class SvnApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SvnApplication.class).web(true).run(args);
//        SpringApplication.run(UserApplication.class, args);
    }
}

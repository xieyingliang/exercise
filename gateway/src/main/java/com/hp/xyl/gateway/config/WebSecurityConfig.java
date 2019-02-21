package com.hp.xyl.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

/**
 * spring security配置
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 权限manager
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterAt(customFilter(), WebAsyncManagerIntegrationFilter.class)
                .authorizeRequests()
                .antMatchers("/organization/register/**").permitAll()
                .antMatchers("/tools/verification/**").permitAll()
                .antMatchers("/swagger**/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login").permitAll()
                //指定自定义form表单请求的路径
                .loginProcessingUrl("/authentication/form")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout().permitAll()
                .invalidateHttpSession(true)
                .permitAll();
    }


    /**
     * 自定义拦截器
     *
     * @return 自定义拦截器
     */
    @Bean
    public CustomFilter customFilter() {
        return new CustomFilter();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    }
}
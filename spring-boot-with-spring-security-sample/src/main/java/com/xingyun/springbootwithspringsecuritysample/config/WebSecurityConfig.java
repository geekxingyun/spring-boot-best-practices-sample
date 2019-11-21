package com.xingyun.springbootwithspringsecuritysample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/11/21 8:04
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //如果请求是/ 或者/home 不拦截
                .antMatchers("/", "/home").permitAll()
                //其他请求全部需要身份认证
                .anyRequest().authenticated()
                .and()
                //使用一个默认的表单
                .formLogin()
                //默认初始化一个登录页面
                .loginPage("/login")
                //分配权限不拦截
                .permitAll()
                .and()
                //注销方法不拦截
                .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        //该方法已经过时
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        UserDetails userDetails =
                User.builder()
                        //账号
                        .username("admin")
                        //密码
                        .password("admin")
                        //角色
                        .roles("admin","qa","dev")
                        //账户是否过期
                        .accountExpired(false)
                        //是否锁定账户
                        .accountLocked(false)
                        //是否禁用该用户
                        .disabled(false)
                        //登录凭据已过期
                        .credentialsExpired(false)
                        .build();
        //内存中保存登录信息
        return new InMemoryUserDetailsManager(userDetails);
    }
}

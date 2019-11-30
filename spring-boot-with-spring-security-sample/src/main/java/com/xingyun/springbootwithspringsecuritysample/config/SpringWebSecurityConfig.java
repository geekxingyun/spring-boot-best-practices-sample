package com.xingyun.springbootwithspringsecuritysample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author qing-feng.zhao
 * @description
 * @date 2019/11/23 10:17
 */
@Configuration
public class SpringWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //首页 登录 退出 静态资源不拦截
                .antMatchers("/","/login","/logout","/static/**").permitAll()
                //swagger-ui.html 和rest api 需要权限验证
                .antMatchers("/swagger-ui.html").authenticated()
                //所有请求都不拦截
                //其他请求不拦截
                .anyRequest().permitAll()
                .and()
                //默认登录界面
                .formLogin()
                //默认security框架可以处理的url登录页面不拦截
                .loginProcessingUrl("/login").permitAll()
                .and()
                //注销不拦截
                .logout().logoutSuccessUrl("/login").clearAuthentication(true).permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用密码类型
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails userDetailsDev =
                User.builder()
                        //账号
                        .username("admin")
                        //密码 123456
                        .password("$2a$10$0BVXV/xzovbD1rKpC.rwnuMCysuvH0llt3y2RLJkgG.9TTZJNPwIa")
                        //角色
                        .roles("admin","dev")
                        //账户是否过期
                        .accountExpired(false)
                        //是否锁定账户
                        .accountLocked(false)
                        //是否禁用该用户
                        .disabled(false)
                        //登录凭据已过期
                        .credentialsExpired(false)
                        .build();

        UserDetails userDetailsQa =
                User.builder()
                        //账号
                        .username("qa")
                        //密码
                        .password("$2a$10$0BVXV/xzovbD1rKpC.rwnuMCysuvH0llt3y2RLJkgG.9TTZJNPwIa")
                        //角色
                        .roles("admin","qa")
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
        return new InMemoryUserDetailsManager(userDetailsDev,userDetailsQa);
    }
}

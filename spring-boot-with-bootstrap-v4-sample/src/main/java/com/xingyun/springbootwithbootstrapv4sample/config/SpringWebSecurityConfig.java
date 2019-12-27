package com.xingyun.springbootwithbootstrapv4sample.config;

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
 * @date 2019/12/27 18:46
 */
@Configuration
public class SpringWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //首页 登录 退出 静态资源不拦截
                // /swagger-ui.html 和Restful API 需要权限验证 其他不需要
                .antMatchers("/","/login.do","/logout.do","/login","/logout").permitAll()
                .antMatchers("/toFtpPage.do","/showAmbLink.do","/swagger-ui.html","/api/v1/**","/actuator/**").authenticated()
                //所有请求都不拦截
                //其他请求不拦截
                .anyRequest().permitAll()
                .and()
                //默认登录界面
                .formLogin()
                //使用自定义的登录页面
                .loginPage("/login.do")
                //默认security框架可以处理的url登录页面不拦截
                //.loginProcessingUrl("/login")
                .permitAll()
                .and()
                //注销不拦截
                .logout()
                //登录成功后返回页面
                .logoutSuccessUrl("/")
                .clearAuthentication(true).permitAll();
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
                        //密码
                        .password("$2a$10$nEUkr/xFF9THtfsMDXYKWOWMY9TTmyKhSLgl/WWLl5qkrp.U7Z3me")
                        //角色
                        .roles("admin", "dev")
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
        return new InMemoryUserDetailsManager(userDetailsDev);
    }
}

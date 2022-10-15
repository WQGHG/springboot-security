package com.learn.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by wangqinggang on 2021/03/06.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    public void configure(WebSecurity webSecurity) {
        // 忽略前端静态资源 css js 等
        webSecurity.ignoring().antMatchers("/css/**");
        webSecurity.ignoring().antMatchers("/js/**");
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 设置密码加密方式，验证密码的在这里
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        // 允许无授权访问 "/index"、"/register" "/login"; 其他地址的访问均需验证权限
        httpSecurity.authorizeRequests()
                .antMatchers("/index", "/register", "/login", "/error", "/user/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .disable()
                .formLogin()
                // 用户名和用户密码参数名称
                .passwordParameter("userPassWord")
                .usernameParameter("userName")
                // 指定登录页面
                .loginPage("/login")
                .failureUrl("/login-error")
                .permitAll()
                .and()
                // 设置退出登录的 URL 和退出成功后跳转页面
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 使用 BCryptPasswordEncoder
        return new BCryptPasswordEncoder();
    }

}

package com.wwy.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

    //定义授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启自动配置的登陆功能,进入springboot默认的登陆页面，校验认证
        http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin");

        //开启自动配置的注销功能，默认来到登陆页面
        http.logout().logoutSuccessUrl("/"); //设置注销成功来到首页

        //开启记住我功能,浏览器保存登陆cookie，以后访问页面带上cookie，点击注销删除cookie
        http.rememberMe().rememberMeParameter("remember");

    }

    //定义认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("depp").password(new BCryptPasswordEncoder().encode("123")).roles("VIP1","VIP2")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("jack").password(new BCryptPasswordEncoder().encode("123")).roles("VIP2","VIP3");

    }
}

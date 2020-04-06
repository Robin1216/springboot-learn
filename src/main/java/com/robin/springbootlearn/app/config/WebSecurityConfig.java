package com.robin.springbootlearn.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * web 安全认证配置
 *
 * @author robin
 * @version v0.0.1
 * @since 2020-04-06 20:09
 */
@Configuration
@EnableWebSecurity  // 启动spring security 安全认证
//@EnableGlobalMethodSecurity(prePostEnabled = true)
// 开启方法级别安全控制:prePostEnabled 前注解是否可用，secureEnabled  保障注解@Secured 是否可用，jsr250Enabled  JSR-250 annotations 注解@RolesAllowed..是否可用
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    // 自定义用户服务信息
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /* 使用内存用户 */
        // 密码编码器
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 用户信息认证, 使用内存存储
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder) // 设置密码编码器
                .withUser("admin")  // 注册用户 admin，设置密码，并赋予 USER、ADMIN 角色
                .password(passwordEncoder.encode("123"))
                .roles("USER", "ADMIN")
                .and()
                .withUser("test")  // 注册用户 test，设置密码，并赋予 USER 角色
                .password(passwordEncoder.encode("123"))
                .roles("USER");

        // super.configure(auth);  // 重写时这个要去掉，不然选择系统默认认证方式
    }

    // 请求路径认证
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")  // 限定 /user/ 下的所有请求有 ROLE_ADMIN 和 ROLE_USER 权限
                .antMatchers("/user/**").access("hasRole('USER') or hasRole('ADMIN')")  // 限定 /user/ 下的所有请求有 ROLE_ADMIN 和 ROLE_USER 权限
                .antMatchers("/admin/login").access("hasRole('ADMIN') and isFullyAuthenticated()")  // 限定 /admin/ 下的所有请求有 ROLE_ADMIN 权限,要求完整验证(非记住我登录)
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")  // 限定 /admin/ 下的所有请求有 ROLE_ADMIN 权限
                .anyRequest().permitAll()  // 其他路径则允许访问
                .and().rememberMe() // 使用记住我功能
                .and().anonymous() // 对于没有配置权限的其他请求允许匿名访问
//                .and().formLogin() // 使用 Spring security 默认的登录页面
                .and().formLogin().loginPage("/login/page")  // 使用自定义登录页面
                .defaultSuccessUrl("/index") // 成功后的跳转路径
                .failureUrl("/error") // 指定认证失败后Url
                .and().httpBasic(); // 启用 http 基础验证
        /*
        // 强制使用 https 请求
        http.requiresChannel().antMatchers("/account/**").requiresSecure() // 使用安全渠道，限定为 https 请求
                .and().requiresChannel().antMatchers("/user/**").requiresInsecure()  // 不适用 https 请求
                .and().authorizeRequests().antMatchers("/account/**").hasAnyRole("ADMIN")  // 限定允许的访问角色
                .antMatchers("/user/**").hasAnyRole("ROLE", "ADMIN");
        */

        // csrf 攻击关闭, 不关闭csrf 需要给表单中添加隐藏域 <input type="hidden" id =”${_csrf.parameterName}" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        // http.csrf().disable().authorizeRequests();

        // super.configure(http);  // 重写时这个要去掉，不然选择系统默认认证方式
    }
}
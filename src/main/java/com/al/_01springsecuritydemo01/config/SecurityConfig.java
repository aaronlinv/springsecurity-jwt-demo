package com.al._01springsecuritydemo01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.al._01springsecuritydemo01.service.UserDetailService;

@EnableWebSecurity
// @Configuration 被包括在上面的注解了
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Autowired
    private AuthenticationFailureHandler failureHandler;

    @Autowired
    private UserDetailService userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                // .defaultSuccessUrl("/index")
                // .defaultSuccessUrl("/index")
                .successHandler(successHandler)
                .failureHandler(failureHandler)

                .and()
                .authorizeRequests()
                .antMatchers("/login.html", "/login")
                .permitAll()

                .antMatchers("/order")
                .hasAnyAuthority("ROLE_user", "ROLE_admin")

                // .antMatchers("/system/user", "/system/role", "/system/menu")
                .antMatchers("/system/**")
                .hasRole("admin")

                // 除了上面的，其他都需要认证
                .anyRequest().authenticated()

                .and()
                .csrf().disable();
        http.logout().logoutUrl("/logout");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
        System.out.println(passwordEncoder().encode("1234"));
        /*
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("1234"))
                .roles("user")
                .and()

                .withUser("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("admin")

                .and()
                .passwordEncoder(passwordEncoder());
        ;
         */
    }
}

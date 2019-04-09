package com.example.demosecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.util.Arrays;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Configuration
    @Order(1)
    public static class AdminConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.addFilterAt(new AdminFilter(),BasicAuthenticationFilter.class)
                    .authorizeRequests()
                    .antMatchers("/home/**").hasRole("CSA")
                    .antMatchers("/hello/**").hasRole("TR_ADMIN");
//                    .anyRequest().denyAll();





//            http
//                    .antMatcher("/home/**").addFilterAt(new AdminFilter(), UsernamePasswordAuthenticationFilter.class);
//                    .httpBasic().disable()
//                    .formLogin().disable();
//                    .addFilterBefore(new AdminFilter(), UsernamePasswordAuthenticationFilter.class).formLogin().disable();

//                    .antMatcher("/home")
//                    .addFilterBefore(new AdminFilter(), UsernamePasswordAuthenticationFilter.class);
        }
    }


}
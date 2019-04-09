package com.example.demosecurity.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AdminFilter extends GenericFilterBean {



    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        System.out.println("AdminFilter...");
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
//            final String accessToken = httpRequest.getHeader("header-name");
        final String accessToken = "token";
        if (null != accessToken) {
//            final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(accessToken, accessToken, null);

            ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_TR_ADMIN"));
            authorities.add(new SimpleGrantedAuthority("ROLE_CSA"));

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(accessToken, accessToken, authorities);
            System.out.println("authentication.isAuthenticated() : " + authentication.isAuthenticated());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }


        chain.doFilter(request, response);
    }



}
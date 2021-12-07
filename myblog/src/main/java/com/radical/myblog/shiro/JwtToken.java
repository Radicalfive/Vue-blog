package com.radical.myblog.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author : radical
 * @description :JwtToken
 * @data : 2021/12/7
 **/
public class JwtToken implements AuthenticationToken {

    private final String token;

    public JwtToken(String jwt) {
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

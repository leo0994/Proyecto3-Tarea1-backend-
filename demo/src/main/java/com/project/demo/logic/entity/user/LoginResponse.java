package com.project.demo.logic.entity.user;

import java.util.Map;

public class LoginResponse {
    private String token;

    private long expiresIn;

    private Map<String,Object> authUser;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setAuthUser(Map<String, Object> authUser) {
        this.authUser = authUser;
    }
    public Map<String, Object> getAuthUser() {
        return authUser;
    }
}

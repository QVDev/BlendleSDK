package com.sdk.post.request;

public class LoginRequest {
    final String login;
    final String password;

    public LoginRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

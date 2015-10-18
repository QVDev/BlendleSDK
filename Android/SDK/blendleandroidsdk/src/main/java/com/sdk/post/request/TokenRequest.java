package com.sdk.post.request;

public class TokenRequest {
    final String refresh_token;

    public TokenRequest(String refreshToken) {
        refresh_token = refreshToken;
    }
}

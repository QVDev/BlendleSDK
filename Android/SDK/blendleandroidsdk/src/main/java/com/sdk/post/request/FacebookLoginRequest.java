package com.sdk.post.request;

public class FacebookLoginRequest {
    final String facebook_id;
    final String facebook_access_token;

    public FacebookLoginRequest(String facebookId, String facebookAccessToken) {
        facebook_id = facebookId;
        facebook_access_token = facebookAccessToken;
    }
}

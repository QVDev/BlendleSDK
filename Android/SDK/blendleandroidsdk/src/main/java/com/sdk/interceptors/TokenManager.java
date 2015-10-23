package com.sdk.interceptors;

import com.sdk.blendle.models.generated.login.Login;

public interface TokenManager {
    boolean hasRefreshToken();

    void clearSessionToken();

    Login refreshToken();

    void setSessionToken(String sessionToken);

    String getSessionToken();
}


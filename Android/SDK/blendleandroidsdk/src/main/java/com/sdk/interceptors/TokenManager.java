package com.sdk.interceptors;

import com.sdk.blendle.models.generated.login.Login;

public interface TokenManager {
    /**
     * Check if refresh token is available
     *
     * @return Return true if refresh token is available
     */
    boolean hasRefreshToken();

    /**
     * Clear the session token
     */
    void clearSessionToken();

    /**
     * Set the refresh token. Not to be confused with session token.
     * Refresh token is longer valid and used to refresh the session token
     *
     * @return The user information with {@link Login}
     */
    Login refreshToken();

    /**
     * Set the session token
     *
     * @param sessionToken The session token
     */
    void setSessionToken(String sessionToken);

    /**
     * Get the session token
     *
     * @return The session token
     */
    String getSessionToken();
}


package com.sdk;

import com.sdk.blendle.models.generated.login.Login;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.HttpURLConnection;

public class TokenInterceptor implements Interceptor {


    private static final String HEADER_AUTHORIZATION = "Authorization";
    private final TokenManager mTokenManager;

    public TokenInterceptor(TokenManager tokenManager) {
        mTokenManager = tokenManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request initialRequest = chain.request();
        Request modifiedRequest = initialRequest;

        Response response = chain.proceed(modifiedRequest);
        boolean unauthorized = response.code() == HttpURLConnection.HTTP_UNAUTHORIZED;
        if (unauthorized && mTokenManager.hasRefreshToken()) {
            mTokenManager.clearSessionToken();
            Login newToken = mTokenManager.refreshToken();
            mTokenManager.setSessionToken(newToken.getJwt());
            modifiedRequest = initialRequest.newBuilder()
                    .addHeader(HEADER_AUTHORIZATION, mTokenManager.getSessionToken())
                    .build();
            return chain.proceed(modifiedRequest);
        }
        return response;
    }
}

interface TokenManager {
    boolean hasRefreshToken();

    void clearSessionToken();

    Login refreshToken();

    void setSessionToken(String sessionToken);

    String getSessionToken();
}

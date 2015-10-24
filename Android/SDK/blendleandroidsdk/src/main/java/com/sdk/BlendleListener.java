package com.sdk;

import com.sdk.blendle.models.generated.login.Login;

public interface BlendleListener {
    /**
     * Pass the user information once user is logged in.
     *
     * @param loggedInUser The logged in user
     */
    void onUserLoggedIn(Login loggedInUser);
}

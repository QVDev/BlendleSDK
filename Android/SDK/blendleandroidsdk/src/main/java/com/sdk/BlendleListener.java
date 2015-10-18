package com.sdk;

import com.sdk.blendle.models.generated.login.Login;

public interface BlendleListener {
    void onUserLoggedIn(Login loggedInUser);
}

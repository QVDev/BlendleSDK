package com.sdk;

import com.sdk.blendle.models.generated.login.Login;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class Example {

    public static void main(String args[]) {
        BlendleApi blendleApi = new BlendleApi();

        blendleApi.loginUser(new Callback<Login>() {
            @Override
            public void onResponse(Response<Login> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Login loginResponse = response.body();
                    System.out.println(loginResponse.getEmbedded().getUser().getFullName());
                } else {
                    onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(t.getMessage());
            }
        }, "username", "password");
    }
}

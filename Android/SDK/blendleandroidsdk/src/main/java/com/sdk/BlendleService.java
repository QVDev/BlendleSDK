package com.sdk;

import com.sdk.blendle.models.generated.api.Api;
import com.sdk.blendle.models.generated.user.User;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface BlendleService {
    @GET("/api.json")
    Call<Api> getApi();

    @GET("/user/{user}")
    Call<User> getUser(@Path("user") String user);

}

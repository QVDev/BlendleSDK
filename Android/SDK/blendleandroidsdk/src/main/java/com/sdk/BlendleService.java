package com.sdk;

import com.sdk.blendle.models.generated.api.Api;
import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.search.Search;
import com.sdk.blendle.models.generated.user.User;
import com.sdk.post.request.LoginRequest;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

public interface BlendleService {

    @GET("/api.json")
    Call<Api> getApi();

    @GET("/user/{user}")
    Call<User> getUser(@Path("user") String user);

    @GET("search")
    Call<Search> searchArticles(@Query("q") String query);

    @POST("/tokens")
    Call<Login> loginUser(@Body LoginRequest body);
}

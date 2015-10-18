package com.sdk;

import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.popular.Popular;
import com.sdk.blendle.models.generated.search.Search;
import com.sdk.blendle.models.generated.user.User;
import com.sdk.post.request.LoginRequest;
import com.sdk.post.request.TokenRequest;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.Url;

public interface BlendleServiceWs {

    @Headers("Accept: application/json")
    @GET("/user/{user}")
    Call<User> getUser(@Path("user") String user, @Header("Authorization") String authorization);

    @GET("/user/{user}")
    Call<User> getPublicUser(@Path("user") String user);

    @GET("search")
    Call<Search> searchArticles(@Query("q") String query);

    @GET("items/popular")
    Call<Popular> getPopular();

    @GET("")
    Call<Search> loadNextArticles(@Url() String url);

    @GET("")
    Call<Popular> loadNextPopularArticles(@Url() String url);

    @POST("/credentials")
    Call<Login> loginUser(@Body LoginRequest body);

    @POST("/tokens")
    Call<Login> refreshToken(@Body TokenRequest body);
}

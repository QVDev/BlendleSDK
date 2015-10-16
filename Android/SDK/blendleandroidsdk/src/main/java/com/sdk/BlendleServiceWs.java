package com.sdk;

import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.popular.Popular;
import com.sdk.blendle.models.generated.publicuser.PublicUser;
import com.sdk.blendle.models.generated.search.Search;
import com.sdk.post.request.LoginRequest;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.Url;

public interface BlendleServiceWs {

    @GET("/user/{user}")
    Call<PublicUser> getUser(@Path("user") String user);

    @GET("search")
    Call<Search> searchArticles(@Query("q") String query);

    @GET("items/popular")
    Call<Popular> getPopular();

    @GET("")
    Call<Search> loadNextArticles(@Url() String url);

    @GET("")
    Call<Popular> loadNextPopularArticles(@Url() String url);

    @POST("/tokens")
    Call<Login> loginUser(@Body LoginRequest body);
}

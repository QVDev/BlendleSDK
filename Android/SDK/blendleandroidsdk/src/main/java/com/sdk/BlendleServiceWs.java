package com.sdk;

import com.sdk.blendle.models.generated.acquire.Acquire;
import com.sdk.blendle.models.generated.article.Article;
import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.popular.Popular;
import com.sdk.blendle.models.generated.search.Search;
import com.sdk.blendle.models.generated.user.User;
import com.sdk.post.request.ItemRequest;
import com.sdk.post.request.LoginRequest;
import com.sdk.post.request.TokenRequest;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.Url;

public interface BlendleServiceWs {

    @Headers("Accept: application/json")
    @GET("user/{user}")
    Call<User> getUser(@Path("user") String user, @Header("Authorization") String authorization);

    @GET("user/{user}")
    Call<User> getPublicUser(@Path("user") String user);

    @GET("search")
    Call<Search> searchArticles(@Query("q") String query);

    @GET("items/popular")
    Call<Popular> getPopular();

    @GET("")
    Call<Search> loadNextArticles(@Url() String url);

    @GET("")
    Call<Popular> loadNextPopularArticles(@Url() String url);

    @GET("item/{articleId}")
    Call<Article> getArticle(@Path("articleId") String articleId, @Header("Authorization") String authorization);

    @GET("item/{articleId}/content")
    Call<Article> getAcquiredArticle(@Path("articleId") String articleId, @Query("subitems") boolean subItems, @Header("Authorization") String authorization);

    @POST("credentials")
    Call<Login> loginUser(@Body LoginRequest body);

    @POST("/tokens")
    Call<Login> refreshToken(@Body TokenRequest body);

    @POST("user/{user}/items")
    Call<Acquire> buyArticle(@Path("user") String user, @Body ItemRequest body, @Header("Authorization") String authorization);

    @DELETE("user/{user}/items/{articleId}")
    Call<User> deleteArticle(@Path("user") String user, @Path("articleId") String articleId, @Header("Authorization") String authorization);
}

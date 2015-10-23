package com.sdk;

import com.sdk.blendle.models.generated.acquire.Acquire;
import com.sdk.blendle.models.generated.article.Article;
import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.pinned.Pinned;
import com.sdk.blendle.models.generated.popular.Popular;
import com.sdk.blendle.models.generated.search.Search;
import com.sdk.blendle.models.generated.user.User;
import com.sdk.blendle.models.generated.userissue.UserIssue;
import com.sdk.post.request.ItemRequest;
import com.sdk.post.request.LoginRequest;
import com.sdk.post.request.TokenRequest;
import com.sdk.put.request.PinRequest;
import com.sdk.response.EmptyResponse;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.Url;

public interface BlendleServiceWs {

    String HEADER_AUTHORIZATION = "Authorization";
    String HEADER_ACCEPT_JSON = "Accept: application/json";
    String HEADER_ACCEPT_HAL_JSON = "Accept: application/hal+json";

    @Headers(HEADER_ACCEPT_JSON)
    @GET("user/{user}")
    Call<User> getUser(@Path("user") String user, @Header(HEADER_AUTHORIZATION) String authorization);

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
    Call<Article> getArticle(@Path("articleId") String articleId, @Header(HEADER_AUTHORIZATION) String authorization);

    @GET("item/{articleId}/content")
    Call<Article> getAcquiredArticle(@Path("articleId") String articleId, @Query("subitems") boolean subItems, @Header(HEADER_AUTHORIZATION) String authorization);

    @GET("user/{userId}/items")
    Call<Popular> getUserItems(@Path("userId") String userId, @Header(HEADER_AUTHORIZATION) String authorization);

    @GET("user/{userId}/issues")
    Call<UserIssue> getUserIssues(@Path("userId") String userId, @Header(HEADER_AUTHORIZATION) String authorization);

    @Headers(HEADER_ACCEPT_HAL_JSON)
    @GET("user/{user}/pins_timeline")
    Call<Pinned> getPinned(@Path("user") String userId, @Query("zoom") String zoom, @Header(HEADER_AUTHORIZATION) String authorization);

    @Headers(HEADER_ACCEPT_JSON)
    @GET("issue/{issueId}/items")
    Call<Popular> getIssue(@Path("issueId") String issueId, @Query("sort") String sort, @Query("limit") int limit);

    @POST("credentials")
    Call<Login> loginUser(@Body LoginRequest body);

    @POST("/tokens")
    Call<Login> refreshToken(@Body TokenRequest body);

    @POST("user/{user}/items")
    Call<Acquire> buyArticle(@Path("user") String user, @Body ItemRequest body, @Header(HEADER_AUTHORIZATION) String authorization);

    @PUT("user/{user}/pin/{itemId}")
    Call<EmptyResponse> pinItem(@Path("user") String userId, @Path("itemId") String itemId, @Body PinRequest pin, @Header(HEADER_AUTHORIZATION) String authorization);

    @DELETE("user/{user}/items/{articleId}")
    Call<User> deleteArticle(@Path("user") String user, @Path("articleId") String articleId, @Header(HEADER_AUTHORIZATION) String authorization);
}

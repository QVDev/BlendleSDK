package com.sdk;

import com.sdk.blendle.models.generated.acquire.Acquire;
import com.sdk.blendle.models.generated.api.Api;
import com.sdk.blendle.models.generated.article.Article;
import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.newsstand.Newsstand;
import com.sdk.blendle.models.generated.popular.Popular;
import com.sdk.blendle.models.generated.search.Search;
import com.sdk.blendle.models.generated.user.User;
import com.sdk.post.request.ItemRequest;
import com.sdk.post.request.LoginRequest;
import com.sdk.post.request.TokenRequest;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.util.Locale;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class BlendleApi implements BlendleListener, TokenManager {

    private static final String BEARER_PREFIX = "Bearer ";

    private static final String BASE_API_URL = "https://static.blendle.nl";
    private static final String BASE_URL = "https://ws.blendle.nl";

    private OkHttpClient mOkHttpClient = new OkHttpClient();

    private BlendleServiceWs mServiceWs;
    private BlendleServiceStatic mServiceStatic;

    private String mForcedLocale = SupportedCountries.NL.toString();
    private String mSessionToken;
    private String mRefreshToken;

    public BlendleApi() {
        initTokenInterceptor();
        initStaticService();
        initWsService();
    }

    private void initTokenInterceptor() {
        mOkHttpClient.interceptors().add(new TokenInterceptor(this));
    }

    private void initStaticService() {
        Retrofit mRetrofitStatic = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient)
                .build();

        mServiceStatic = mRetrofitStatic.create(BlendleServiceStatic.class);
    }

    private void initWsService() {
        Retrofit mRetrofitWs = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient)
                .build();

        mServiceWs = mRetrofitWs.create(BlendleServiceWs.class);
    }

    /**
     * Force a locale in case suspected that it is supported by Blendle but not by this SDK
     * Default is NL for The Netherlands.
     *
     * @param locale the locale string
     */
    public void setForcedLocale(String locale) {
        mForcedLocale = locale;
    }


    /**
     * Get the API.JSON. This contains generic information about the api.
     * Such as endpoints and configuration
     *
     * @param callback The response {@link Api} callback
     */
    public void getApi(Callback<Api> callback) {
        Call<Api> api = mServiceStatic.getApi();
        api.enqueue(callback);
    }

    /**
     * Get user information.
     *
     * @param callback return callback {@link User} for user information
     * @param user     The user id that needs to be fetched
     */
    public void getMyAccount(Callback<User> callback, String user) {
        Call<User> api = mServiceWs.getUser(user, getSessionToken());
        api.enqueue(callback);
    }

    public String getSessionToken() {
        return mSessionToken != null ? BEARER_PREFIX + mSessionToken : null;
    }

    /**
     * Get public user information.
     *
     * @param callback return callback {@link User} for user information
     * @param user     The user id that needs to be fetched
     */
    public void getPublicUser(Callback<User> callback, String user) {
        Call<User> api = mServiceWs.getPublicUser(user);
        api.enqueue(callback);
    }

    /**
     * Search articles.
     *
     * @param callback return callback {@link Search} for found articles
     * @param query    the search query
     */
    public void searchArticles(Callback<Search> callback, String query) {
        Call<Search> api = mServiceWs.searchArticles(query);
        api.enqueue(callback);
    }

    /**
     * Load next articles.
     *
     * @param callback return callback {@link Search} for found articles
     * @param url      The url for next article items
     */
    public void loadNextArticles(Callback<Search> callback, String url) {
        Call<Search> api = mServiceWs.loadNextArticles(url);
        api.enqueue(callback);
    }

    /**
     * Load next articles.
     *
     * @param callback return callback {@link Search} for found articles
     * @param url      The url for next article items
     */
    public void loadNextPopularArticles(Callback<Popular> callback, String url) {
        Call<Popular> api = mServiceWs.loadNextPopularArticles(url);
        api.enqueue(callback);
    }

    /**
     * Get popular items. Seems to be only providing locale NL
     *
     * @param callback return callback {@Popular Search} for found articles
     */
    public void getPopular(Callback<Popular> callback) {
        Call<Popular> api = mServiceWs.getPopular();
        api.enqueue(callback);
    }

    /**
     * Get the most recent new stand, based on system locale.
     * Be aware that a locale can also be forced set.
     *
     * @param callback return callback {@link Newsstand} for found articles
     */
    public void getMostRecentNewsstand(Callback<Newsstand> callback) {
        String locale = getSupportedLocaleOrDefault(true, SupportedCountries.NL);
        Call<Newsstand> api = mServiceStatic.getMostRecentNewstand(locale);
        api.enqueue(callback);
    }

    public void getMostRecentPapersNewsstand(Callback<Newsstand> callback) {
        String locale = getSupportedLocaleOrDefault(false, SupportedCountries.NL);
        Call<Newsstand> api = mServiceStatic.getMostRecentPapersNewsstand(locale);
        api.enqueue(callback);
    }

    public void getMostRecentMagazinesNewsstand(Callback<Newsstand> callback) {
        String locale = getSupportedLocaleOrDefault(false, SupportedCountries.NL);
        Call<Newsstand> api = mServiceStatic.getMostRecentMagazinesNewsstand(locale);
        api.enqueue(callback);
    }

    public void getWeb(Callback<Newsstand> callback) {
        Call<Newsstand> api = mServiceStatic.getWeb();
        api.enqueue(callback);
    }

    public void getInternational(Callback<Newsstand> callback) {
        Call<Newsstand> api = mServiceStatic.getInternational();
        api.enqueue(callback);
    }

    public void buyArticle(Callback<Acquire> callback, String user, String articleId) {
        ItemRequest itemRequest = new ItemRequest(articleId);
        Call<Acquire> api = mServiceWs.buyArticle(user, itemRequest, getSessionToken());
        api.enqueue(callback);
    }

    public void deleteArticle(Callback<User> callback, String user, String articleId) {
        Call<User> api = mServiceWs.deleteArticle(user, articleId, getSessionToken());
        api.enqueue(callback);
    }

    public void getArticle(Callback<Article> callback, String articleId) {
        Call<Article> api = mServiceWs.getArticle(articleId, getSessionToken());
        api.enqueue(callback);
    }

    public void getAquiredArticle(Callback<Article> callback, String articleId) {
        Call<Article> api = mServiceWs.getAcquiredArticle(articleId, true, getSessionToken());
        api.enqueue(callback);
    }

    /**
     * @param callback the callback with the login user information
     * @param login    the username or email
     * @param password the password of the account
     */
    public void loginUser(Callback<Login> callback, String login, String password) {
        LoginRequest loginRequest = new LoginRequest(login, password);
        Call<Login> api = mServiceWs.loginUser(loginRequest);
        api.enqueue(callback);
    }

    @Override
    public boolean hasRefreshToken() {
        return mRefreshToken != null;
    }

    @Override
    public void clearSessionToken() {
        mSessionToken = null;
    }

    @Override
    public Login refreshToken() {
        TokenRequest refreshTokenRequest = new TokenRequest(mRefreshToken);
        Call<Login> api = mServiceWs.refreshToken(refreshTokenRequest);
        Response<Login> response;
        try {
            response = api.execute();
        } catch (IOException e) {
            return null;
        }
        return response != null ? response.body() : null;
    }

    @Override
    public void setSessionToken(String sessionToken) {
        mSessionToken = sessionToken;
    }

    private String getSupportedLocaleOrDefault(boolean doLowerCase, SupportedCountries defaultCountry) {
        String locale = mForcedLocale;
        try {
            locale = SupportedCountries.valueOf(Locale.getDefault().getCountry()).toString();
        } catch (IllegalArgumentException exception) {
            System.out.println("Country " + Locale.getDefault().getCountry() + " not supported. Switching to default " + defaultCountry);
        }

        return doLowerCase ? locale.toLowerCase() : locale;
    }

    @Override
    public void onUserLoggedIn(Login loggedInUser) {
        mRefreshToken = loggedInUser.getRefreshToken() != null ? loggedInUser.getRefreshToken() : mRefreshToken;
        mSessionToken = loggedInUser.getJwt() != null ? loggedInUser.getJwt() : mSessionToken;
    }
}

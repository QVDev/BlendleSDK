package com.sdk;

import com.sdk.blendle.models.generated.acquire.Acquire;
import com.sdk.blendle.models.generated.api.Api;
import com.sdk.blendle.models.generated.article.Article;
import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.newsstand.Newsstand;
import com.sdk.blendle.models.generated.pinned.Pinned;
import com.sdk.blendle.models.generated.popular.Popular;
import com.sdk.blendle.models.generated.search.Search;
import com.sdk.blendle.models.generated.user.User;
import com.sdk.blendle.models.generated.userissue.UserIssue;
import com.sdk.interceptors.LoggingInterceptor;
import com.sdk.post.request.ItemRequest;
import com.sdk.post.request.LoginRequest;
import com.sdk.post.request.TokenRequest;
import com.sdk.put.request.PinRequest;
import com.sdk.response.EmptyResponse;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.util.Locale;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class BlendleApi implements BlendleListener, com.sdk.interceptors.TokenManager {

    private static final String BEARER_PREFIX = "Bearer ";

    private static final String BASE_API_URL = "https://static.blendle.nl";
    private static final String BASE_URL = "https://ws.blendle.nl";

    private static final String POPULAR_SORT = "popular";
    private static final String PINNED_ARGUMENTS = "b:tiles,b:item,manifest";

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
        mOkHttpClient.interceptors().add(new com.sdk.interceptors.TokenInterceptor(this));
        mOkHttpClient.interceptors().add(new LoggingInterceptor());
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
     * Get userId information.
     *
     * @param callback return callback {@link User} for userId information
     * @param userId   The userId id that needs to be fetched
     */
    public void getMyAccount(Callback<User> callback, String userId) {
        Call<User> api = mServiceWs.getUser(userId, getSessionToken());
        api.enqueue(callback);
    }

    /**
     * Get public userId information.
     *
     * @param callback return callback {@link User} for userId information
     * @param userId   The userId id that needs to be fetched
     */
    public void getPublicUser(Callback<User> callback, String userId) {
        Call<User> api = mServiceWs.getPublicUser(userId);
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
     * @param callback return callback {@link Popular} for found articles
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

    /**
     * Get the most recent news papers based on system locale.
     * Locale could also be forced set.
     *
     * @param callback return callback {@link Newsstand} for found papers
     */
    public void getMostRecentPapersNewsstand(Callback<Newsstand> callback) {
        String locale = getSupportedLocaleOrDefault(false, SupportedCountries.NL);
        Call<Newsstand> api = mServiceStatic.getMostRecentPapersNewsstand(locale);
        api.enqueue(callback);
    }

    /**
     * Get the most recent magazines based on system locale.
     * Locale could also be forced set.
     *
     * @param callback return callback {@link Newsstand} for found magazines
     */
    public void getMostRecentMagazinesNewsstand(Callback<Newsstand> callback) {
        String locale = getSupportedLocaleOrDefault(false, SupportedCountries.NL);
        Call<Newsstand> api = mServiceStatic.getMostRecentMagazinesNewsstand(locale);
        api.enqueue(callback);
    }

    /**
     * Get the web papers that are available.
     * Locale could also be forced set.
     *
     * @param callback return callback {@link Newsstand} for found web items
     */
    public void getWeb(Callback<Newsstand> callback) {
        Call<Newsstand> api = mServiceStatic.getWeb();
        api.enqueue(callback);
    }

    /**
     * Get international available items.
     * Locale could also be forced set.
     *
     * @param callback return callback {@link Newsstand} for found international items
     */
    public void getInternational(Callback<Newsstand> callback) {
        Call<Newsstand> api = mServiceStatic.getInternational();
        api.enqueue(callback);
    }

    /**
     * Get a issue specific articles. Such as matching articles from a magazine or papers
     *
     * @param callback The callback {@link Popular} that returns the articles
     * @param issueId  The issue id for the magazine or news paper
     * @param limit    The limit of items you want to retrieve
     */
    public void getIssue(Callback<Popular> callback, String issueId, int limit) {
        Call<Popular> api = mServiceWs.getIssue(issueId, POPULAR_SORT, limit);
        api.enqueue(callback);
    }

    /**
     * Buy a specific article.
     *
     * @param callback  The callback that returns {@link Acquire} information about acquired article
     * @param userId    The userId that wants to buy the item
     * @param articleId The article id that you want to buy
     */
    public void buyArticle(Callback<Acquire> callback, String userId, String articleId) {
        ItemRequest itemRequest = new ItemRequest(articleId);
        Call<Acquire> api = mServiceWs.buyArticle(userId, itemRequest, getSessionToken());
        api.enqueue(callback);
    }

    /**
     * Delete an article that has been bought.
     *
     * @param callback  The callback that returns {@link User} information about the user
     * @param userId    The userId that want to delete the item
     * @param articleId The articlId that needs to be deleted
     */
    public void deleteArticle(Callback<User> callback, String userId, String articleId) {
        Call<User> api = mServiceWs.deleteArticle(userId, articleId, getSessionToken());
        api.enqueue(callback);
    }

    /**
     * Get detailed article information
     *
     * @param callback  The callback that returns article details {@link Article}
     * @param articleId The article id that you want data for
     */
    public void getArticle(Callback<Article> callback, String articleId) {
        Call<Article> api = mServiceWs.getArticle(articleId, getSessionToken());
        api.enqueue(callback);
    }

    /**
     * Get acquired article information.
     *
     * @param callback  The callback that returns detailed information about article {@link Article}
     * @param articleId The article id you want the information for.
     */
    public void getAcquiredArticle(Callback<Article> callback, String articleId) {
        Call<Article> api = mServiceWs.getAcquiredArticle(articleId, true, getSessionToken());
        api.enqueue(callback);
    }

    /**
     * Get articles that the user has bought.
     *
     * @param callback The callback that returns the articles {@link Popular}
     * @param userId   The userId you want to get the articles for
     */
    public void getUserItems(Callback<Popular> callback, String userId) {
        Call<Popular> api = mServiceWs.getUserItems(userId, getSessionToken());
        api.enqueue(callback);
    }

    /**
     * Get issues such as magazines and paper that the user has bought.
     *
     * @param callback The callback that returns the issues {@link UserIssue}
     * @param userId   The user you want to get the issues for
     */
    public void getUserIssues(Callback<UserIssue> callback, String userId) {
        Call<UserIssue> api = mServiceWs.getUserIssues(userId, getSessionToken());
        api.enqueue(callback);
    }

    /**
     * Get users pinned items
     *
     * @param callback The callback that returns {@link Pinned} items
     * @param userId   The userId you want to get the pinned items for
     */
    public void getPinned(Callback<Pinned> callback, String userId) {
        Call<Pinned> api = mServiceWs.getPinned(userId, PINNED_ARGUMENTS, getSessionToken());
        api.enqueue(callback);
    }

    /**
     * Pin or unpin an article.
     *
     * @param callback Empty response callback as nothing will be returnd {@link EmptyResponse}
     * @param userId   The user that want to pin or unpin an item
     * @param itemId   The item id that needs to be pinned or unpinned
     * @param pin      {@code boolean} for pin or unpin
     */
    public void pinItem(Callback<EmptyResponse> callback, String userId, String itemId, boolean pin) {
        PinRequest pinRequest = new PinRequest(pin);
        Call<EmptyResponse> api = mServiceWs.pinItem(userId, itemId, pinRequest, getSessionToken());
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

    @Override
    public void onUserLoggedIn(Login loggedInUser) {
        mRefreshToken = loggedInUser.getRefreshToken() != null ? loggedInUser.getRefreshToken() : mRefreshToken;
        mSessionToken = loggedInUser.getJwt() != null ? loggedInUser.getJwt() : mSessionToken;
    }

    @Override
    public String getSessionToken() {
        return mSessionToken != null ? BEARER_PREFIX + mSessionToken : null;
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
}

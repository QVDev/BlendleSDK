package com.sdk;

import com.sdk.blendle.models.generated.api.Api;
import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.newsstand.Newsstand;
import com.sdk.blendle.models.generated.popular.Popular;
import com.sdk.blendle.models.generated.publicuser.PublicUser;
import com.sdk.blendle.models.generated.search.Search;
import com.sdk.post.request.LoginRequest;

import java.util.Locale;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class BlendleApi {

    public static final String BASE_API_URL = "https://static.blendle.nl";
    public static final String BASE_URL = "https://ws.blendle.nl";

    private Retrofit mRetrofitWs = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Retrofit mRetrofitStatic = new Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private BlendleServiceWs mServiceWs = mRetrofitWs.create(BlendleServiceWs.class);
    private BlendleServiceStatic mServiceStatic = mRetrofitStatic.create(BlendleServiceStatic.class);
    private String mForcedLocale = SupportedCountries.NL.toString();

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
     * @param callback return callback {@link PublicUser} for user information
     * @param user     The user id that needs to be fetched
     */
    public void getUser(Callback<PublicUser> callback, String user) {
        Call<PublicUser> api = mServiceWs.getUser(user);
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

    private String getSupportedLocaleOrDefault(boolean doLowerCase, SupportedCountries defaultCountry) {
        String locale = mForcedLocale;
        try {
            locale = SupportedCountries.valueOf(Locale.getDefault().getCountry()).toString();
        } catch (IllegalArgumentException exception) {
            System.out.println("Country " + Locale.getDefault().getCountry() + " not supported. Switching to default " + defaultCountry);
        }

        return doLowerCase ? locale.toLowerCase() : locale;
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
}

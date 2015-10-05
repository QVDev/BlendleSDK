package com.sdk;

import com.sdk.blendle.models.generated.api.Api;
import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.search.Search;
import com.sdk.blendle.models.generated.user.User;
import com.sdk.post.request.LoginRequest;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class BlendleApi {

    public static final String BASE_API_URL = "https://static.blendle.nl";
    public static final String BASE_URL = "https://ws.blendle.nl";

    private Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private BlendleService mService = mRetrofit.create(BlendleService.class);

    /**
     * Get the API.JSON. This contains generic information about the api.
     * Such as endpoints and configuration
     *
     * @param callback The response {@link Api} callback
     */
    public void getApi(Callback<Api> callback) {
        Retrofit customRetro = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BlendleService customService = customRetro.create(BlendleService.class);

        Call<Api> api = customService.getApi();
        api.enqueue(callback);
    }

    /**
     * Get user information.
     *
     * @param callback return callback {@link User} for user information
     * @param user     The user id that needs to be fetched
     */
    public void getUser(Callback<User> callback, String user) {
        Call<User> api = mService.getUser(user);
        api.enqueue(callback);
    }

    /**
     * Search articles.
     *
     * @param callback return callback {@link Search} for found articles
     * @param query    the search query
     */
    public void searchArticles(Callback<Search> callback, String query) {
        Call<Search> api = mService.searchArticles(query);
        api.enqueue(callback);
    }


    /**
     * @param callback the callback with the login user information
     * @param login    the username or email
     * @param password the password of the account
     */
    public void loginUser(Callback<Login> callback, String login, String password) {
        LoginRequest loginRequest = new LoginRequest(login, password);
        Call<Login> api = mService.loginUser(loginRequest);
        api.enqueue(callback);
    }

}

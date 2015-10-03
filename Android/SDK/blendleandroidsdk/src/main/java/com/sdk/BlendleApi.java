package com.sdk;

import com.sdk.blendle.models.generated.api.Api;
import com.sdk.blendle.models.generated.user.User;

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
     * @param callback The {@link Api} callback
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
     * @param callback return the {@link User} information
     * @param user     The user id that needs to be fetched
     */
    public void getUser(Callback<User> callback, String user) {
        Call<User> api = mService.getUser(user);
        api.enqueue(callback);
    }

}

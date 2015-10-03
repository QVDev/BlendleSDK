package com.sdk;

import com.sdk.blendle.models.custom.Api;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class BlendleApi {

    public static final String BASE_URL = "https://static.blendle.nl";

    private Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private BlendleService mService = mRetrofit.create(BlendleService.class);

    /**
     * Get the API.JSON. This contains generic information about the api.
     * Such as endpoints and configuration
     *
     * @param callback
     */
    public void getApi(Callback<Api> callback) {
        Call<Api> api = mService.getApi();
        api.enqueue(callback);
    }

}

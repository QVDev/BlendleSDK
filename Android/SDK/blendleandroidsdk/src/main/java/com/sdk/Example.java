package com.sdk;

import com.sdk.blendle.models.custom.Api;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class Example {

    private static BlendleApi mBlendleApi;

    public static void main(String args[]) {
        mBlendleApi = new BlendleApi();
        fetchApi();
    }

    private static void fetchApi() {

    }
}

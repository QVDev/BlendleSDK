package com.sdk;

import com.sdk.blendle.models.custom.Api;

import retrofit.Call;
import retrofit.http.GET;

public interface BlendleService {
    @GET("/api.json")
    Call<Api> getApi();
}

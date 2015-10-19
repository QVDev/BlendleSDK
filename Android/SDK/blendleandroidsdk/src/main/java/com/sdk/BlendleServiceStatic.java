package com.sdk;

import com.sdk.blendle.models.generated.api.Api;
import com.sdk.blendle.models.generated.newsstand.Newsstand;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface BlendleServiceStatic {

    @GET("api.json")
    Call<Api> getApi();

    @GET("meta/newsstand/language/code/{code}/most_recent.json")
    Call<Newsstand> getMostRecentNewstand(@Path("code") String countryCode);
}

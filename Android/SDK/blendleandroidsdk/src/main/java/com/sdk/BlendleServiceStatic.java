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

    @GET("meta/newsstand/location/ISO-3166-1/code/{code}/tag/name/Newspaper/most_recent.json")
    Call<Newsstand> getMostRecentPapersNewsstand(@Path("code") String countryCode);

    @GET("meta/newsstand/location/ISO-3166-1/code/{code}/tag/name/Magazine/most_recent.json")
    Call<Newsstand> getMostRecentMagazinesNewsstand(@Path("code") String countryCode);

    @GET("meta/categories/Web.json")
    Call<Newsstand> getWeb();

    @GET("meta/categories/Internationaal.json")
    Call<Newsstand> getInternational();


}

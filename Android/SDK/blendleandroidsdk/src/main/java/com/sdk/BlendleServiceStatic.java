package com.sdk;

import com.sdk.blendle.models.generated.api.Api;
import com.sdk.blendle.models.generated.newspapers.Newspapers;
import com.sdk.blendle.models.generated.newsstand.Newsstand;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface BlendleServiceStatic {

    @GET("api.json")
    Call<Api> getApi();

    @GET("meta/newsstand/location/ISO-3166-1/code/{code}/most_recent.json")
    Call<Newsstand> getMostRecentNewstand(@Path("code") String countryCode);

    @GET("meta/newsstand/location/ISO-3166-1/code/{code}/tag/name/Newspaper/popular.json")
    Call<Newspapers> getMostRecentPapersNewsstand(@Path("code") String countryCode);

    @GET("meta/newsstand/location/ISO-3166-1/code/{code}/tag/name/Magazine/popular.json")
    Call<Newspapers> getMostRecentMagazinesNewsstand(@Path("code") String countryCode);

    @GET("meta/newsstand/location/ISO-3166-1/code/{code}/tag/name/Web+feed/popular.json")
    Call<Newspapers> getWeb(@Path("code") String countryCode);

    @GET("meta/newsstand/location/ISO-3166-1/code/NL/tag/name/International/language/code/{code}/popular.json")
    Call<Newspapers> getInternational(@Path("code") String countryCode);


}

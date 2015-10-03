package com.sdk;

import com.sdk.blendle.models.generated.search.Search;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class Example {

    private static BlendleApi mBlendleApi;

    public static void main(String args[]) {
        mBlendleApi = new BlendleApi();
        mBlendleApi.searchArticles(new Callback<Search>() {
            @Override
            public void onResponse(Response<Search> response, Retrofit retrofit) {
                System.out.println(response.body().getResults());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, "Blendle");
    }
}

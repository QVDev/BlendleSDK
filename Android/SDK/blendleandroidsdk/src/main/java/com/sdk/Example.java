package com.sdk;

import com.sdk.blendle.models.generated.search.Search;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class Example {

    public static void main(String args[]) {
        BlendleApi blendleApi = new BlendleApi();

        blendleApi.searchArticles(new Callback<Search>() {
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

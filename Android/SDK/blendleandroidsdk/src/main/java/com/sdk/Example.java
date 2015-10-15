package com.sdk;

import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.search.Search;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class Example {

    private static BlendleApi mBlendleApi;

    public static void main(String args[]) {
        mBlendleApi = new BlendleApi();

//        loginUser("username", "password");
        loadNextArticles("https://ws.blendle.nl/search?q=blendle&limit=10&offset=10");
    }

    private static void loadNextArticles(String nextLink) {
        mBlendleApi.loadNextArticles(new Callback<Search>() {
            @Override
            public void onResponse(Response<Search> response, Retrofit retrofit) {
                Search nextArticles = response.body();
                System.out.println(nextArticles.getResults());
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(t.getMessage());
            }
        }, nextLink);
    }

    private static void loginUser(String username, String password) {
        mBlendleApi.loginUser(new Callback<Login>() {
            @Override
            public void onResponse(Response<Login> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Login loginResponse = response.body();
                    System.out.println(loginResponse.getEmbedded().getUser().getFullName());
                } else {
                    onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println(t.getMessage());
            }
        }, username, password);
    }
}

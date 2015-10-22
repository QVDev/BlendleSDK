package com.sdk;

import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.newsstand.Newsstand;
import com.sdk.blendle.models.generated.pinned.Pinned;
import com.sdk.blendle.models.generated.popular.Popular;
import com.sdk.blendle.models.generated.search.Search;
import com.sdk.blendle.models.generated.user.User;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class Example {

    private static BlendleApi mBlendleApi;

    public static void main(String args[]) {
        mBlendleApi = new BlendleApi();
        mBlendleApi.onUserLoggedIn(new Login());

//        loginUser("username", "password");
//        getUser();
//        loadNextArticles("https://ws.blendle.nl/search?q=blendle&limit=10&offset=10");
//        getGenericNewsstand();
//        getPopular();
    }

    private static void getUser() {
        mBlendleApi.getPublicUser(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
                User user = response.body();
                System.out.println(user.getBalance());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, "alexander");
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
                    mBlendleApi.onUserLoggedIn(loginResponse);
//                    getUser();
                    getPinnedItems("username");
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

    private static void getGenericNewsstand() {
        mBlendleApi.getInternational(new Callback<Newsstand>() {
            @Override
            public void onResponse(Response<Newsstand> response, Retrofit retrofit) {
                Newsstand newsstand = response.body();
                System.out.println(newsstand.toString());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private static void getPinnedItems(String username) {
        mBlendleApi.getPinned(new Callback<Pinned>() {
            @Override
            public void onResponse(Response<Pinned> response, Retrofit retrofit) {
                Pinned pinned = response.body();
                System.out.println(pinned.toString());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, username);
    }

    private static void getPopular() {
        mBlendleApi.getIssue(new Callback<Popular>() {
            @Override
            public void onResponse(Response<Popular> response, Retrofit retrofit) {
                Popular popular = response.body();
                System.out.println(popular.toString());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, "bnl-zeit-20151015", 1);
    }
}

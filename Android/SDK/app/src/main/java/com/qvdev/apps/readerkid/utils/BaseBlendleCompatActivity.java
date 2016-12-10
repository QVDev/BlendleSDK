package com.qvdev.apps.readerkid.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.qvdev.apps.readerkid.R;
import com.qvdev.apps.readerkid.facebook.FacebookSSOHelper;
import com.sdk.SupportedCountries;
import com.sdk.blendle.models.generated.facebook.FacebookMe;
import com.sdk.blendle.models.generated.login.Login;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class BaseBlendleCompatActivity extends AppCompatActivity {

    protected BlendleCredentialsApi mBlendleApi;
    protected BlendleSharedPreferences mBlendleSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBlendleApi();
        initBlendleSharedPrefs();
        initTracking();
    }

    private void initTracking() {
        FirebaseAnalytics firebaseAnalytics;
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseAnalytics.setCurrentScreen(this, getClass().getSimpleName(), getClass().getName());
    }

    private void initBlendleApi() {
        mBlendleApi = new BlendleCredentialsApi(this);
    }

    private void initBlendleSharedPrefs() {
        mBlendleSharedPreferences = new BlendleSharedPreferences(this);
    }

    protected void showSnackbarWithAction(int viewId, int stringId, int actionStringId, View.OnClickListener actionListener) {
        Snackbar.make(findViewById(viewId), getString(stringId), Snackbar.LENGTH_LONG)
                .setAction(getString(actionStringId), actionListener).show();
    }

    protected void showSnackbar(int viewId, int stringId) {
        Snackbar.make(findViewById(viewId), getString(stringId), Snackbar.LENGTH_LONG).show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FacebookSSOHelper.ACTIVITY_START_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                //TODO move this to the Helper class?
                FacebookSSOHelper facebookSSOHelper = new FacebookSSOHelper();
                final String token = facebookSSOHelper.onActivityResult(requestCode, resultCode, data);
                if (token != null) {
                    mBlendleApi.getFacebookUser(new Callback<FacebookMe>() {
                        @Override
                        public void onResponse(Response<FacebookMe> response, Retrofit retrofit) {
                            FacebookMe facebookResponse = response.body();
                            mBlendleApi.loginUserWithFacebook(new Callback<Login>() {
                                @Override
                                public void onResponse(Response<Login> response, Retrofit retrofit) {
                                    Login loggedInUser = response.body();
                                    mBlendleApi.onUserLoggedIn(loggedInUser);
                                    mBlendleSharedPreferences.storeLoggedInUser(loggedInUser);
                                    showSnackbar(R.id.blendle_content, R.string.login_facebook_succes);
                                }

                                @Override
                                public void onFailure(Throwable t) {
                                    showSnackbar(R.id.blendle_content, R.string.login_facebook_failure);
                                }
                            }, facebookResponse.getId(), token);
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            showSnackbar(R.id.blendle_content, R.string.login_facebook_failure);
                        }
                    }, token);
                } else {
                    showSnackbar(R.id.blendle_content, R.string.login_facebook_failure);
                }
            } else {
                showSnackbar(R.id.blendle_content, R.string.login_facebook_failure);
            }
        }
    }
}

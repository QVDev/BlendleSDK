package com.qvdev.apps.readerkid.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.sdk.BlendleApi;

public class BlendleCredentialsApi extends BlendleApi implements SharedPreferences.OnSharedPreferenceChangeListener {

    private final Context mContext;
    private BlendleSharedPreferences mBlendleSharedPreferences;


    public BlendleCredentialsApi(Context context) {
        mContext = context;
        mBlendleSharedPreferences = new BlendleSharedPreferences(mContext, this);
        restoreUser();
    }

    private void restoreUser() {
        onUserLoggedIn(mBlendleSharedPreferences.restoreStoredUser());
        if(mBlendleSharedPreferences.isLocaleSet()) {
            setForcedLocale(mBlendleSharedPreferences.restoreLocale());
        }
    }

    public String getUserId() {
        return mBlendleSharedPreferences.restoreUserId();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if (s.contentEquals(BlendleSharedPreferences.PREFS_REFRESH_TOKEN_VALUE) ||
                s.contentEquals(BlendleSharedPreferences.PREFS_JWT_SESSION_VALUE) ||
                s.contentEquals(BlendleSharedPreferences.PREFS_USER_ID_VALUE)) {

            onUserLoggedIn(mBlendleSharedPreferences.restoreStoredUser());
        }

    }
}

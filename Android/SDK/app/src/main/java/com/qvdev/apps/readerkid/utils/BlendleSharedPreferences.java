package com.qvdev.apps.readerkid.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.sdk.SupportedCountries;
import com.sdk.blendle.models.generated.login.Login;

public class BlendleSharedPreferences {

    public static final String PREFS_NAME = "BlendlePrefs";
    public static final String PREFS_TOKEN_VALUE = "token";
    public static final String PREFS_REFRESH_TOKEN_VALUE = "refresh_token";
    public static final String PREFS_JWT_SESSION_VALUE = "jwt_session";
    public static final String PREFS_USER_ID_VALUE = "user_id";
    public static final String PREFS_USER_LOCALE_VALUE = "user_locale";
    public static final String PREFS_RECOMMEND_VALUE = "shout_id";
    public static final String PREFS_FONTS_MULITPLIER = "font_size_preference";

    private Context mContext;
    SharedPreferences mSettings;

    public BlendleSharedPreferences(Context context) {
        init(context);
    }

    public BlendleSharedPreferences(Context context, SharedPreferences.OnSharedPreferenceChangeListener listener) {
        init(context);
        mSettings.registerOnSharedPreferenceChangeListener(listener);
    }

    private void init(Context context) {
        mContext = context;
        mSettings = mContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void storeToken(String token) {
        // All objects are from android.context.Context
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(PREFS_TOKEN_VALUE, token);

        // Commit the edits!
        editor.commit();
    }

    public String restoreToken() {
        String token = mSettings.getString(PREFS_TOKEN_VALUE, null);
        return token;
    }

    public void storeJwtSessionToken(String token) {
        // All objects are from android.context.Context
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(PREFS_JWT_SESSION_VALUE, token);

        // Commit the edits!
        editor.commit();
    }

    private String restoreJwtSessionToken() {
        String token = mSettings.getString(PREFS_JWT_SESSION_VALUE, null);
        return token;
    }

    public void storeRefreshToken(String token) {
        // All objects are from android.context.Context
        if (token != null) {
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putString(PREFS_REFRESH_TOKEN_VALUE, token);

            // Commit the edits!
            editor.commit();
        }
    }

    private String restoreRefreshToken() {
        String token = mSettings.getString(PREFS_REFRESH_TOKEN_VALUE, null);

        return token;
    }

    public void storeLoggedInUser(Login loggedInUser) {
        storeRefreshToken(loggedInUser.getRefreshToken());
        storeJwtSessionToken(loggedInUser.getJwt());
        storeUserId(loggedInUser.getEmbedded().getUser().getId());
    }

    public Login restoreStoredUser() {
        Login restoredUser = new Login();
        restoredUser.setJwt(restoreJwtSessionToken());
        restoredUser.setRefreshToken(restoreRefreshToken());

        return restoredUser;
    }

    public void storeUserId(String userId) {
        // All objects are from android.context.Context
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(PREFS_USER_ID_VALUE, userId);

        // Commit the edits!
        editor.commit();
    }

    public String restoreUserId() {
        String token = mSettings.getString(PREFS_USER_ID_VALUE, null);

        return token;
    }

    public void deleteUserInfo() {

        // All objects are from android.context.Context
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(PREFS_TOKEN_VALUE, null);
        editor.putString(PREFS_REFRESH_TOKEN_VALUE, null);
        editor.putString(PREFS_JWT_SESSION_VALUE, null);
        editor.putString(PREFS_USER_ID_VALUE, null);

        // Commit the edits!
        editor.commit();
    }


    public void storeInAppNotificationShown(String dynamicPrefsValue, boolean isShown) {
        // All objects are from android.context.Context
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putBoolean(dynamicPrefsValue, isShown);

        // Commit the edits!
        editor.commit();
    }

    public boolean restoreInAppNotificationIsClicked(String dynamicPrefsValue) {
        boolean token = mSettings.getBoolean(dynamicPrefsValue, false);

        return token;
    }

    public void storeRecommendationShownOk(boolean isShown) {
        // All objects are from android.context.Context
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putBoolean(PREFS_RECOMMEND_VALUE, isShown);

        // Commit the edits!
        editor.commit();
    }

    public boolean restoreRecommendationShownOk() {
        boolean shown = mSettings.getBoolean(PREFS_RECOMMEND_VALUE, false);
        return shown;
    }

    public float loadTextSizeMultiplier() {
        SharedPreferences defaultPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        String textSizeValue = defaultPreferences.getString(PREFS_FONTS_MULITPLIER, "1.0");
        float textSizeMuliplier = Float.parseFloat(textSizeValue);
        return textSizeMuliplier;
    }

    public void setTextSizeMultiplier(float size) {
        SharedPreferences defaultPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = defaultPreferences.edit();
        editor.putString(PREFS_FONTS_MULITPLIER, String.valueOf(size));
        editor.commit();
    }

    public boolean isAlarmPreferenceSet() {
        SharedPreferences defaultPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        return defaultPreferences.getBoolean("daily_reminder_preference", true);
    }

    public void storeLocale(String locale) {
        // All objects are from android.context.Context
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(PREFS_USER_LOCALE_VALUE, locale);

        // Commit the edits!
        editor.commit();
    }

    public String restoreLocale() {
        String locale = mSettings.getString(PREFS_USER_LOCALE_VALUE, SupportedCountries.NL.toString());

        return locale;
    }

    public boolean isLocaleSet() {
        return mSettings.contains(PREFS_USER_LOCALE_VALUE);
    }
}

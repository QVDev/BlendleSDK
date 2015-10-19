package com.qvdev.apps.readerkid.utils;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BaseBlendleCompatActivity extends AppCompatActivity {

    protected BlendleCredentialsApi mBlendleApi;
    protected BlendleSharedPreferences mBlendleSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBlendleApi();
        initBlendleSharedPrefs();
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
}

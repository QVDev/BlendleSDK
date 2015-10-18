package com.qvdev.apps.readerkid.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.qvdev.apps.readerkid.R;
import com.sdk.BlendleApi;
import com.sdk.blendle.models.generated.login.Login;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class DialogBlendleLogin implements Callback<Login>, View.OnClickListener {

    private final Context mContext;
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private AlertDialog mDialog;

    private BlendleApi mBlendleApi;
    private BlendleSharedPreferences mBlendlePrefs;
    private boolean isDialogNeeded;

    public DialogBlendleLogin(Context context, BlendleApi blendleApi) {
        mContext = context;
        mBlendlePrefs = new BlendleSharedPreferences(mContext);
        mBlendleApi = blendleApi == null ? new BlendleApi(
                mBlendlePrefs.restoreJwtSessionToken(),
                mBlendlePrefs.restoreRefreshToken()) : blendleApi;
        checkIfDialogIsNeeded();
    }

    private void checkIfDialogIsNeeded() {
        String refreshToken = mBlendlePrefs.restoreRefreshToken();
        if (refreshToken != null) {
            refreshToken();
        } else {
            isDialogNeeded = true;
            show();
        }
    }

    private void refreshToken() {
        mBlendleApi.refreshToken(this);
    }

    private void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.Base_Theme_Blendle_Dialog);
        builder.setTitle(R.string.login_title);
        builder.setMessage(R.string.login_information);
        builder.setPositiveButton(android.R.string.ok, null);
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.setView(R.layout.dialog_login);//TODO add loading indicator?
        builder.setIcon(R.mipmap.ic_launcher);
        mDialog = builder.show();
        initEditTexts();
    }

    private void initEditTexts() {
        mUsernameEditText = (EditText) mDialog.findViewById(R.id.login_username);
        mPasswordEditText = (EditText) mDialog.findViewById(R.id.login_password);
        mDialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(this);
    }

    private void login() {
        String username = mUsernameEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        mBlendleApi.loginUser(this, username, password);
    }

    @Override
    public void onResponse(Response<Login> response, Retrofit retrofit) {
        if (response.isSuccess()) {
            Login loggedInUser = response.body();
            saveNecessaryCredentials(loggedInUser);
            if (isDialogNeeded) {
                mDialog.dismiss();
            }
        } else {
            //TODO: Add more info?
            String whoops = mContext.getString(R.string.whoepsie);
            mUsernameEditText.setError(whoops);
            mPasswordEditText.setError(whoops);
        }
    }

    private void saveNecessaryCredentials(Login loggedInUser) {
        mBlendleApi.setSessionToken(loggedInUser.getJwt());

        mBlendlePrefs.storeRefreshToken(loggedInUser.getRefreshToken());
        mBlendlePrefs.storeJwtSessionToken(loggedInUser.getJwt());
        mBlendlePrefs.storeUserId(loggedInUser.getEmbedded().getUser().getId());
    }

    @Override
    public void onFailure(Throwable t) {
        Log.d(getClass().getSimpleName(), t.getMessage());
    }

    @Override
    public void onClick(View view) {
        login();
    }
}

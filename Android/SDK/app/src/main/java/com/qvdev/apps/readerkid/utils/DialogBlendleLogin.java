package com.qvdev.apps.readerkid.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

import com.qvdev.apps.readerkid.R;
import com.sdk.blendle.models.generated.login.Login;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class DialogBlendleLogin implements Callback<Login>, View.OnClickListener {

    public interface DialogLoginListener {
        void finishedWithUser(Login user);
    }

    private final Context mContext;

    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private AlertDialog mDialog;
    private BlendleCredentialsApi mBlendleApi;

    private BlendleSharedPreferences mBlendlePrefs;
    private final DialogLoginListener mListener;
    private boolean isDialogNeeded;

    public DialogBlendleLogin(Context context, DialogLoginListener listener, boolean forcedShow) {
        mContext = context;
        mBlendlePrefs = new BlendleSharedPreferences(mContext);
        mBlendleApi = new BlendleCredentialsApi(mContext);
        mListener = listener;
        checkIfDialogIsNeeded(forcedShow);
    }

    private void checkIfDialogIsNeeded(boolean forcedShow) {
        Login restoredUser = mBlendlePrefs.restoreStoredUser();
        if (restoredUser.getRefreshToken() == null || forcedShow) {
            isDialogNeeded = true;
            show();
        }
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
        Login loggedInUser = null;
        if (response.isSuccess()) {
            loggedInUser = response.body();
            saveNecessaryCredentials(loggedInUser);
            if (isDialogNeeded) {
                mDialog.dismiss();
            }
        } else {
            //TODO: Add more info?
            setErrorInputFields(mContext.getString(R.string.whoepsie));
        }
        if (mListener != null) {
            mListener.finishedWithUser(loggedInUser);
        }
    }

    private void setErrorInputFields(String error) {
        mUsernameEditText.setError(error);
        mPasswordEditText.setError(error);
    }

    private void saveNecessaryCredentials(Login loggedInUser) {
        mBlendlePrefs.storeLoggedInUser(loggedInUser);
    }

    @Override
    public void onFailure(Throwable t) {
        setErrorInputFields(t.getMessage());
    }

    @Override
    public void onClick(View view) {
        login();
    }
}

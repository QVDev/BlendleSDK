package com.qvdev.apps.readerkid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.qvdev.apps.readerkid.R;
import com.qvdev.apps.readerkid.facebook.FacebookSSOHelper;
import com.sdk.blendle.models.generated.login.Login;
import com.sdk.response.ErrorResponse;

import java.io.IOException;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class DialogBlendleLogin implements Callback<Login>, View.OnClickListener {

    public interface DialogLoginListener {

        void finishedWithUser(Login user);

    }

    protected final Context mContext;

    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mFacebookButton;

    protected AlertDialog mDialog;
    protected BlendleCredentialsApi mBlendleApi;
    private BlendleSharedPreferences mBlendlePrefs;

    private final DialogLoginListener mListener;
    private boolean isDialogNeeded;

    private FacebookSSOHelper mFacebookSSOHelper = new FacebookSSOHelper();

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

    protected void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.Base_Theme_Blendle_Dialog);
        builder.setTitle(R.string.login_title);
        builder.setPositiveButton(android.R.string.ok, null);
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.setNeutralButton(R.string.create_user, mNeutralButtonClicked);
        builder.setView(R.layout.dialog_login);//TODO add loading indicator?
        builder.setIcon(R.mipmap.ic_launcher);
        mDialog = builder.show();
        initEditTexts();
        initFacebookButton();
    }

    private DialogInterface.OnClickListener mNeutralButtonClicked = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            new DialogBlendleRegister(mContext, mListener);
        }
    };

    protected void initEditTexts() {
        mUsernameEditText = (EditText) mDialog.findViewById(R.id.login_username);
        mPasswordEditText = (EditText) mDialog.findViewById(R.id.login_password);
        mDialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(this);
    }

    private void initFacebookButton() {
        mFacebookButton = (Button) mDialog.findViewById(R.id.facebookLogin);

        if (mFacebookSSOHelper.isFacebookAppAvailable((Activity) mContext)) {
            mFacebookButton.setOnClickListener(this);
        } else {
            mFacebookButton.setVisibility(View.GONE);
        }
    }

    private void login() {
        if (allFieldsAreFilled()) {
            String username = mUsernameEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();
            mBlendleApi.loginUser(this, username, password);
        }
    }

    public void loginWithFacebook() {
        BaseBlendleCompatActivity activity = (BaseBlendleCompatActivity) mContext;
        if (!mFacebookSSOHelper.startSingleSignOn(activity)) {
            Snackbar.make(((BaseBlendleCompatActivity) mContext).findViewById(R.id.blendle_content), R.string.facebook_app_not_present, Snackbar.LENGTH_LONG).show();
        } else {
            mDialog.dismiss();
        }
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
            if (response.errorBody() != null) {
                Gson gson = new Gson();
                ErrorResponse error = new ErrorResponse(mContext.getString(R.string.whoepsie));
                try {
                    error = gson.fromJson(response.errorBody().charStream(), ErrorResponse.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                setErrorInputFields(error.getMessage());
            }
        }
        if (mListener != null) {
            mListener.finishedWithUser(loggedInUser);
        }
    }

    protected void setErrorInputFields(String error) {
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
        switch (view.getId()) {
            case R.id.facebookLogin:
                loginWithFacebook();
                break;
            default:
                login();
                break;
        }
    }

    private boolean allFieldsAreFilled() {
        boolean allFilled = true;
        if (TextUtils.isEmpty(mUsernameEditText.getText().toString())) {
            mUsernameEditText.setError(mContext.getString(R.string.whoepsie));
            allFilled = false;
        }
        if (TextUtils.isEmpty(mPasswordEditText.getText().toString())) {
            mPasswordEditText.setError(mContext.getString(R.string.whoepsie));
            allFilled = false;
        }
        return allFilled;
    }
}

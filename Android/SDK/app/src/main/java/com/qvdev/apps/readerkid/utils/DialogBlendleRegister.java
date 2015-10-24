package com.qvdev.apps.readerkid.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.qvdev.apps.readerkid.R;

public class DialogBlendleRegister extends DialogBlendleLogin {

    private static final String ERROR_EMAIL = "email";
    private static final String ERROR_PASSWORD = "password";
    private static final String ERROR_MALLFORMED = "malformed";

    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;

    public DialogBlendleRegister(Context context, DialogLoginListener listener) {
        super(context, listener, true);
    }

    @Override
    protected void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.Base_Theme_Blendle_Dialog);
        builder.setTitle(R.string.create_user);
        builder.setPositiveButton(android.R.string.ok, null);
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.setView(R.layout.dialog_register);//TODO add loading indicator?
        builder.setIcon(R.mipmap.ic_launcher);
        mDialog = builder.show();
        initEditTexts();
    }

    @Override
    protected void initEditTexts() {
        mEmailEditText = (EditText) mDialog.findViewById(R.id.register_email);
        mPasswordEditText = (EditText) mDialog.findViewById(R.id.register_password);
        mFirstNameEditText = (EditText) mDialog.findViewById(R.id.register_first_name);
        mLastNameEditText = (EditText) mDialog.findViewById(R.id.register_last_name);
        mDialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(this);
    }

    @Override
    protected void setErrorInputFields(String error) {
        if (error.toLowerCase().contains(ERROR_EMAIL)) {
            mEmailEditText.setError(error);
        } else if (error.toLowerCase().contains(ERROR_PASSWORD)) {
            mPasswordEditText.setError(error);
        } else {
            if(error.toLowerCase().contains(ERROR_MALLFORMED)){
                error = mContext.getString(R.string.please_check_special_input);
            }
            mEmailEditText.setError(error);
            mPasswordEditText.setError(error);
            mFirstNameEditText.setError(error);
            mLastNameEditText.setError(error);
        }
    }

    @Override
    public void onClick(View view) {
        if (allFieldsAreFilled()) {
            register();
        }
    }

    private boolean allFieldsAreFilled() {
        boolean allFilled = true;
        if (TextUtils.isEmpty(mEmailEditText.getText().toString())) {
            mEmailEditText.setError(mContext.getString(R.string.whoepsie));
            allFilled = false;
        }
        if (TextUtils.isEmpty(mPasswordEditText.getText().toString())) {
            mPasswordEditText.setError(mContext.getString(R.string.whoepsie));
            allFilled = false;
        }
        if (TextUtils.isEmpty(mFirstNameEditText.getText().toString())) {
            mFirstNameEditText.setError(mContext.getString(R.string.whoepsie));
            allFilled = false;
        }
        if (TextUtils.isEmpty(mLastNameEditText.getText().toString())) {
            mLastNameEditText.setError(mContext.getString(R.string.whoepsie));
            allFilled = false;
        }
        return allFilled;
    }

    private void register() {
        String email = mEmailEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        String firstName = mFirstNameEditText.getText().toString();
        String lastName = mLastNameEditText.getText().toString();
        mBlendleApi.createUser(this, email, password, firstName, lastName);
    }
}

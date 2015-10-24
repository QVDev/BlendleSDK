package com.qvdev.apps.readerkid.facebook;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.util.Log;

public class FacebookSSOHelper {

    private static final String FACEBOOK_INTENT_PACKAGE = "com.facebook.katana";
    private static final String FACEBOOK_INTENT_CLASS_NAME = "com.facebook.katana.ProxyAuth";
    private static final String CLIENT_ID_IDENTIFIER = "client_id";
    public static final int ACTIVITY_START_CODE = 100;


    public boolean startSingleSignOn(Activity activity) {

        boolean didSucceed = true;

        Intent intent = getFacebookIntent();

        if (!validateAppSignatureForIntent(activity, intent)) {
            return false;
        }

        try {
            activity.startActivityForResult(intent, ACTIVITY_START_CODE);
        } catch (ActivityNotFoundException e) {
            didSucceed = false;
        }

        return didSucceed;
    }

    public boolean isFacebookAppAvailable(Activity activity) {
        boolean didSucceed = true;
        Intent intent = getFacebookIntent();

        if (!validateAppSignatureForIntent(activity, intent)) {
            return false;
        }
        return didSucceed;
    }

    private Intent getFacebookIntent() {
        Intent intent = new Intent();

        intent.setClassName(FACEBOOK_INTENT_PACKAGE, FACEBOOK_INTENT_CLASS_NAME);
        intent.putExtra(CLIENT_ID_IDENTIFIER, FacebookConfig.FACEBOOK_CLIENT_ID);

        return intent;
    }

    private boolean validateAppSignatureForIntent(Context context, Intent intent) {

        PackageManager pm = context.getPackageManager();

        ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);
        if (resolveInfo == null) {
            return false;
        }

        String packageName = resolveInfo.activityInfo.packageName;
        PackageInfo packageInfo;
        try {
            packageInfo = pm.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }

        for (Signature signature : packageInfo.signatures) {
            if (signature.toCharsString().equals(FacebookConfig.FB_APP_SIGNATURE)) {
                return true;
            }
        }
        return false;
    }

    public String onActivityResult(int requestCode, int resultCode, Intent data) {
        String token = null;

        logInfo("" + resultCode);

        // Successfully redirected.
        if (resultCode == Activity.RESULT_OK) {

            // Check OAuth 2.0/2.10 error code.
            String error = data.getStringExtra("error_code");
            if (error == null) {
                error = data.getStringExtra("error_type");
            }

            // A Facebook error occurred.
            if (error != null) {
                logInfo(error);
                if (error.equals("service_disabled")
                        || error.equals("AndroidAuthKillSwitchException")) {

                } else {

                    String description = data.getStringExtra("error_message");
                    logInfo(description);
                }
                // No errors.
            } else {
                token = data.getStringExtra("access_token");
                logInfo("TOKEN::" + token);
            }
        }
        return token;
    }

    private void logInfo(String text) {
        Log.d(getClass().getSimpleName(), text);
    }
}

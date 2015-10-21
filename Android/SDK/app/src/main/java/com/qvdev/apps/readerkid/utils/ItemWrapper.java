package com.qvdev.apps.readerkid.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.qvdev.apps.readerkid.R;

public class ItemWrapper {

    private String mTitle = "";
    private String mImageUrl = "";
    private String mId = "";
    private String mSnippet = "";
    private int mSubItemsCount = 0;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mSnippet) {
        this.mTitle = mSnippet;
    }

    public String getImageUrl(Context context) {
        if (TextUtils.isEmpty(mImageUrl)) {
            return getPlaceholderImage(context);
        }
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    @NonNull
    private String getPlaceholderImage(Context context) {
        return context.getString(R.string.placeholder_image);
    }

    public String getSnippet() {
        return mSnippet;
    }

    public void setSnippet(String snippet) {
        mSnippet = snippet;
    }

    public int getSubItemsCount() {
        return mSubItemsCount;
    }

    public void setSubItemsCount(int subItemsCount) {
        mSubItemsCount = subItemsCount;
    }
}

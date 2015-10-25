package com.qvdev.apps.readerkid.utils;

import android.content.Context;

import com.qvdev.apps.readerkid.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemWrapper {

    public static String OWNED_ITEMS_ID = "owned_items";

    private String mTitle = "";
    private String mImageUrl = "";
    private String mId = "";
    private String mSnippet = "";
    private String mProvider = "";
    private String mPrice = "N/A";
    private String mDate = "";
    private int mWords = 0;
    private int mFavorite = 0;
    private boolean mPinned = false;

    private int mSubItemsCount = 0;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mSnippet) {
        this.mTitle = mSnippet;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getProviderImageUrl(Context context) {
        return context.getString(R.string.provider_image, getProvider());
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

    public String getProvider() {
        return mProvider;
    }

    public void setProvider(String provider) {
        this.mProvider = provider;
    }

    public String getPrice(Context context) {
        if (mPrice == null) {
            mPrice = "N/A";
        }
        return context.getString(R.string.price_balance, mPrice);
    }

    public void setPrice(String price) {
        this.mPrice = price;
    }

    public String getDate() {
        return mDate;
    }


    public void setDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SS");
        DateFormat df = new SimpleDateFormat("E d MMMM y");
        Date dateFormatted = null;
        try {
            dateFormatted = format.parse(date);
            System.out.println(dateFormatted);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mDate = dateFormatted == null ? "" : df.format(dateFormatted);
    }

    public int getWords() {
        return mWords;
    }

    public void setWords(int words) {
        this.mWords = words;
    }

    public int getFavorite() {
        return mFavorite;
    }

    public void setFavorite(int favorite) {
        this.mFavorite = favorite;
    }

    public boolean isPinned() {
        return mPinned;
    }

    public void setPinned(boolean pinned) {
        this.mPinned = pinned;
    }

}

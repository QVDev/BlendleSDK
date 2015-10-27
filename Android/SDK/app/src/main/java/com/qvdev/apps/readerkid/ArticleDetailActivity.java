package com.qvdev.apps.readerkid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qvdev.apps.readerkid.utils.BaseBlendleCompatActivity;
import com.qvdev.apps.readerkid.utils.DialogBlendleLogin;
import com.sdk.blendle.models.generated.acquire.Acquire;
import com.sdk.blendle.models.generated.article.Article;
import com.sdk.blendle.models.generated.article.Body;
import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.user.User;

import java.net.HttpURLConnection;
import java.util.List;

import distilledview.utils.qvdev.com.distilled.DistilledPagePrefs;
import distilledview.utils.qvdev.com.distilled.DistilledPagePrefsView;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ArticleDetailActivity extends BaseBlendleCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener {

    private TextView mArticleContentText;
    private String mArticleId;
    private FloatingActionButton mArticleBuyButton;
    private boolean mIsAcquired;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        loadBackdrop();

        Intent intent = getIntent();
        mIsAcquired = intent.getBooleanExtra(getString(R.string.intent_article_detail_acquired), false);
        mArticleId = intent.getStringExtra(getString(R.string.intent_article_detail_id));

        String price = intent.getStringExtra(getString(R.string.intent_article_detail_price));

        initArticleTextView();
        loadSnippet(intent);
        mArticleBuyButton = (FloatingActionButton) findViewById(R.id.articleBuyFloatingButton);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(price);

        loadArticleDetails();
    }

    private void initArticleTextView() {
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
        mArticleContentText = (TextView) findViewById(R.id.articleSnippet);
        restorePreferedTextViewOptions();
    }

    private void restorePreferedTextViewOptions() {
        DistilledPagePrefsView.restorePreferedOptions(mArticleContentText);
        setTextContainerBackground();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_article_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_text_format:
                showDistilledPagePrefsView();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDistilledPagePrefsView() {
        DistilledPagePrefsView.showDialog(this);
    }

    private void loadSnippet(Intent intent) {
        final String snippet = intent.getStringExtra(getString(R.string.intent_article_detail_snippet));
        mArticleContentText.setText(snippet);
    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        final String url = getIntent().getStringExtra(getString(R.string.intent_article_detail_image_url));
        if (!TextUtils.isEmpty(url)) {
            imageView.post(new Runnable() {
                @Override
                public void run() {
                    loadTransition(imageView);
                    Glide.with(ArticleDetailActivity.this).load(url).into(imageView);
                }
            });
        } else {
            imageView.setVisibility(View.GONE);
        }
        //TODO Load do color Palette.generateAsync() for title color change on the image
    }

    private void loadTransition(ImageView image) {
        ViewCompat.setTransitionName(image, getString(R.string.transition_article_detail_image));
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String preferenceName) {
        DistilledPagePrefsView.applyToTextView(mArticleContentText, sharedPreferences, preferenceName);
        if (preferenceName.contentEquals(DistilledPagePrefs.DISTILLED_PREF_USER_SET_FONT_MODE)) {
            setTextContainerBackground();
        }
    }

    private void setTextContainerBackground() {
        int mode = PreferenceManager.getDefaultSharedPreferences(this).getInt(DistilledPagePrefs.DISTILLED_PREF_USER_SET_FONT_MODE, DistilledPagePrefs.DEFAULT_FONT_MODE);
        int backgroundColor = DistilledPagePrefsView.getBackgroundColorFromMode(mode);
        findViewById(R.id.nested_scroll).setBackgroundResource(backgroundColor);
    }

    @Override
    protected void onDestroy() {
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    private void loadArticleDetails() {
        if (!mIsAcquired) {
            mBlendleApi.getArticle(mArticleDetailCallback, mArticleId);
        } else {
            doShowBuyButton(false);
            mBlendleApi.getAcquiredArticle(mArticleDetailCallback, mArticleId);
        }
    }


    private Callback<Article> mArticleDetailCallback = new Callback<Article>() {
        @Override
        public void onResponse(Response<Article> response, Retrofit retrofit) {
            if (response.isSuccess()) {
                Article articleResponse = response.body();
                mIsAcquired = articleResponse.getAcquired() != null ? articleResponse.getAcquired() : true;
                setArticleText(articleResponse.getEmbedded().getManifest().getBody());
                if (mIsAcquired && articleResponse.getAcquired() != null) {
                    loadArticleDetails();
                }
            } else if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
                new DialogBlendleLogin(ArticleDetailActivity.this, new DialogBlendleLogin.DialogLoginListener() {
                    @Override
                    public void finishedWithUser(Login user) {
                        if (user != null) {
                            loadArticleDetails();
                        }
                    }
                }, false);
            }
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(getClass().getSimpleName(), t.getMessage());
        }
    };

    private void setArticleText(List<Body> articleText) {
        StringBuilder completeArticleText = new StringBuilder();
        //TODO move this to the model?
        for (Body text : articleText) {
            completeArticleText.append(text.getContent());
            completeArticleText.append("<BR><BR>");
        }

        mArticleContentText.setText(Html.fromHtml(completeArticleText.toString()));
    }

    public void buyArticle(View view) {
        if (mBlendleSharedPreferences.restoreUserId() != null) {
            mBlendleApi.buyArticle(mAcquiredCallback, mBlendleSharedPreferences.restoreUserId(), mArticleId);
        } else {
            new DialogBlendleLogin(ArticleDetailActivity.this, new DialogBlendleLogin.DialogLoginListener() {

                @Override
                public void finishedWithUser(Login user) {
                    if (user != null) {
                        buyArticle(null);
                    }
                }
            }, true);
        }
    }

    private Callback<Acquire> mAcquiredCallback = new Callback<Acquire>() {
        @Override
        public void onResponse(Response<Acquire> response, Retrofit retrofit) {
            if (response.isSuccess()) {
                Acquire acquiredResponse = response.body();
                showSnackbarRefundable(acquiredResponse.getRefundable());
                doShowBuyButton(false);
                mIsAcquired = acquiredResponse.getAcquired();
                loadArticleDetails();
            } else if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
                new DialogBlendleLogin(ArticleDetailActivity.this, new DialogBlendleLogin.DialogLoginListener() {
                    @Override
                    public void finishedWithUser(Login user) {
                        if (user != null) {
                            buyArticle(null);
                        }
                    }
                }, false);
            } else if (response.code() == HttpURLConnection.HTTP_PAYMENT_REQUIRED) {
                showSnackbar(R.id.articleSnippet, R.string.payment_required);
                //TODO add action to web to pay?
            } else {
                showSnackbar(R.id.articleSnippet, R.string.whoepsie);
            }
        }

        @Override
        public void onFailure(Throwable t) {

        }
    };

    private void showSnackbarRefundable(Boolean refundable) {
        if (refundable) {
            showSnackbarWithAction(R.id.articleSnippet, R.string.article_acquired, R.string.article_acquired_undo, this);
        } else {
            showSnackbar(R.id.articleSnippet, R.string.article_acquired);
        }
    }

    private void doShowBuyButton(boolean doShown) {
        if (doShown) {
            mArticleBuyButton.setImageResource(R.drawable.ic_payment_white_24dp);
            mArticleBuyButton.show();
        } else {
            mArticleBuyButton.setImageResource(R.drawable.ic_done_white_24dp);
            if (!BuildConfig.DEBUG) {
                mArticleBuyButton.hide();
            }
        }
    }

    @Override
    public void onClick(View view) {
        mBlendleApi.deleteArticle(mUserCallback, mBlendleSharedPreferences.restoreUserId(), mArticleId);
    }

    private Callback<User> mUserCallback = new Callback<User>() {
        @Override
        public void onResponse(Response<User> response, Retrofit retrofit) {
            showSnackbar(R.id.articleSnippet, R.string.article_acquired_undo_success);
            mIsAcquired = false;
            loadArticleDetails();
            doShowBuyButton(true);
        }

        @Override
        public void onFailure(Throwable t) {
            showSnackbar(R.id.articleSnippet, R.string.whoepsie);
        }
    };
}

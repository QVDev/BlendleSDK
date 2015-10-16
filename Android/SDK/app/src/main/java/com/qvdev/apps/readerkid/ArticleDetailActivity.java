package com.qvdev.apps.readerkid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import distilledview.utils.qvdev.com.distilled.DistilledPagePrefs;
import distilledview.utils.qvdev.com.distilled.DistilledPagePrefsView;

public class ArticleDetailActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private TextView mArticleContentText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        loadBackdrop();

        Intent intent = getIntent();
        final String title = intent.getStringExtra(getString(R.string.intent_article_detail_title));
        initArticleTextView();
        loadSnippet(intent);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(title);
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
        mArticleContentText.setText(Html.fromHtml(snippet));
    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        String url = getIntent().getStringExtra(getString(R.string.intent_article_detail_image_url));
        Glide.with(this).load(url).centerCrop().into(imageView);
        loadTransition(imageView);
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
}

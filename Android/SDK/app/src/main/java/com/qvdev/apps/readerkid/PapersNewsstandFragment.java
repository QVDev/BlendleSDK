package com.qvdev.apps.readerkid;

import android.view.View;

import com.sdk.blendle.models.generated.newsstand.Newsstand;

import retrofit.Response;

public class PapersNewsstandFragment extends BaseNewsstandLocaleFragment {

    public static BaseNewsstandLocaleFragment newInstance() {
        PapersNewsstandFragment fragment = new PapersNewsstandFragment();
        return fragment;
    }

    public PapersNewsstandFragment() {
        // Required empty public constructor
    }

    @Override
    protected void loadArticles() {
        mBlendleApi.getMostRecentPapersNewsstand(this);
    }

    @Override
    protected void processResponse(Response<?> response) {
        Newsstand newsstandResponse = (Newsstand) response.body();
        mNextItems = null;
        transformToItemWrapper(newsstandResponse, true);
    }

    @Override
    public void onClick(View view) {
        //TODO implement navigation to all issues
    }
}

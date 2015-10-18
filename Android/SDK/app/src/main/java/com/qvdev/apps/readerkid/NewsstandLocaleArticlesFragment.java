package com.qvdev.apps.readerkid;

import com.sdk.blendle.models.generated.newsstand.Issue_;
import com.sdk.blendle.models.generated.newsstand.Newsstand;

import java.util.ArrayList;
import java.util.List;

import retrofit.Response;

public class NewsstandLocaleArticlesFragment extends BaseArticlesFragment {

    public static NewsstandLocaleArticlesFragment newInstance() {
        NewsstandLocaleArticlesFragment fragment = new NewsstandLocaleArticlesFragment();
        return fragment;
    }

    public NewsstandLocaleArticlesFragment() {
        // Required empty public constructor
    }

    @Override
    protected void loadArticles() {
        mBlendleApi.getMostRecentNewsstand(this);
    }

    @Override
    protected void processResponse(Response<?> response) {
        Newsstand newsstandResponse = (Newsstand) response.body();

        mNextItems = null;

        List<Object> manifestsToTransform = new ArrayList<>();
        for (Issue_ result : newsstandResponse.getEmbedded().getIssues()) {
            manifestsToTransform.add(result.getEmbedded().getManifest());
        }
        transformToCorrectManifestIfNeeded(manifestsToTransform.toArray());
    }

    @Override
    protected void loadMoreArticles() {
        if (mNextItems != null) {
            mBlendleApi.loadNextPopularArticles(this, mNextItems);
        }
    }
}

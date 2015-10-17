package com.qvdev.apps.readerkid;

import com.sdk.blendle.models.generated.popular.Item;
import com.sdk.blendle.models.generated.popular.Popular;

import java.util.ArrayList;
import java.util.List;

import retrofit.Response;

public class PopularArticlesFragment extends BaseArticlesFragment {

    public static PopularArticlesFragment newInstance() {
        PopularArticlesFragment fragment = new PopularArticlesFragment();
        return fragment;
    }

    public PopularArticlesFragment() {
        // Required empty public constructor
    }

    @Override
    protected void loadArticles() {
        mBlendleApi.getPopular(this);
    }

    @Override
    protected void processResponse(Response<?> response) {
        Popular popularResponse = (Popular) response.body();

        mNextItems = popularResponse.getLinks().getNext().getHref();

        List<Object> manifestsToTransform = new ArrayList<>();
        for (Item result : popularResponse.getEmbedded().getItems()) {
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

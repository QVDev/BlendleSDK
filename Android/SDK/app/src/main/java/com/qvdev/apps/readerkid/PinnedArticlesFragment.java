package com.qvdev.apps.readerkid;


import android.view.View;

import com.sdk.blendle.models.generated.pinned.Pinned;

import retrofit.Response;


public class PinnedArticlesFragment extends BaseArticlesFragment implements View.OnClickListener {

    public static PinnedArticlesFragment newInstance() {
        PinnedArticlesFragment fragment = new PinnedArticlesFragment();
        return fragment;
    }

    public PinnedArticlesFragment() {
        // Required empty public constructor
    }

    @Override
    protected void loadArticles() {
        mBlendleApi.getPinned(this, mBlendleApi.getUserId());
    }

    @Override
    protected void processResponse(Response<?> response) {
        Pinned pinnedResponse = (Pinned) response.body();
        mNextItems = null;
        transformToItemWrapper(pinnedResponse);
    }

    @Override
    protected void loadMoreArticles() {
        if (mNextItems != null) {
            mBlendleApi.loadNextArticles(this, mNextItems);
        }
    }
}

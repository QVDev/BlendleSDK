package com.qvdev.apps.readerkid;


import android.view.View;

import com.sdk.blendle.models.generated.search.Search;

import retrofit.Response;


public class SearchArticlesFragment extends BaseArticlesFragment implements View.OnClickListener {

    public static SearchArticlesFragment newInstance() {
        SearchArticlesFragment fragment = new SearchArticlesFragment();
        return fragment;
    }

    public SearchArticlesFragment() {
        // Required empty public constructor
    }

    @Override
    protected void loadArticles() {
        mBlendleApi.searchArticles(this, "Beautiful photos");
    }

    @Override
    protected void processResponse(Response<?> response) {
        Search searchResponse = (Search) response.body();
        mNextItems = searchResponse.getLinks().getNext().getHref();
        transformToItemWrapper(searchResponse);
    }

    @Override
    protected void loadMoreArticles() {
        if (mNextItems != null) {
            mBlendleApi.loadNextArticles(this, mNextItems);
        }
    }
}

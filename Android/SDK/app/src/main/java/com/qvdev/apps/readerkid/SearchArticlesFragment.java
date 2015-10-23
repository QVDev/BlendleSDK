package com.qvdev.apps.readerkid;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.sdk.blendle.models.generated.search.Search;

import retrofit.Response;


public class SearchArticlesFragment extends BaseArticlesFragment implements View.OnClickListener {

    private static final String SEARCH_ARGUMENT = "argument_search";
    private String mSearchQuery;

    public static SearchArticlesFragment newInstance(String searchQuery) {
        SearchArticlesFragment fragment = new SearchArticlesFragment();
        Bundle args = new Bundle();
        args.putString(SEARCH_ARGUMENT, searchQuery);
        fragment.setArguments(args);
        return fragment;
    }

    public SearchArticlesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSearchQuery = getArguments().getString(SEARCH_ARGUMENT);
            loadArticles();
        }
    }

    @Override
    protected void loadArticles() {
        if (!TextUtils.isEmpty(mSearchQuery)) {
            mBlendleApi.searchArticles(this, mSearchQuery);
        }
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

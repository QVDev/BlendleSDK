package com.qvdev.apps.readerkid;


import android.view.View;

import com.sdk.blendle.models.generated.search.Manifest;
import com.sdk.blendle.models.generated.search.Result;
import com.sdk.blendle.models.generated.search.Search;

import java.util.ArrayList;
import java.util.List;

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

        List<Manifest> allArticles = new ArrayList<>();
        for (Result result : searchResponse.getEmbedded().getResults()) {
            allArticles.add(result.getEmbedded().getItem().getEmbedded().getManifest());
        }
        onArticlesReady(allArticles);
    }

    @Override
    protected void loadMoreArticles() {
        if (mNextItems != null) {
            mBlendleApi.loadNextArticles(this, mNextItems);
        }
    }
}

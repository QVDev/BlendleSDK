package com.qvdev.apps.readerkid;

import com.qvdev.apps.readerkid.utils.ItemWrapper;
import com.sdk.blendle.models.generated.newspapers.Newspapers;
import com.sdk.blendle.models.generated.newsstand.Newsstand;

import java.util.Collections;
import java.util.List;

import retrofit.Response;

public class BaseNewsstandLocaleFragment extends BaseArticlesFragment {

    public static BaseNewsstandLocaleFragment newInstance() {
        BaseNewsstandLocaleFragment fragment = new BaseNewsstandLocaleFragment();
        return fragment;
    }

    public BaseNewsstandLocaleFragment() {
        // Required empty public constructor
    }

    @Override
    protected void loadArticles() {
        mBlendleApi.getMostRecentNewsstand(this);
    }

    @Override
    protected void processResponse(Response<?> response) {
        Newspapers newsstandResponse = (Newspapers) response.body();
        mNextItems = null;
        transformToItemWrapper(newsstandResponse);
    }

    @Override
    protected void loadMoreArticles() {
        if (mNextItems != null) {
            mBlendleApi.loadNextPopularArticles(this, mNextItems);
        }
    }
}

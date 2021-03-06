package com.qvdev.apps.readerkid;


import android.view.View;
import android.widget.ImageButton;

import com.qvdev.apps.readerkid.utils.ItemWrapper;
import com.sdk.blendle.models.generated.pinned.Pinned;
import com.sdk.response.EmptyResponse;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pinArticleButton:
                ItemWrapper item = getItemWrapper(view.getRootView().findViewById(R.id.card_view));
                mBlendleApi.pinItem(mEmptyResponseCallback, mBlendleApi.getUserId(), item.getId(), false);
                ImageButton pinButton = (ImageButton) view;
                pinButton.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
                int removalIndex = mArticles.indexOf(item);
                mArticles.remove(removalIndex);
                mAdapter.notifyItemRemoved(removalIndex);
                break;
            default:
                super.onClick(view);
        }
    }

    private Callback<EmptyResponse> mEmptyResponseCallback = new Callback<EmptyResponse>() {
        @Override
        public void onResponse(Response<EmptyResponse> response, Retrofit retrofit) {
        }

        @Override
        public void onFailure(Throwable t) {

        }
    };
}

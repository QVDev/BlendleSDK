package com.qvdev.apps.readerkid;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qvdev.apps.readerkid.utils.BlendleCredentialsApi;
import com.qvdev.apps.readerkid.utils.OnVerticalScrollListener;
import com.qvdev.apps.readerkid.utils.TransformManifestResult;
import com.sdk.blendle.models.generated.search.Body;
import com.sdk.blendle.models.generated.search.Manifest;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public abstract class BaseArticlesFragment extends Fragment implements View.OnClickListener, Callback, TransformManifestResult.TransformManifestCallback {

    protected BlendleCredentialsApi mBlendleApi;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    protected RecyclerView.Adapter mAdapter;
    protected List<Manifest> mArticles = new ArrayList<>();
    protected String mNextItems = null;


    public BaseArticlesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBlendleApi();
        if (savedInstanceState == null) {
            setRetainInstance(true);
            debugResponse(R.string.loading_articles);
            loadArticles();
        }
    }

    private void initBlendleApi() {
        mBlendleApi = new BlendleCredentialsApi(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base_article, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArticlesGrid(view);
    }

    private void initArticlesGrid(View rootView) {
        // Calling the RecyclerView
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        mLayoutManager = new StaggeredGridLayoutManager(getResources().getInteger(R.integer.articleColumns), 1);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ArticleGridAdapter(mArticles, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mOnVerticalScrollListener);
    }

    protected abstract void loadArticles();

    protected abstract void processResponse(Response<?> response);

    protected abstract void loadMoreArticles();

    private RecyclerView.OnScrollListener mOnVerticalScrollListener = new OnVerticalScrollListener() {
        @Override
        public void onScrolledToBottom() {
            super.onScrolledToBottom();
            debugResponse(R.string.loading_articles);
            loadMoreArticles();
        }
    };

    protected void debugResponse(int stringId) {
        if (mNextItems != null) {
            Snackbar.make(getActivity().findViewById(R.id.blendle_content), getString(stringId), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    @Override
    public void onClick(View view) {
        int position = mRecyclerView.getChildAdapterPosition(view);
        Manifest articleManifest = mArticles.get(position);

        View articleImage = view.findViewById(R.id.articleImage);
        Pair articleImagePair = Pair.create(articleImage, getString(R.string.transition_article_detail_image));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                getActivity(), articleImagePair);

        Intent intent = getArticleDetailsIntent(articleManifest);
        ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
    }

    @NonNull
    private Intent getArticleDetailsIntent(Manifest articleManifest) {
        String url = articleManifest.getImages().get(0).getLinks().getMedium().getHref();
        StringBuilder rawBodyText = new StringBuilder();
        String title = Html.fromHtml(articleManifest.getBody().get(0).getContent()).toString();
        for (Body body : articleManifest.getBody()) {
            rawBodyText.append(body.getContent());
            rawBodyText.append("<BR><BR>");
        }
        String snippet = rawBodyText.toString();
        String articleId = articleManifest.getId();

        Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
        intent.putExtra(getString(R.string.intent_article_detail_image_url), url);
        intent.putExtra(getString(R.string.intent_article_detail_title), title);
        intent.putExtra(getString(R.string.intent_article_detail_snippet), snippet);
        intent.putExtra(getString(R.string.intent_article_detail_id), articleId);
        return intent;
    }

    @Nullable
    protected void transformToCorrectManifestIfNeeded(Object[] result) {
        TransformManifestResult transformManifestResult = new TransformManifestResult(this);
        transformManifestResult.execute(result);
    }

    @Override
    public void onResponse(Response response, Retrofit retrofit) {
        processResponse(response);
    }

    @Override
    public void onFailure(Throwable t) {
        //TODO implement failure handling
    }

    @Override
    public void onArticlesReady(List<Manifest> articles) {
        mArticles.addAll(articles);
        mAdapter.notifyDataSetChanged();
    }
}

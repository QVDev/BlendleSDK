package com.qvdev.apps.readerkid;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import com.sdk.BlendleApi;
import com.sdk.blendle.models.generated.search.Body;
import com.sdk.blendle.models.generated.search.Manifest;
import com.sdk.blendle.models.generated.search.Result;
import com.sdk.blendle.models.generated.search.Search;

import java.util.ArrayList;
import java.util.List;


import com.qvdev.apps.readerkid.utils.OnVerticalScrollListener;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class BaseArticlesFragment extends Fragment implements View.OnClickListener {

    private BlendleApi mBlendleApi = new BlendleApi();

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private List<Manifest> mArticles = new ArrayList<>();
    private String mNextItems = null;

    public static BaseArticlesFragment newInstance() {
        BaseArticlesFragment fragment = new BaseArticlesFragment();
        return fragment;
    }

    public BaseArticlesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //TODO: Load the arguments if there any
        }
        if (savedInstanceState == null) {
            setRetainInstance(true);
            searchArticles("Beautiful photos");
        }
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

    private void setArticlesFromResponse(Response<Search> response) {
        Search apiResponse = response.body();
        debugResponse(apiResponse.getResults().toString());

        mNextItems = apiResponse.getLinks().getNext().getHref();

        List<Manifest> allArticles = new ArrayList<>();
        for (Result result : apiResponse.getEmbedded().getResults()) {
            allArticles.add(result.getEmbedded().getItem().getEmbedded().getManifest());
        }
        mArticles.addAll(allArticles);
        mAdapter.notifyDataSetChanged();
    }

    private void searchArticles(String query) {
        mBlendleApi.searchArticles(new Callback<Search>() {
            @Override
            public void onResponse(Response<Search> response, Retrofit retrofit) {
                setArticlesFromResponse(response);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, query);
    }

    private RecyclerView.OnScrollListener mOnVerticalScrollListener = new OnVerticalScrollListener() {
        @Override
        public void onScrolledToBottom() {
            super.onScrolledToBottom();
            loadMoreArticles();
        }
    };

    private void loadMoreArticles() {
        if (mNextItems != null) {
            mBlendleApi.loadNextArticles(new Callback<Search>() {
                @Override
                public void onResponse(Response<Search> response, Retrofit retrofit) {
                    setArticlesFromResponse(response);
                }

                @Override
                public void onFailure(Throwable t) {

                }
            }, mNextItems);
        }
    }

    private void debugResponse(String information) {
        Snackbar.make(getActivity().findViewById(R.id.blendle_content), information, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
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

        Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
        intent.putExtra(getString(R.string.intent_article_detail_image_url), url);
        intent.putExtra(getString(R.string.intent_article_detail_title), title);
        intent.putExtra(getString(R.string.intent_article_detail_snippet), snippet);
        return intent;
    }
}
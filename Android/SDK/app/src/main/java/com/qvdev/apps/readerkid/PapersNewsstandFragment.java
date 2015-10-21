package com.qvdev.apps.readerkid;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.qvdev.apps.readerkid.utils.ItemWrapper;

import java.util.ArrayList;
import java.util.List;

import retrofit.Response;

public class PapersNewsstandFragment extends BaseNewsstandLocaleFragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ArticleGridAdapter mCoverAdapter;
    private List<ItemWrapper> mCovers = new ArrayList<>();
    private String mCurrentIssueId = "";
    private String mLoadIssueId = "";
    private int mSubItemsCount = 0;

    public static BaseNewsstandLocaleFragment newInstance() {
        PapersNewsstandFragment fragment = new PapersNewsstandFragment();
        return fragment;
    }

    public PapersNewsstandFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initIssuesCover();
    }

    private void initIssuesCover() {
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view_issues);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mCoverAdapter = new ArticleGridAdapter(mCovers, this, R.layout.cover_item);
        mRecyclerView.setAdapter(mCoverAdapter);
    }

    @Override
    protected void loadArticles() {
        if (mCovers.isEmpty()) {
            loadCovers();
        } else {
            mBlendleApi.getIssue(this, mLoadIssueId, mSubItemsCount);
            mArticles.clear();
            mAdapter.notifyDataSetChanged();
        }
    }

    protected void loadCovers() {
        mBlendleApi.getMostRecentPapersNewsstand(this);
    }

    @Override
    protected void processResponse(Response<?> response) {
        mNextItems = null;
        transformToItemWrapper(response.body(), true);
    }

    @Override
    public void onArticlesReady(List<ItemWrapper> items) {
        if (mCovers.isEmpty()) {
            mCovers.addAll(items);
            mCoverAdapter.notifyDataSetChanged();
            loadIssueArticles(0);
        } else {
            super.onArticlesReady(items);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.coverItem:
                int position = mRecyclerView.getChildAdapterPosition(view);
                loadIssueArticles(position);
                break;
            default:
                super.onClick(view);
                break;
        }
    }

    private void loadIssueArticles(int position) {
        mLoadIssueId = mCovers.get(position).getId();
        if (TextUtils.isEmpty(mLoadIssueId) || mLoadIssueId != mCurrentIssueId) {
            mSubItemsCount = mCovers.get(position).getSubItemsCount();
            mCurrentIssueId = mLoadIssueId;
            InformSnackbar(R.string.loading_articles, true);
            loadArticles();
        }
    }

    @Override
    public void onDestroy() {
        mCovers.clear();
        mCoverAdapter.notifyDataSetChanged();
        super.onDestroy();
    }
}

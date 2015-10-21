package com.qvdev.apps.readerkid;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.qvdev.apps.readerkid.utils.ItemWrapper;

import java.util.List;

public class ArticleGridAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    protected List<ItemWrapper> mArticles;
    private View.OnClickListener mOnClickListener;
    private int mLayoutResId = R.layout.article_item;

    public ArticleGridAdapter(List<ItemWrapper> articles, View.OnClickListener onClickListener) {
        super();
        mArticles = articles;
        mOnClickListener = onClickListener;
    }

    public ArticleGridAdapter(List<ItemWrapper> articles, View.OnClickListener onClickListener, int layoutResIdId) {
        this(articles, onClickListener);
        mLayoutResId = layoutResIdId;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View articleView = LayoutInflater.from(viewGroup.getContext())
                .inflate(mLayoutResId, viewGroup, false);

        articleView.setOnClickListener(mOnClickListener);

        return new ArticleViewHolder(articleView);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder viewHolder, int i) {
        ItemWrapper item = mArticles.get(i);

        if (item.getTitle() != null) {
            viewHolder.articleSnippet.setText(Html.fromHtml(item.getTitle()));
        }

        Glide.with(viewHolder.articleImage.getContext())
                .load(item.getImageUrl(viewHolder.articleImage.getContext()))
                .into(viewHolder.articleImage);

        viewHolder.articleImage.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }
}

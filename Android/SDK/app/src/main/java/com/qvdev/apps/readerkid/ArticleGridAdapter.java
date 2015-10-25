package com.qvdev.apps.readerkid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
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
        Context context = viewHolder.articleImage.getContext();

        if (item.getTitle() != null) {
            viewHolder.articleSnippet.setText(Html.fromHtml(item.getTitle()));
        }

        viewHolder.articlePrice.setText(item.getPrice(context));
        viewHolder.articleWords.setText("" + item.getWords());
        viewHolder.articleFavorite.setText("" + item.getFavorite());
        viewHolder.articleDate.setText(item.getDate());
        viewHolder.pinArticleButton.setOnClickListener(mOnClickListener);
        viewHolder.pinArticleButton.setTag(i);

        if (item.isPinned()) {
            viewHolder.pinArticleButton.setImageResource(R.drawable.ic_bookmark_black_24dp);
        } else {
            viewHolder.pinArticleButton.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
        }

        String imageUrl = item.getImageUrl();
        if (!TextUtils.isEmpty(imageUrl)) {
            Glide.with(context)
                    .load(imageUrl)
                    .into(viewHolder.articleImage);
            viewHolder.articleImage.setVisibility(View.VISIBLE);
        } else {
            viewHolder.articleImage.setVisibility(View.GONE);
        }

        String providerImageUrl = item.getProviderImageUrl(context);
        if (!TextUtils.isEmpty(imageUrl)) {
            Glide.with(context)
                    .load(providerImageUrl)
                    .into(viewHolder.articleProviderImage);
            viewHolder.articleProviderImage.setVisibility(View.VISIBLE);
        } else {
            viewHolder.articleProviderImage.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }
}

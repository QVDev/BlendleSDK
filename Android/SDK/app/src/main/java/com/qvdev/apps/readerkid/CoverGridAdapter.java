package com.qvdev.apps.readerkid;

import android.text.Html;
import android.view.View;

import com.bumptech.glide.Glide;
import com.qvdev.apps.readerkid.utils.ItemWrapper;

import java.util.List;

public class CoverGridAdapter extends ArticleGridAdapter {

    public CoverGridAdapter(List<ItemWrapper> articles, View.OnClickListener onClickListener) {
        super(articles, onClickListener);
    }

    public CoverGridAdapter(List<ItemWrapper> articles, View.OnClickListener onClickListener, int layoutResIdId) {
        super(articles, onClickListener, layoutResIdId);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder viewHolder, int i) {
        ItemWrapper item = mArticles.get(i);

        if (item.getTitle() != null) {
            viewHolder.articleSnippet.setText(Html.fromHtml(item.getTitle()));
        }

        Glide.with(viewHolder.articleImage.getContext())
                .load(item.getImageUrl())
                .into(viewHolder.articleImage);

        viewHolder.articleImage.setVisibility(View.VISIBLE);
    }
}

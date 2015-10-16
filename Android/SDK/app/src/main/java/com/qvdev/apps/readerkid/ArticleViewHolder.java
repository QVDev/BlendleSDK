package com.qvdev.apps.readerkid;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class ArticleViewHolder extends RecyclerView.ViewHolder {

    public TextView articleSnippet;
    public ImageView articleImage;

    public ArticleViewHolder(View itemView) {
        super(itemView);
        articleSnippet = (TextView) itemView.findViewById(R.id.articleSnippet);
        articleImage = (ImageView) itemView.findViewById(R.id.articleImage);
    }
}

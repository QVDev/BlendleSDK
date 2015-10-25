package com.qvdev.apps.readerkid;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class ArticleViewHolder extends RecyclerView.ViewHolder {

    public ImageView articleProviderImage;
    public TextView articlePrice;
    public TextView articleDate;
    public TextView articleSnippet;
    public ImageView articleImage;
    public TextView articleWords;
    public TextView articleFavorite;
    public ImageButton pinArticleButton;

    public ArticleViewHolder(View itemView) {
        super(itemView);
        articleProviderImage = (ImageView) itemView.findViewById(R.id.articleProviderImage);
        articlePrice = (TextView) itemView.findViewById(R.id.articlePrice);
        articleDate = (TextView) itemView.findViewById(R.id.articleDate);
        articleSnippet = (TextView) itemView.findViewById(R.id.articleSnippet);
        articleImage = (ImageView) itemView.findViewById(R.id.articleImage);
        articleWords = (TextView) itemView.findViewById(R.id.articleWords);
        articleFavorite = (TextView) itemView.findViewById(R.id.articleFavorite);
        pinArticleButton = (ImageButton) itemView.findViewById(R.id.pinArticleButton);
    }
}

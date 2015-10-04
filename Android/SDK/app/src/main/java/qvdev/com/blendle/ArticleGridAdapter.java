package qvdev.com.blendle;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.sdk.blendle.models.generated.search.Manifest;

import java.util.List;

public class ArticleGridAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    List<Manifest> mArticles;

    public ArticleGridAdapter(List<Manifest> articles) {
        super();
        mArticles = articles;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.article_item, viewGroup, false);

        return new ArticleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder viewHolder, int i) {
        Manifest article = mArticles.get(i);
        viewHolder.articleSnippet.setText(Html.fromHtml(article.getBody().get(0).getContent()));

        if (!article.getImages().isEmpty()) {
            Glide.with(viewHolder.articleImage.getContext())
                    .load(article.getImages().get(0).getLinks().getMedium().getHref())
                    .into(viewHolder.articleImage);
            viewHolder.articleImage.setVisibility(View.VISIBLE);
        } else {
            viewHolder.articleImage.setImageDrawable(null);
            viewHolder.articleImage.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {

        return mArticles.size();
    }
}

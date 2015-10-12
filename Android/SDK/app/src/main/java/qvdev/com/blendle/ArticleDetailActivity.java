package qvdev.com.blendle;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ArticleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        loadTransition();
    }

    private void loadTransition() {
        ImageView image = (ImageView) findViewById(R.id.articleImage);
        Glide.with(this)
                .load(getIntent().getStringExtra(getString(R.string.transition_article_detail_image)))
                .into(image);

        ViewCompat.setTransitionName(image, getString(R.string.transition_article_detail_image));
    }
}

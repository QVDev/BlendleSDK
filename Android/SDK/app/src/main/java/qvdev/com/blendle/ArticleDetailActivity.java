package qvdev.com.blendle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ArticleDetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        loadBackdrop();

        Intent intent = getIntent();
        final String title = intent.getStringExtra(getString(R.string.intent_article_detail_snippet));

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(title);
    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        String url = getIntent().getStringExtra(getString(R.string.intent_article_detail_image_url));
        Glide.with(this).load(url).centerCrop().into(imageView);
        loadTransition(imageView);
        //TODO Load do color Palette.generateAsync() for title color change on the image
    }

    private void loadTransition(ImageView image) {
        ViewCompat.setTransitionName(image, getString(R.string.transition_article_detail_image));
    }
}

package blendle.sdk.qvdev.com.blendledemosdk;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sdk.BlendleApi;
import com.sdk.blendle.models.generated.search.Manifest;
import com.sdk.blendle.models.generated.search.Result;
import com.sdk.blendle.models.generated.search.Search;
import com.sdk.blendle.models.generated.user.User;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class BlendleActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    BlendleApi mBlendleApi = new BlendleApi();
    private OnClickListener mFabBlendleAction = new OnClickListener() {
        @Override
        public void onClick(View view) {
            searchArticles("Blendle");
        }
    };

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    private List<Manifest> mArticles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blendle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Debug blendle api", Snackbar.LENGTH_LONG)
                        .setAction("Execute", mFabBlendleAction).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getUser();
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initInfo();
        initArticlesGrid();
    }

    private void initInfo() {
        getUser();
        searchArticles("Beautiful Images");
    }

    private void initArticlesGrid() {
        // Calling the RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        mLayoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ArticleGridAdapter(mArticles);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void getUser() {
        mBlendleApi.getUser(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
                User userResponse = response.body();
                ((TextView) findViewById(R.id.userName)).setText(userResponse.getFullName());
                ((TextView) findViewById(R.id.userInfo)).setText(userResponse.getText());

                ImageView userImage = (ImageView) findViewById(R.id.imageView);
                Glide.with(BlendleActivity.this)
                        .load(userResponse.getLinks().getLargeAvatar().getHref())
                        .transform(new CircleTransform(BlendleActivity.this))
                        .into(userImage);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, "alexander");
    }

    private void searchArticles(String query) {
        mBlendleApi.searchArticles(new Callback<Search>() {
            @Override
            public void onResponse(Response<Search> response, Retrofit retrofit) {
                Search apiResponse = response.body();
                debugResponse(apiResponse.getResults().toString());

                List<Manifest> allArticles = new ArrayList<>();
                for (Result result : apiResponse.getEmbedded().getResults()) {
                    allArticles.add(result.getEmbedded().getItem().getEmbedded().getManifest());
                }
                mArticles.addAll(allArticles);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, query);
    }

    private void debugResponse(String information) {
        Snackbar.make(findViewById(R.id.fab), information, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.blendle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

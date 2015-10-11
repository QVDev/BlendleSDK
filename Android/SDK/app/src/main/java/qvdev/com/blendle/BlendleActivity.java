package qvdev.com.blendle;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sdk.BlendleApi;
import com.sdk.blendle.models.generated.user.User;

import qvdev.com.blendle.utils.CircleTransform;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class BlendleActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String CURRENT_FRAGMENT_TAG = "current_fragment_";
    private String mSelectedFragment = "";
    private BlendleApi mBlendleApi = new BlendleApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blendle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initDrawer(toolbar);
    }

    private void initDrawer(final Toolbar toolbar) {
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
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        navigationView.setNavigationItemSelectedListener(this);

        getUser();
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
        switch (item.getItemId()) {
            case R.id.nav_search:
                loadFragment(BaseArticleFragment.newInstance(), item.getItemId());
                break;
            case R.id.nav_gallery:
                break;
            case R.id.nav_slideshow:
                break;
            case R.id.nav_manage:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
            default:
                loadFragment(BaseArticleFragment.newInstance(), item.getItemId());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment, int tag) {
        if (!mSelectedFragment.contentEquals("" + tag)) {
            mSelectedFragment = "" + tag;
            getFragmentManager().beginTransaction().replace(R.id.blendle_content, fragment, CURRENT_FRAGMENT_TAG + tag).commit();
        }
    }
}

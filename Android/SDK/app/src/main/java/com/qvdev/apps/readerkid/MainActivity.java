package com.qvdev.apps.readerkid;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qvdev.apps.readerkid.utils.BaseBlendleCompatActivity;
import com.qvdev.apps.readerkid.utils.CircleTransform;
import com.qvdev.apps.readerkid.utils.DialogBlendleLogin;
import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.user.User;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends BaseBlendleCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DialogBlendleLogin.DialogLoginListener {

    private static final String CURRENT_FRAGMENT_TAG = "current_fragment_";
    private int mSelectedFragment = -99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blendle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initDrawer(toolbar, savedInstanceState != null);
        getMyAccount();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restorePossibleFragment(savedInstanceState);
        getMyAccount();
    }

    private void restorePossibleFragment(Bundle savedInstanceState) {
        boolean isRestored = false;
        if (savedInstanceState != null) {
            mSelectedFragment = savedInstanceState.getInt(CURRENT_FRAGMENT_TAG);
            isRestored = didRestoreFragment(mSelectedFragment);
        }

        if (!isRestored) {
            MenuItem defaultMenuItem = ((NavigationView) findViewById(R.id.nav_view)).getMenu().getItem(0);
            onNavigationItemSelected(defaultMenuItem);
        }
    }

    private boolean didRestoreFragment(int selectedFragment) {
        Fragment fragment;
        fragment = getFragmentManager().findFragmentByTag(CURRENT_FRAGMENT_TAG + selectedFragment);
        if (fragment != null) {
            getFragmentManager().beginTransaction().attach(fragment).commit();
        }
        return fragment != null;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_FRAGMENT_TAG, mSelectedFragment);
    }

    private void initDrawer(final Toolbar toolbar, boolean fromSavedInstance) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getMyAccount();
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (!fromSavedInstance) {
            MenuItem menuItem = navigationView.getMenu().findItem(R.id.nav_newsstand_locale);
            onNavigationItemSelected(menuItem);
            navigationView.setCheckedItem(menuItem.getItemId());
        }
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void getMyAccount() {
        final String myId = mBlendleSharedPreferences.restoreUserId();
        Login loggedInUser = mBlendleSharedPreferences.restoreStoredUser();

        if (loggedInUser.getRefreshToken() != null && myId != null) {
            mBlendleApi.getMyAccount(new Callback<User>() {
                @Override
                public void onResponse(Response<User> response, Retrofit retrofit) {
                    User userResponse = response.body();
                    if (response.isSuccess()) {
                        setUserData(null, userResponse);
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.e(getClass().getSimpleName(), t.getMessage());
                }
            }, myId);
        }
    }

    private void setUserData(Login loggedInUser, User userResponse) {
        String username = userResponse != null ? userResponse.getFullName() : loggedInUser.getEmbedded().getUser().getFullName();
        String balance = String.format(getString(R.string.user_balance), userResponse != null ? userResponse.getBalance() : loggedInUser.getEmbedded().getUser().getBalance());
        String avatarUrl = userResponse != null ? userResponse.getLinks().getLargeAvatar().getHref() : loggedInUser.getEmbedded().getUser().getLinks().getLargeAvatar().getHref();

        ((TextView) findViewById(R.id.userName)).setText(username);
        ((TextView) findViewById(R.id.userInfo)).setText(balance);

        ImageView userImage = (ImageView) findViewById(R.id.imageView);
        Glide.with(MainActivity.this)
                .load(avatarUrl)
                .transform(new CircleTransform(MainActivity.this))
                .into(userImage);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        if (!didRestoreFragment(item.getItemId())) {
            switch (item.getItemId()) {
                case R.id.nav_newsstand_locale:
                    loadFragment(BaseNewsstandLocaleFragment.newInstance(), item.getItemId());
                    break;
                case R.id.nav_papers_locale:
                    loadFragment(PapersNewsstandFragment.newInstance(), item.getItemId());
                    break;
                case R.id.nav_magazines_locale:
                    loadFragment(MagazinesNewsstandFragment.newInstance(), item.getItemId());
                    break;
                case R.id.nav_pinned:
                    loadFragment(PinnedArticlesFragment.newInstance(), item.getItemId());
                    break;
                case R.id.nav_popular:
                    loadFragment(PopularArticlesFragment.newInstance(), item.getItemId());
                    break;
                case R.id.nav_search:
                    loadFragment(SearchArticlesFragment.newInstance(), item.getItemId());
                    break;
                default:
                    loadFragment(SearchArticlesFragment.newInstance(), item.getItemId());
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment, int tag) {
        if (mSelectedFragment != tag) {
            mSelectedFragment = tag;
            getFragmentManager().beginTransaction().replace(R.id.blendle_content, fragment, CURRENT_FRAGMENT_TAG + tag).commit();
        }
    }

    public void loginClicked(View view) {
        new DialogBlendleLogin(this, this, true);
    }

    @Override
    public void finishedWithUser(Login loggedInUser) {
        if (loggedInUser != null) {
            setUserData(loggedInUser, null);
        }
    }
}
